package com.example.android_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val btnKot = findViewById<Button>(R.id.kotBtn)

        val person = object {
            val name = "Andrei"
            fun develop() {
                Log.w("anomym class", "called develop fun Developer")
            }
        }

        val person2 = object : Developer {
            val name = "Andrei"
            override fun develop() {
                Log.w("anomym class", "called develop fun")
            }
        }


        val house = HouseBuilder.Builder
            .setStock(12)
            .setPool(true)
            .buildHouse()
        btnKot.setOnClickListener {
            Log.w("house builder","@${house.hasSwimmingPool()} ${house.howManyStock()}")
            callAnnonymClass(object : Developer {
                override fun develop() {
                    Log.w("anomym class", "called develop fun Developer")
                }

            })
            callAnnonymClass(person2)
            person.name
            person.develop()
            person2.develop()
            returnAnnonymClass("string").develop()
            Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
        }

        makeRequest("https://google.com") { callBackResult ->
            Log.w("callBackResult", callBackResult)
        }

        val lambda = { string: String ->
            Toast.makeText(
                this, "your text is $string",
                Toast.LENGTH_SHORT
            ).show()
        }
        lambda("Set text im lambda")
    }

    fun makeRequest(url: String, argForCallBack: (string: String) -> Unit) {
        argForCallBack.invoke("callBAckResult $url")
    }

    fun callAnnonymClass(developer: Developer) {
        developer.develop()
    }


    private fun returnAnnonymClass(string: String) = object {
        fun develop() {
            Log.w("annomyme class", "called develop fun from returnType $string")
        }
    }
    companion object{
        fun startKotlinAct(context: Context){
            val intent = Intent(context,KotlinActivity::class.java)
            context.startActivity(intent)
        }
    }

}
interface Developer {
    fun develop()
}