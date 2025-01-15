package com.callPatientServiceThroughRetrofitCall3;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	
	
	@GetMapping("/home")
	public String welcomePage() {
		return "welcome to retrofit concept!!!";
	}

}
