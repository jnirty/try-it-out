package com.example.security.data;

public class Item extends BaseModelObject {
	private String name;
	public Item(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
