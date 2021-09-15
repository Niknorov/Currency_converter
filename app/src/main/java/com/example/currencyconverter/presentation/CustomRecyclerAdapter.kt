package com.example.currencyconverter.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.domain.CurrencyModel
import com.example.currencyconverter.domain.GetCurrencyUseCase

class CustomRecyclerAdapter(private val currencies: List<CurrencyModel>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    var onItemClick: ((CurrencyModel) -> Unit)? = null


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currencyName: TextView? = null
        var currencyValue: TextView? = null
        var currencyCharCode: TextView? = null
        var currencyNominal: TextView? = null

        init {
            currencyName = itemView.findViewById(R.id.currencyName)
            currencyValue = itemView.findViewById(R.id.currencyValue)
            currencyCharCode = itemView.findViewById(R.id.currencyCharCode)
            currencyNominal = itemView.findViewById(R.id.currencyNominal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.currencyName?.text = currencies[position].name
        holder.currencyValue?.text = currencies[position].value.toString()
        holder.currencyCharCode?.text = currencies[position].charCode
        holder.currencyNominal?.text = currencies[position].nominal.toString()
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currencies[position])
        }
    }

    override fun getItemCount() = currencies.size

}