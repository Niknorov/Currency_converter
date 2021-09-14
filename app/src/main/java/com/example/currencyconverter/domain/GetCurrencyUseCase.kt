package com.example.currencyconverter.domain

import com.example.currencyconverter.data.CurrencyRepository

class GetCurrencyUseCase(
    private val currencyRepository: CurrencyRepository
) {

   suspend fun getCurrency(): List<CurrencyModel> {

        return currencyRepository.getCurrency()
    }
}