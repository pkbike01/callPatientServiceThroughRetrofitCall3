package com.callPatientServiceThroughRetrofitCall3;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RetrofitCall {
	
	
	public static List<Patient> executeSavePatient() {
	    RetrofitService retrofitService = RetrofitConfig.createCorePatientService(RetrofitService.class);
	    try {
	        Call<List<Patient>> fetchPatients = retrofitService.fetchPatients();
	        System.out.println(fetchPatients);

	        Response<List<Patient>> response = fetchPatients.execute();
	        System.out.println(response);

	        if (response.isSuccessful() && response.code() == 200) {
	            List<Patient> patients = response.body();
	            System.out.println(patients);

	            if (patients != null && !patients.isEmpty()) {
	                // Create a new list to avoid mutating the original list
	                List<Patient> copiedPatients = new ArrayList<>(patients);
	                return copiedPatients;
	            } else {
	                // Handle empty response appropriately
	                return new ArrayList<>();
	            }
	        } else {
	            // Handle unsuccessful response appropriately
	            System.out.println("error");
	        }
	    } catch (Exception e) {
	        // Handle exceptions appropriately
	        //logger.error(e);
	        e.printStackTrace();
	    }
	    return new ArrayList<>();
	}
	
}
