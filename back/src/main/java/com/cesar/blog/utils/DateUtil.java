package com.cesar.blog.utils;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class DateUtil {

	private Date date;

	public DateUtil(){
		Date date = new Date();
	}
	
	public Date getCurrentDate(){
		return date;
	}
	
}
