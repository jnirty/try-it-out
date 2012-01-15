package com.example.semaphore;

public class Resource {
	private static int INDEX = 0;

	public Resource() {
		INDEX++;
	}

	public String getName() {
		return String.valueOf(INDEX);
	}
}
