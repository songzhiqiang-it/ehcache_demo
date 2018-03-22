package com.example.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	@Cacheable(value="demoCache",key="#userName")  
	public String getUserByName(String userName) {   
	   System.out.println("两次调用第一次会执行，第二次不会执行！");  
	   return "从数据看查询得到"+userName;   
	}   
	  
//	@CacheEvict(value="demoCache",key="1000")  //将cache=demoCache, key=1000的缓存清除
	@CachePut(value="demoCache",key="#userName")  //执行方法,并更新cache=demoCache, key=userName的缓存为该方法的返回值
	public void updateUserPut(String userName) {  
		System.out.println("执行更新操作");
	   return ;   
	   //Q1：为什么更新操作会返回？@CachePut是否有实用价值
	   
	   
	   //Q2：查询条件（参数）改变，缓存是否有用
	   //应该让key的值跟参数相关
	   
	} 
	
}
