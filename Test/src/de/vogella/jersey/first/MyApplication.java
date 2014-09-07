package de.vogella.jersey.first;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication  extends ResourceConfig{

	 public MyApplication() {
	        packages("com.rest");
	    }
}
