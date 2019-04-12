package com.msr.hospital.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getNowDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return sf.format(date);
	}
	
	public static String getNowDateTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sf.format(date);
	}
}
