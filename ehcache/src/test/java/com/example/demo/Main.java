package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.CacheConfiguration;
import com.example.demo.service.DemoService;

public class Main {
	
	public static void main(String[] args){
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CacheConfiguration.class);
		
		DemoService service = context.getBean(DemoService.class);
		
		 System.out.println(service.getUserByName("A"));  
		   //会走缓存  
	    System.out.println(service.getUserByName("B"));  
	    System.out.println(service.getUserByName("B"));  
	    //更新名字，会走数据库  
	    service.updateUserPut("A");  
	   //会走缓存呢，还是数据库呢？  
	    System.out.println(service.getUserByName("A")); 
		
		
	}

}
