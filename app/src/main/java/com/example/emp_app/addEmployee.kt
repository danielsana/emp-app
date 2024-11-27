package com.example.emp_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class addEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        acces the edittexts
        val username = findViewById<EditText>(R.id.etUsername)
        val email = findViewById<EditText>(R.id.etEmail)
        val department = findViewById<EditText>(R.id.etDepartment)

        val submit = findViewById<Button>(R.id.btnSubmit)
        submit.setOnClickListener {
            //Create a JSON Object that will Hold input values from Edit Texts.
            val body = JSONObject()
            //add id_number,username,others,salary, department to json object as body
            body.put("username", username.text.toString())
            body.put("email", email.text.toString())
            body.put("department", department.text.toString())

            //Base API URL/End Point
            val api = "https://modcomlab2.pythonanywhere.com/employees"
            //Access helper
            //Trigger the post function in helper class
            // We provide the api link and data body.
            val helper = ApiHelper(applicationContext)
            //Post the body with your data/employees details to our api endpoint
            helper.post(api, body)
        }
    }
}