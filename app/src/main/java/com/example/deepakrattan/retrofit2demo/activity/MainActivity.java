package com.example.deepakrattan.retrofit2demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.deepakrattan.retrofit2demo.R;
import com.example.deepakrattan.retrofit2demo.adapter.EmployeeAdapter;
import com.example.deepakrattan.retrofit2demo.model.Employee;
import com.example.deepakrattan.retrofit2demo.model.EmployeeList;
import com.example.deepakrattan.retrofit2demo.newtwork.APIClient;
import com.example.deepakrattan.retrofit2demo.newtwork.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //We are interested in hitting the following API
    // http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123
    private APIInterface apiInterface;
    private ArrayList<Employee> employeeArrayList;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private EmployeeAdapter adapter;
    public static final String TAG = "RetrofitDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById
        rv = (RecyclerView) findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);


        /*Create handle for the APIInterface interface*/
        apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<EmployeeList> call = apiInterface.getEmployeeData(100);
        //log the URL called
        Log.e(TAG, call.request().url() + "");
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                EmployeeList employeeList = response.body();
                employeeArrayList = employeeList.getEmployeeArrayList();
                adapter = new EmployeeAdapter(MainActivity.this, employeeArrayList);
                rv.setAdapter(adapter);
                /*for (int i = 0; i < employeeArrayList.size(); i++) {
                    Employee employee = employeeArrayList.get(i);
                    String name = employee.getName();
                    Log.d(TAG, "onResponse: " + name);
                }*/
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });


    }
}
