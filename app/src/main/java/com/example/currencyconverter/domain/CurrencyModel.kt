package com.example.currencyconverter.domain


data class CurrencyModel (
    var id: String,
    var numCode: Int,
    var charCode: String,
    var nominal: Int,
    var name: String,
    var value: Double,
    var previous: Double
)