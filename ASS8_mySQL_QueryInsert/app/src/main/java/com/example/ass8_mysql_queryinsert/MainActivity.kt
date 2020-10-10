package com.example.ass8_mysql_queryinsert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var employeeList = arrayListOf<employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_Emp.setOnClickListener(){
            val intent = Intent(this,InsertMainActivity::class.java)
            startActivity(intent)
        }

        recycler_view.adapter = EmployeeAdepter(this.employeeList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
    }
    override fun onResume() {
        super.onResume()
        callEmployeedata()
    }
    fun callEmployeedata(){
        employeeList.clear()
        val serv: EmployeeAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeAPI::class.java)

        serv.retrieveemployee()
            .enqueue(object : Callback<List<employee>> {
                override fun onResponse(
                    call: Call<List<employee>>,
                    response: Response<List<employee>>
                ) {
                    response.body()?.forEach{
                        employeeList.add(employee(it.emp_name,it.emp_gender,it.emp_email,it.emp_salary))
                    }
                    recycler_view.adapter= EmployeeAdepter(employeeList,applicationContext)

                }

                override fun onFailure(call: Call<List<employee>>, t: Throwable) {
                    return t.printStackTrace()
                }
            })
    }

}
