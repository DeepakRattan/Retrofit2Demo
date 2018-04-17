package com.example.deepakrattan.retrofit2demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.deepakrattan.retrofit2demo.R;
import com.example.deepakrattan.retrofit2demo.model.Employee;

import java.util.ArrayList;

/**
 * Created by deepak.rattan on 10/16/2017.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Employee> employeeArrayList;

    public EmployeeAdapter(Context context, ArrayList<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_employee, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Employee employee = employeeArrayList.get(position);
        holder.txtName.setText(employee.getName());
        holder.txtPhone.setText(employee.getPhone());
        holder.txtEmail.setText(employee.getEmail());


    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtEmail, txtPhone;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtPhone = (TextView) itemView.findViewById(R.id.txtPhone);


        }
    }


}
