package com.example.android_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)
        val button = findViewById<Button>(R.id.btn_displayText)
        val textView = findViewById<TextView>(R.id.tv_text)

        val rd1= findViewById<RadioButton>(R.id.rd1)
        val rd2= findViewById<RadioButton>(R.id.rd2)

        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout1)
        val layout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Info")
            .setMessage("I am androiod developer")
            .setPositiveButton("ok") {dialog, _ ->
                Toast.makeText(this,"Called", Toast.LENGTH_SHORT)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        button.setOnClickListener {
            dialog.show()
            if (editText.text.toString().isEmpty()){
                layout1.setErrorIconDrawable(R.drawable.ic_baseline_error_outline_24)
                editText.error = " wrong"
            }else if (editText2.text.toString().isEmpty()){
                layout2.setErrorIconDrawable(R.drawable.ic_baseline_error_outline_24)
                editText.error = " wrong"
            }else{
                textView.text = "${editText.text.toString()}${editText2.text.toString()}"
            }
        }

        rd1.setOnClickListener {
            if (rd1.isChecked){
                rd2.isChecked =false
            }
        }

        rd2.setOnClickListener {
            if (rd2.isChecked){
                rd1.isChecked =false
            }
        }
    }
}

