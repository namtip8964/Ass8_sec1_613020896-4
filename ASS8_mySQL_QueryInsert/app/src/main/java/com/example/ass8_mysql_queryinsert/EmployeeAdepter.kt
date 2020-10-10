package com.example.ass8_mysql_queryinsert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdepter (val item :List<employee>,val context: Context): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout,parent,false)
        return ViewHolder(view_item)
}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.empName.text="Name: "+item[position].emp_name
        holder.empGender.text ="Gender:"+item[position].emp_gender
        holder.empEmail.text ="E-mail: "+item[position].emp_email
        holder.empSalary.text = "Salary :"+item[position].emp_salary.toString()
    }

    override fun getItemCount(): Int {
        return item.size
    }

}