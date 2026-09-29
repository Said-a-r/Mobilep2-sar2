package org.ucb.appp1.Crypto.Presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ucb.appp1.Crypto.Domain.usecase.GetCryptosUseCase

class CryptoViewModel(
    val getCryptosUseCase: GetCryptosUseCase
): ViewModel() {
    private val _state = MutableStateFlow<CryptoState>(CryptoState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<CryptoEffect>()
    val effect = _effect.asSharedFlow()

    fun emitEvent(event: CryptoEvent) {
        when(event) {
            is CryptoEvent.OnNameChange -> {
                _state.update { it.copy(name = event.value) }
            }
            CryptoEvent.OnSubmit -> {
                _state.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    getCryptosUseCase.invoke().fold(
                        onSuccess = { cryptos ->
                            val found = cryptos.find {
                                it.name.equals(_state.value.name, ignoreCase = true)
                            }
                            _state.update {
                                it.copy(isLoading = false, crypto = found)
                            }
                        },
                        onFailure = {
                            _state.update { it.copy(isLoading = false) }
                        }
                    )
                }
            }
        }
    }

    private fun emitEffect(effect: CryptoEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}