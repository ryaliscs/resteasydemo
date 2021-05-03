package com.resyeasy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This is simply a class the lists all JAX-RS root resources and providers, and
 * it is annotated with the @ApplicationPath annotation.
 * 
 * @author saryal
 *
 */
@ApplicationPath("/api")
public class RestAppliation extends Application {
	/**
	 * If you return any empty set for by classes and singletons, the WAR will be
	 * scanned for JAX-RS annotation resource and provider classes.
	 */
	private Set<Object> singletons = new HashSet<Object>();

	public RestAppliation() {
		singletons.add(new UserManagementModule());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
