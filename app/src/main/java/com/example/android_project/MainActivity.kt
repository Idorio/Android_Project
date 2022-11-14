package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.android_project.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.color)))
        supportActionBar?.title = "New title fot MainActivity"

        supportActionBar?.setIcon(R.drawable.price)

        val textView = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.Button)


        btn.setOnClickListener{
            textView.text = getString(R.string.hello_world)
            startMainActivity2(this, textView.text.toString()+ getString(R.string.activiti))


        }

    }
}