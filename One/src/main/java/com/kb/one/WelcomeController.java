package com.kb.one;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@Value("${welcome.message:test}")
	private String user = "Ken";
	private Map<String,Object> myMap = new HashMap<String,Object>();

	@RequestMapping("/")
	public String welcome(Map<String,Object> map) {
		
		myMap.put(user, "You are authorized");
		
		map.put("message", "Hello There");
		return "welcome";
	}
	@RequestMapping(value = "/One/{id}")
	public String helloWorld(@PathVariable("id") String id,HttpServletResponse response) throws IOException  {
		System.out.println(user);
	  if(myMap.containsKey(id)){
		  response.getWriter().println("<div>G'day Mate " + id + "</div><button ontype=button>click</button>");
	  }else{
		  response.getWriter().println("<div>you are not authorized!</button>");
	  }
	  return "index";
	}
}

