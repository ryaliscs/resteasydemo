package com.resyeasy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestAppliation extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RestAppliation() {
		singletons.add(new UserManagementModule());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
