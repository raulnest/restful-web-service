package com.in28minutes.rest.webservices.restfulwebservice.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservice.helloWorld.HelloWorldBean;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		
		//throw new RuntimeException("Some Error Occured! Contact Support!");
		
		return new HelloWorldBean("Hello World - Changed");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean("Hello World "+name);
	}
}
