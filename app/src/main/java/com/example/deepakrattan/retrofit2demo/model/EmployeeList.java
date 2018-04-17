package com.example.deepakrattan.retrofit2demo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EmployeeList {
    @SerializedName("employeeList")
    ArrayList<Employee> employeeArrayList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }
}
