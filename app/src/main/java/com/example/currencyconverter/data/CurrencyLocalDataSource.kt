package com.example.currencyconverter.data

class CurrencyLocalDataSource(
    private val currencyDao: CurrencyDao
) {

    suspend fun getCurrency(): List<CurrencyEntity> {
        return currencyDao.getCurrency()
    }

    suspend fun insertCurrency(currencyList: List<CurrencyEntity>) {
        currencyDao.insertCurrency(currencyList)
    }
}
