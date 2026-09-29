package org.ucb.appp1.Crypto.Domain.model

data class CryptoModel(


    val name: String,

    val symbol: String,
    val image: String,

    val currentPrice: Double,
    val priceChangePercentage24h: Double,

    val marketCap: Double,
    val marketCapRank: Int


)