package org.ucb.appp1.Crypto.Data.mapper

import org.ucb.appp1.Crypto.Data.dto.CryptoDto
import org.ucb.appp1.Crypto.Domain.model.CryptoModel

fun CryptoDto.toDomain(): CryptoModel = CryptoModel(
    name = name ?: "",

    symbol = symbol ?: "",
    image = image ?: "",

    currentPrice = currentPrice ?: 0.0,
    priceChangePercentage24h = priceChangePercentage24h ?: 0.0,
    marketCap = marketCap ?: 0.0,
    marketCapRank = marketCapRank ?: 0
)