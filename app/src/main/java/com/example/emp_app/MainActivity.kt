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
        val btnViewEmployee = findViewById<Button>(R.id.btnViewEmployee)

        btnAddEmployee.setOnClickListener {
            startActivity(Intent(this, AddEmployeeActivity::class.java))
        }

        btnViewEmployee.setOnClickListener {
            startActivity(Intent(this, ViewEmployeesActivity::class.java))
        }
    }
}