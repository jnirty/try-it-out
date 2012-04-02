package com.example.util;

import java.util.Collection;
import java.util.List;

public class FileReader implements IReader{

	private List<String> data;

	
	public List<String> getData() {
		return data;
	}


	public void setData(List<String> data) {
		this.data = data;
	}


	@Override
	public Collection<String> read() {
		return data;
	}
	
	

}
