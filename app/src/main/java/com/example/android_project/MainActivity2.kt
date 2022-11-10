package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)

        btnGoToActivity3.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}
