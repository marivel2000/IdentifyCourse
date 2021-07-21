package com.IdentifyCourse.datautilites;

import java.util.Date;
/*************To generate screenshot names******************/
public class DateUtil {
	public static String getDate(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

	
}

