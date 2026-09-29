package org.ucb.appp1.Crypto.Presentation.viewmodel

import org.ucb.appp1.Crypto.Domain.model.CryptoModel

data class CryptoState(

    val name: String = "",

    val crypto: CryptoModel? = null,

    val isLoading: Boolean = false
)