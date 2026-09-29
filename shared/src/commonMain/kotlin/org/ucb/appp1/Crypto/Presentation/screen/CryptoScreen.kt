package org.ucb.appp1.Crypto.Presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.appp1.Crypto.Presentation.viewmodel.CryptoEffect
import org.ucb.appp1.Crypto.Presentation.viewmodel.CryptoEvent
import org.ucb.appp1.Crypto.Presentation.viewmodel.CryptoViewModel

@Composable
fun CryptoScreen(viewModel: CryptoViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect) {
                is CryptoEffect.ShowToast -> {
                }
            }
        }
    }

    Column {
        TextField(value = state.value.name, onValueChange = {
            viewModel.emitEvent(CryptoEvent.OnNameChange(it)) })
        Button(onClick = { viewModel.emitEvent(CryptoEvent.OnSubmit) }) {
            Text("Busca")
        }
        state.value.crypto?.let { crypto ->
            Text(crypto.name)
            Text(crypto.symbol)
            Text(crypto.image)
            Text(crypto.currentPrice.toString())
            Text(crypto.priceChangePercentage24h.toString())
            Text(crypto.marketCap.toString())
            Text(crypto.marketCapRank.toString())
        }
    }
}