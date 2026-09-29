package org.ucb.appp1.Crypto.Domain.repository

import org.ucb.appp1.Crypto.Domain.model.CryptoModel

interface CryptoRepository {
    suspend fun getCryptos():Result<List<CryptoModel>>
}