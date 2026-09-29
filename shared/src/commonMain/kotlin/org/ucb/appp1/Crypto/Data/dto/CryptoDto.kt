package org.ucb.appp1.Crypto.Data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoDto(
    val name: String? = null,
    val symbol: String? = null,
    val image: String? = null,

    @SerialName("current_price")
    val currentPrice: Double? = null,

    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = null,

    @SerialName("market_cap")
    val marketCap: Double? = null,

    @SerialName("market_cap_rank")
    val marketCapRank: Int? = null

)