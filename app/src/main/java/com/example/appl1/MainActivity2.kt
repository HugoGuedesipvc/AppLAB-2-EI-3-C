package com.example.appl1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val value = intent.getStringExtra("Test")
        findViewById<TextView>(R.id.textView4).apply {
            text = value
        }

        val Button2 = findViewById<Button>(R.id.button2)
        Button2.setOnClickListener {
                finish()
        }


    }
}