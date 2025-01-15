package com.callPatientServiceThroughRetrofitCall3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
	
	public static <S> S createCorePatientService(Class<S> serviceClass) {

		Gson gson = new GsonBuilder().setLenient().create();

		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		

		httpClient.interceptors().clear();

		httpClient.addInterceptor(chain -> {

		Request original = chain.request();

		Request request = original.newBuilder() //.header("Authorization", CommonService.getToken())

		.method(original.method(), original.body()).build();

		return chain.proceed(request);

		});
		
		Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://localhost:9090/consume/")

				.addConverterFactory(GsonConverterFactory.create(gson))

				.client(httpClient.build());

				Retrofit retrofit = builder.build();

				return retrofit.create(serviceClass);

				}	 	
	
}

