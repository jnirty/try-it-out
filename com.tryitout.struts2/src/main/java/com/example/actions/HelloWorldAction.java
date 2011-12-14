package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;


public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "Hello World !!!";
	private String message;

	public String execute() {
		setMessage(MESSAGE);
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
