package com.example.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Phone implements Serializable {
	private static final long serialVersionUID = 693966819818666958L;

	private String phoneNumber;

	public Phone() {
	}

	public Phone(String no) {
		this.phoneNumber = no;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
public String toString() {
	// TODO Auto-generated method stub
	return "phone:{phoneNumber:"+phoneNumber+"}";
}
}
