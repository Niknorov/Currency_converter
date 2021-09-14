package com.example.currencyconverter.di


import android.content.Context
import androidx.room.Room
import com.example.currencyconverter.data.*
import com.example.currencyconverter.domain.GetCurrencyUseCase
import com.example.currencyconverter.presentation.CurrencyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val currencyModule = module {
    single { createDataBase(get()) }
    single { createCurrencyDao(get()) }
    single { CurrencyRemoteDataSource(createCurrencyApi()) }
    single { CurrencyLocalDataSource(get()) }
    single { CurrencyRepository(get(),get()) }
    single { GetCurrencyUseCase(get()) }
    viewModel { CurrencyViewModel(get()) }
}

fun createCurrencyApi(): CurrencyApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://www.cbr-xml-daily.ru")
        .build()
    return retrofit.create(CurrencyApi::class.java);

}

fun createDataBase(context: Context): AppDataBase {
    return Room.databaseBuilder(context, AppDataBase::class.java, "database")
        .build()
}

fun createCurrencyDao(dataBase: AppDataBase): CurrencyDao {
    return dataBase.createCurrencyDao()
}
