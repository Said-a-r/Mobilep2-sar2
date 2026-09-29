package org.ucb.appp1.Crypto.Data.repository

import org.ucb.appp1.Crypto.Data.mapper.toDomain
import org.ucb.appp1.Crypto.Domain.model.CryptoModel
import org.ucb.appp1.Crypto.Domain.repository.CryptoRepository
import org.ucb.appp1.crypto.data.datasource.CryptoRemoteDataSource

class CryptoRepositoryImpl(val dataSource: CryptoRemoteDataSource) : CryptoRepository { override suspend fun getCryptos(): Result<List<CryptoModel>> {
        return Result.success(dataSource.getCryptos().map { it.toDomain() })
    }
}