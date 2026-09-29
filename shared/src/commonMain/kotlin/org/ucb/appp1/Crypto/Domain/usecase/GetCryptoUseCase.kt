package org.ucb.appp1.Crypto.Domain.usecase

import org.ucb.appp1.Crypto.Domain.model.CryptoModel
import org.ucb.appp1.Crypto.Domain.repository.CryptoRepository



class GetCryptosUseCase(
    val repository: CryptoRepository
) {
    suspend fun invoke(): Result<List<CryptoModel>> {
        return repository.getCryptos()
    }
}