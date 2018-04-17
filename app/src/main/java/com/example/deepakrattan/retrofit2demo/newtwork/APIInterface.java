package com.example.deepakrattan.retrofit2demo.newtwork;

import com.example.deepakrattan.retrofit2demo.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    //Inside the @Get annotation we need to pass the end point
    // to get the JSON Data

    @GET("retrofit-demo.php")
        //create a method which will have return type of Call<Type>
        //Here we will Specify the Model class EmployeeList
        //also use the @Query annotation to attach the values sent to this
        // method as url parameters in our case it’s company number
    Call<EmployeeList> getEmployeeData(@Query("company_no") int companyNo);
}
