package com.example.currencyconverter.data


import retrofit2.http.GET

interface CurrencyApi {

    @GET(value = "/daily_json.js")
   suspend fun getCurrency(): CurrencyListDTO

}