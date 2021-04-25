package com.resyeasy.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.resyeasy.data.PersonPOJO;

public class UserRepository {

	private static Map<Integer, PersonPOJO> USERS = new HashMap<Integer, PersonPOJO>();
	private static int nextID = 6;

	static {
		USERS.put(1, new PersonPOJO(1, "name1"));
		USERS.put(2, new PersonPOJO(2, "name2"));
		USERS.put(3, new PersonPOJO(3, "name3"));
		USERS.put(4, new PersonPOJO(4, "name4"));
		USERS.put(5, new PersonPOJO(5, "name5"));
		USERS.put(6, new PersonPOJO(6, "name6"));

	}

	public static List<PersonPOJO> getAllUsers() {
		return new ArrayList<PersonPOJO>(USERS.values());
	}

	public static PersonPOJO getUser(int aId) {
		return USERS.get(Integer.valueOf(aId));
	}

	public static PersonPOJO createUser(PersonPOJO aPerson) throws RuntimeException {
		nextID++;
		PersonPOJO person = new PersonPOJO(nextID, aPerson.getName());
		PersonPOJO updatedPerson = USERS.put(person.getId(), person);
		if (updatedPerson != null) {
			// return null as the person already exists
			return null;
		}
		return person;
	}

	public static PersonPOJO updateUser(PersonPOJO aPerson) throws RuntimeException {

		PersonPOJO person = USERS.get(aPerson.getId());
		if (person != null) {
			person.setName(aPerson.getName());
			PersonPOJO updatedPerson = USERS.put(person.getId(), person);
			return updatedPerson;
		}
		return null;
	}

	public static boolean deleteUser(int aId) {
		return USERS.remove(Integer.valueOf(aId)) != null;
	}

}
