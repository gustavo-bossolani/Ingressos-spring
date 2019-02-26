package br.gustavo.spring.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestEasyConfig extends Application{
	
	private Set<Object> singletons = new HashSet<>();
	
	public RestEasyConfig() {
		singletons.add(new ClienteService());
	}

	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
	
}
