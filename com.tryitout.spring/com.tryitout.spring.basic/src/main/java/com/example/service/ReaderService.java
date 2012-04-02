package com.example.service;

import java.util.Collection;

import com.example.util.IReader;

public class ReaderService {

	private IReader reader;
	
	public ReaderService(IReader reader) {
		this.reader = reader;
	}
	
	public Collection<String> fetchData(){
		return reader.read();
	}
	
	public void init() {
		System.out.println("Initializing " + this.getClass().getName());
	}
	public void cleanUp() {
		System.out.println("Cleaning  " + this.getClass().getName());
	}
}
