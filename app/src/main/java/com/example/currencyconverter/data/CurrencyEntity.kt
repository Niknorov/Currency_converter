package com.example.currencyconverter.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CurrencyEntity(


    @PrimaryKey
    var id: String,
    var numCode: Int,
    var charCode: String,
    var nominal: Int,
    var name: String,
    var value: Double,
    var previous: Double
)