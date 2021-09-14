package com.example.currencyconverter.data

import com.google.gson.annotations.SerializedName

data class CurrencyListDTO(
    @SerializedName("Date") val date: String,
    @SerializedName("PreviousDate") val previousDate: String,
    @SerializedName("PreviousURL") val previousURL: String,
    @SerializedName("Timestamp") val timestamp: String,
    @SerializedName("Valute") val valute: Map<String, CurrencyDTO>,
)
data class CurrencyDTO(

    @SerializedName("ID")  var id: String,
    @SerializedName("NumCode") var numCode: Int,
    @SerializedName("CharCode") var charCode: String,
    @SerializedName("Nominal") var nominal: Int,
    @SerializedName("Name") var name: String,
    @SerializedName("Value") var value: Double,
    @SerializedName("Previous") var previous: Double
)
