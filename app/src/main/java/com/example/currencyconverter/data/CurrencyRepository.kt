package com.example.currencyconverter.data

import com.example.currencyconverter.domain.CurrencyModel
import java.lang.Exception

class CurrencyRepository(
    val currencyRemoteDataSource: CurrencyRemoteDataSource,
    val currencyLocalDataSource: CurrencyLocalDataSource

) {


    suspend fun getCurrency(): List<CurrencyModel> {
        try {
            val currencyEntityList = currencyRemoteDataSource.getCurrency().valute.map {
                CurrencyEntity(
                    it.value.id,
                    it.value.numCode,
                    it.value.charCode,
                    it.value.nominal,
                    it.value.name,
                    it.value.value,
                    it.value.previous
                )
            }


            currencyLocalDataSource.insertCurrency(currencyEntityList)
            return currencyEntityList.map {
                CurrencyModel(
                    it.id,
                    it.numCode,
                    it.charCode,
                    it.nominal,
                    it.name,
                    it.value,
                    it.previous
                )
            }
        } catch (e: Exception) {
            return currencyLocalDataSource.getCurrency().map {
                CurrencyModel(
                    it.id,
                    it.numCode,
                    it.charCode,
                    it.nominal,
                    it.name,
                    it.value,
                    it.previous
                )
            }
        }

    }
}