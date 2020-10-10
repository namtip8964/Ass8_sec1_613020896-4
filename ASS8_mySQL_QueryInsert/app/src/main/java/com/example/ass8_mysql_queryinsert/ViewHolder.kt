package com.example.ass8_mysql_queryinsert

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.emp_item_layout.view.*

class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val empName = view.emp_name
    val empGender = view.emp_gender
    val empEmail = view.emp_gmail
    val empSalary = view.emp_salary
}