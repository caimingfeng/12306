package com.neuedu.tipd.my12306.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 蔡名锋:
 * @version 创建时间：2017年10月11日 上午8:52:59 类说明 :时间格式转换工具
 */
public final class DateUtil {

	public static final String SHORT = "yyyy-MM-dd";
	public static final String LONG = "yyyy-MM-dd HH:mm";
	private static SimpleDateFormat format;

	public static Date parseDate(String dateString, String pattern) {
		if (dateString == null || dateString == "") {
			return new Date();
		}
		format = new SimpleDateFormat(pattern);
		try {
			Date date = format.parse(dateString);
			return date;
		} catch (ParseException e) {
			System.out.println("String转Date异常");
			e.printStackTrace();
		}
		return new Date();
	}

	public static String formatDate(Date date, String pattern) {
		if (date == null || !(date instanceof Date)) {
			return "";
		}
		format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	public static void main(String[] args) {
		String datestring = "2017-5-8 5:30";
		Date date = parseDate(datestring, LONG);
		System.out.println(date);
	}

}
