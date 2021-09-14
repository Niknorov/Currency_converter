package com.example.currencyconverter.data

class CurrencyRemoteDataSource(
    private val currencyApi: CurrencyApi
) {

    suspend fun getCurrency(): CurrencyListDTO {
        return currencyApi.getCurrency()
    }


}


