package com.tryitout.resteasy.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.tryitout.resteasy.rest.JSONService;
import com.tryitout.resteasy.rest.MessageRestService;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageRestService());
		singletons.add(new JSONService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
