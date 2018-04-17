# Retrofit2Demo
This project demonstrates the use of Retrofit 2 developed by Square to handle REST API calls.
Here i want to hit the API "http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=100" 

where BASE_URL = "http://navjacinth9.000webhostapp.com/json/" 

and end point is "retrofit-demo.php".

Step 1:

Add the following dependency to app level gradle file

compile 'com.squareup.retrofit2:retrofit:2.1.0'

compile 'com.squareup.retrofit2:converter-gson:2.1.0'

Step 2:

Add internet permission to Android Manifest.xml

 
uses-permission android:name="android.permission.INTERNET" 

Step 3 : Create 4 sub packages activity, adapter, model and network

Step 4 :

By analysing of the above JSON response we can see that it contains a JSON array name ‘employeeList’ which in turn contains multiple JSON objects each of which hold employee details.

To recieve this JSON we will need two model classes one for the JSON Array and the other for each JSON object.

Add two new file inside your model subpackage ‘Employee.java’ and the other ‘EmployeeList.java’

Step 5 :

In this project i have created a network package containing one class named APIClient and an interface APIInterface

APIClient class contains BASE URL and a method that provide the Retrofit instance.



Step 6 : Now add an interface into the same network package and name it “APIInterface.java”. In this file we will use the @GET annotation provided by Retrofit Library, to which we will pass the end point or filename that will provide the JSON data.

Next we will create a method which will have return type of Call<Type>. In our case we will use the model class created earlier as type like Call<EmployeeList>.

We will also use the @Query annotation to attach the values sent to this method as url parameters in our case it’s company number. 

APIInterface uses end point "retrofit-demo.php" inside @GET annotation and a method that returns a POJO corresponding to JSON response after hitting the API
