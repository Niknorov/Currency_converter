package com.example.currencyconverter.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.currencyconverter.R
import com.example.currencyconverter.domain.CurrencyModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val BASE_URL = "https://www.cbr-xml-daily.ru"

class MainActivity : AppCompatActivity() {

    val viewModel: CurrencyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipeRefresh)
        swipeRefresh.setOnRefreshListener {
            viewModel.launchCurrencyLoad()
        }
// recyclerView
        val currencyRecyclerView: RecyclerView = findViewById(R.id.currencyRecyclerView)
        currencyRecyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.liveData.observe(
            this
        ) {

            swipeRefresh.isRefreshing = false
            val adapter = CustomRecyclerAdapter(it)
            adapter.onItemClick = {
                val myDialogFragment = MyDialogFragment(it)
                val manager = supportFragmentManager
                myDialogFragment.show(manager, "myDialog")
            }
            currencyRecyclerView.adapter = adapter
        }

    }
}