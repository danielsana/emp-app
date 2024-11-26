package com.example.emp_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddEmployee = findViewById<Button>(R.id.btnAddEmployee)
        btnAddEmployee.setOnClickListener {
            val addemployee = Intent(applicationContext,addEmployee::class.java)
            startActivity(addemployee)
        }

        val btnViewEmployee = findViewById<Button>(R.id.btnViewEmployee)
        btnViewEmployee.setOnClickListener {
            val addemployee = Intent(applicationContext,viewEmployee::class.java)
            startActivity(addemployee)
        }
    }
}