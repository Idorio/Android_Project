package com.example.android_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.android_project.KotlinActivity.Companion.startKotlinAct
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val email = findViewById<EditText>(R.id.email)
        val pass = findViewById<EditText>(R.id.pass)
        val btn_show = findViewById<Button>(R.id.btn_displayText)
        val layoutEmail = findViewById<TextInputLayout>(R.id.inputEmail)
        val layoutPass = findViewById<TextInputLayout>(R.id.inputPass)
        val outPut = findViewById<MaterialTextView>(R.id.tv_text)

        val rb1 = findViewById<RadioButton>(R.id.rd1)
        val rb2 = findViewById<RadioButton>(R.id.rd2)

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
            if (email.text.toString().isEmpty()) {
                layoutEmail.error
                layoutEmail.helperText = "Lol"
                Toast.makeText(
                    this, "email can't be empty",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (email.text.toString().isEmpty()) {
                Toast.makeText(
                    this, "password can't be empty",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                outPut.text = "${email.text.toString()}" + "${pass.text.toString()}"
            }
            dialog.show()
        }
        val btnGoTo = findViewById<Button>(R.id.goToFFirst)
        btnGoTo.setOnClickListener {
            startKotlinAct(this)
        }
    }
}

