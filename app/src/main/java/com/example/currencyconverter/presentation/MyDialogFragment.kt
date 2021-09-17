package com.example.currencyconverter.presentation


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.internal.illegalDecoyCallException
import androidx.fragment.app.DialogFragment
import com.example.currencyconverter.R
import com.example.currencyconverter.domain.CurrencyModel
import java.lang.NumberFormatException


class MyDialogFragment(val currencyModel: CurrencyModel) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = it.layoutInflater
            val view = inflater.inflate(R.layout.dialog_layout, null)
            val textView: TextView = view.findViewById(R.id.textview)
            val editText: EditText = view.findViewById(R.id.input)
            val button: Button = view.findViewById(R.id.button)
            button.setOnClickListener {
                try {
                    val result = currencyModel.value * editText.text.toString().toDouble()
                    textView.text = result.toString()
                } catch (e: NumberFormatException) {
                    val text = "Некорректный ввод"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration)
                    toast.show()
                }

            }
            builder.setView(view)
            builder.create()
        } ?: throw illegalDecoyCallException("Activity cannot be null")
    }

}
