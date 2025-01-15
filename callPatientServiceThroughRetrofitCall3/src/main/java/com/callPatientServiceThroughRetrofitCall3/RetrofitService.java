package com.callPatientServiceThroughRetrofitCall3;

import java.util.List;

import org.springframework.stereotype.Component;

import retrofit2.Call;
import retrofit2.http.GET;

//@Component
public interface RetrofitService {
	
//	@GET("/")
//    Call<GET> getPatient();
	
	@GET("patient/patient")
	Call<List<Patient>> fetchPatients(); 

}
