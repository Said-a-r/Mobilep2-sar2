package org.ucb.appp1.Crypto.Presentation.viewmodel

sealed interface CryptoEffect {
    data class ShowToast(val message: String) : CryptoEffect
}