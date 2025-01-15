package com.callPatientServiceThroughRetrofitCall3;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/patients")

public class WebClientCallController {
	
	
	private final WebClient webClient;
	
	
	public WebClientCallController(WebClient.Builder webClientBuilder) {
      this.webClient = webClientBuilder.baseUrl("http://localhost:9090/consume").build();
  }
	
	
//	@GetMapping("/pat")
//	public ResponseEntity<?> getPatientfromPatientService(){
//		
////		Mono<Object> fetchDataFromExternalService = fetchDataFromExternalService();
//		
//		Mono<Object> bodyToMono = webClient.get()
//      .uri("/patient/patient")
//      .retrieve()
//      .bodyToMono(Object.class);
//		
//		
//		return new ResponseEntity(bodyToMono,HttpStatus.OK);
//		
//		
//		
////		return 
//	}
	
	
//	-------------------------------------------------
//	@GetMapping("/pat")
//  public Mono<ResponseEntity<Patient>> getPatientData() {
//      return webClient.get()
//              .uri("/patient/patient")
//              .retrieve()
//              .bodyToMono(Patient.class)
//              .map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
//              .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//  }
	
	
//	--------------------------------------------------------
	@GetMapping("/pat")
  public ResponseEntity<Flux<Patient>> getPatientData() {
      Flux<Patient> patients = webClient.get()
              .uri("/patient/patient")
              .retrieve()
              .bodyToFlux(Patient.class);

      return new ResponseEntity<>(patients, HttpStatus.OK);
  }
	
//	Mono and Flux are both types provided by Project Reactor, which is a reactive programming library used in Spring WebFlux.
//	They represent asynchronous sequences of 0 or 1 (Mono) and 0 to N (Flux) elements respectively. Here's a breakdown of their differences:
//
//	Mono:
//	Represents a sequence of 0 or 1 elements.
//	It's often used to represent the result of an asynchronous operation that produces either zero or one value.
//	It provides operators to transform, combine, and handle asynchronous data in a non-blocking way.
//	Common use cases include handling single responses from a web service, database queries, or asynchronous computations 
//	that produce a single result.
	
	
	
	
//	Flux:
//	Represents a sequence of 0 to N elements.
//	It's used for handling streams of data that can emit multiple values over time.
//	It provides operators to handle backpressure, combine, and transform streams of data in a non-blocking way.
//	Common use cases include handling streams of events, processing large datasets, or consuming messages from a message broker.
//	In summary, Mono is used for handling asynchronous operations that produce zero or one result, 
//	while Flux is used for handling streams of data that can emit zero to multiple values over time. 
//	Both Mono and Flux are part of the reactive programming 
//	model supported by Spring WebFlux and are designed to handle asynchronous operations efficiently without blocking threads.

//--------------------------------------------------------------------------
	@GetMapping("/patient/data")
	public Mono<Object> fetchDataFromExternalService() {
      return webClient.get()
              .uri("/patient/patient")
              .retrieve()
              .bodyToMono(Object.class);
  }

}
