package com.example.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class FileReader implements IReader {

	private List<String> data;
	private String appendices;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public String getAppendices() {
		return appendices;
	}

	public void setAppendices(String appendices) {
		this.appendices = appendices;
	}

	@Override
	public Collection<String> read() {
		StringTokenizer stringTokenizer = new StringTokenizer(appendices,",");
		while (stringTokenizer.hasMoreElements()) {
			String str = (String) stringTokenizer.nextElement();
			data.add(str);
		}
		return data;
	}

}
