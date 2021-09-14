package com.example.currencyconverter.presentation

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.data.CurrencyRepository
import com.example.currencyconverter.domain.CurrencyModel
import com.example.currencyconverter.domain.GetCurrencyUseCase
import kotlinx.coroutines.*


class CurrencyViewModel(
    private val getCurrencyUseCase: GetCurrencyUseCase
) : ViewModel() {


    val liveData = MutableLiveData<List<CurrencyModel>>()

    init {
        launchCurrencyLoad()
    }


    fun launchCurrencyLoad() {
        viewModelScope.launch {
            val currencyList = getCurrencyUseCase.getCurrency()
            liveData.postValue(currencyList)
        }
    }

}


