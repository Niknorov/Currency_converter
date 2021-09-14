package com.example.currencyconverter.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currencyList: List<CurrencyEntity>)

    @Query("SELECT * FROM CurrencyEntity")
    suspend fun getCurrency(): List<CurrencyEntity>


}