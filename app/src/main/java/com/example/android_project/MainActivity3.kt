package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
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

        val ed_text = findViewById<EditText>(R.id.et_text)
        val edit_text = findViewById<EditText>(R.id.et_text2)
        val btn_show = findViewById<Button>(R.id.btn_displayText)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val layout1 = findViewById<TextView>(R.id.tv_text)

        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)

        rb1.setOnClickListener {
            if (rb1.isChecked) {
                rb2.isChecked = false

            } else {
                rb1.isChecked = true
            }
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }
            val dialog = AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("Message")
                .setCancelable(false)
                .setPositiveButton("Ok") { dialog, _ ->
                    Toast.makeText(this, "called pisitive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.cancel()
                }

            btn_show.setOnClickListener {
                dialog.show()

//                if (ed_text.text.toString().isEmpty()){
//                    layout1.setErrorIcon
//                }
//                    Toast.makeText(this,"emal can't be empty",Tosat.LEGTH_SHORT).show()
//                   else if (edit_text.text.toString().isEmpty){
//                        Toast.makeText(this,"password can't be empty",Tosat.LEGTH_SHORT).show()
//                }
//                    else{
//                tv_text.text = "${ed_text.text.toString()}" + "${edit_text.text.toString()}"
//            }
                val btnGoTo = findViewById<Button>(R.id.btnGoToActivity1)
                btnGoTo.setOnClickListener {
                    startActivity(
                        Intent("com.example.koltin.OPEN_FIRST_ACTIVITY")
                    )
                }
            }
        }
    }
}

