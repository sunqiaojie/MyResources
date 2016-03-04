package com.dezhong.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public class GlobalMethod {

	public static boolean isValidTime(String str){
			try {
				GlobalConstant.sdf_yyyyMMddHHmmss.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
				return false;
			}
		
		return true;
	}
	
	public static boolean isTimeAllZero(String str){
		if(GlobalConstant.YearTimeAllZero.equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}
	
	public static String getNowDateTimeStr(){
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		GlobalConstant.sdf_yyyyMMddHHmmss.format(date);
		return GlobalConstant.sdf_yyyyMMddHHmmss.format(date);
	}
	
}
