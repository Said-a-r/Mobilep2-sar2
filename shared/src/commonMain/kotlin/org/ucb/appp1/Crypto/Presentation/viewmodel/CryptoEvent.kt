package org.ucb.appp1.Crypto.Presentation.viewmodel

sealed interface CryptoEvent{

    data class OnNameChange(val value: String) : CryptoEvent

    object OnSubmit : CryptoEvent

}