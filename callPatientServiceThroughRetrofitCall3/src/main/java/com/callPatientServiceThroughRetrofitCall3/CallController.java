package com.callPatientServiceThroughRetrofitCall3;

//import java.net.http.HttpResponse;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//import retrofit2.Call;
//import retrofit2.Response;
//import retrofit2.http.GET;

@RestController
public class CallController {

	
	Logger logger = LoggerFactory.getLogger(CallController.class);
	
	@GetMapping("/pat")
	public ResponseEntity<?> patientsList(){
		try {
			List<Patient> pat = RetrofitCall.executeSavePatient();
			List.of(4,5);
			return new ResponseEntity<>(pat,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("error in call!!!",HttpStatus.OK);
	}
}