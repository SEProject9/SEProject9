package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	private static Calendar c = Calendar.getInstance();
	private static SimpleDateFormat yyMMddHHmmss = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	private static SimpleDateFormat yyMMddHH = new SimpleDateFormat("yyyy/MM/dd HH");
	private static SimpleDateFormat yyMMdd = new SimpleDateFormat("yy/MM/dd");
	private static SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss");

	public static int getYear() {
		return c.get(Calendar.YEAR);
	}

	public static int getMonth() {
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDay() {
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static String getDate() {
		return yyMMdd.format(new Date());
	}

	public static String getTime() {
		return HHmmss.format(new Date());
	}

	public static String getDateTime() {
		return yyMMddHH.format(new Date());
	}

	public static String getDateTime2() {
		return yyMMddHHmmss.format(new Date());
	}

	public static String getCustomDateTime(String formator) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formator);
		return simpleDateFormat.format(new Date());
	}

}
