package com.callPatientServiceThroughRetrofitCall3;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Patient {
	
	String patientid;
	String firstname;
	String lastname;
	String mobile;
	String email;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date createdon;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String patientid, String firstname, String lastname, String mobile, String email, Date createdon) {
		super();
		this.patientid = patientid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile = mobile;
		this.email = email;
		this.createdon = createdon;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	
	
	
}

