package com.example.deepakrattan.retrofit2demo.newtwork;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    //Here i want to use the API http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123
    // to get the JSON data

    public static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";
    private static Retrofit retrofit;
    //This method will provide the Retrofit instance
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
