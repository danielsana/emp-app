package com.example.emp_app

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

class viewEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val progressbar = findViewById<ProgressBar>(R.id.progress)
//        api
        val api ="https://modcomlab2.pythonanywhere.com/employees"
//        helper
        val helper = ApiHelper(applicationContext)

        helper.get(api, object:ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                //Convert the GET results to JSON Array
                val employeeJSONArray = JSONArray(result.toString())
                //Loop Each Object in the JSONArray
                (0 until employeeJSONArray.length()).forEach {
                    val employee = employeeJSONArray.getJSONObject(it)
                    //For each Object Find the TextView and Append the 5 C0lumns
                    val empdata = findViewById<TextView>(R.id.empdata)
                    empdata.append("Username:"+employee.get("username")+"\n")
                    empdata.append("Email:"+employee.get("email")+"\n")
                    empdata.append("Department:"+employee.get("department")+"\n")
                    empdata.append("\n\n")
                }
                //Stop Progress from Loading
                progressbar.visibility = View.GONE
            }
        })
    }
}