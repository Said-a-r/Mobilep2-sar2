package org.ucb.appp1.Crypto.Data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.ucb.appp1.Crypto.Data.dto.CryptoDto
import org.ucb.appp1.crypto.data.datasource.CryptoRemoteDataSource

class CryptoApiService : CryptoRemoteDataSource {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    override suspend fun getCryptos(): List<CryptoDto> {
        val response = client.get("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd")
        try {
            return response.body<List<CryptoDto>>()
        } catch (e: Exception) {
            throw e
        }
    }
}