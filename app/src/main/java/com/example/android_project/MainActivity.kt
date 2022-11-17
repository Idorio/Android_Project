package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android_project.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.color)))
//        supportActionBar?.title = "New title fot MainActivity"

        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)
        val button = findViewById<Button>(R.id.btn_displayText)
        val textView = findViewById<TextView>(R.id.tv_text)

        button.setOnClickListener {
            textView.text = "${editText.text.toString()}${editText2.text.toString()}"
        }
    }
}
