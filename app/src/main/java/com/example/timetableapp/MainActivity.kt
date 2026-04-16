package com.example.timetableapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResults)

        btnCalculate.setOnClickListener {
            val input = edtNumber.text.toString()

            if (input.isEmpty()){
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val number = input.toInt()
            var result = ""

            for (i in 1..10){
                result += "$number x $i = ${number * i}"
            }

            txtResult.text = result
        }

        btnClear.setOnClickListener {
            edtNumber.text.clear()
            txtResult.text = ""
        }





















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}