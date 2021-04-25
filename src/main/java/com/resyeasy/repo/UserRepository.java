package com.resyeasy.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.resyeasy.data.PersonPOJO;



public class UserRepository {

	private static Map<Integer, PersonPOJO> USERS = new HashMap<Integer, PersonPOJO>();

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

}
