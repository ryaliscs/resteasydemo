package com.resyeasy.data;

import java.io.Serializable;

public class PersonPOJO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	/**
	 * PersonPOJO
	 */
	public PersonPOJO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
