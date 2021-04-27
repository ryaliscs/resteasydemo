package com.resyeasy.data;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
@ApiModel(description = "Person Information")
public class PersonPOJO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	/**
	 * creates a default empty instance
	 */
	public PersonPOJO() {

	}

	/**
	 * PersonPOJO
	 */
	public PersonPOJO(int id, String name) {
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

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return this.id ^ this.name.hashCode();
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof PersonPOJO) {
			PersonPOJO aPerson = (PersonPOJO) anObject;
			return aPerson.getId() == this.id && aPerson.getName().equals(this.name);
		}
		return false;
	}

}
