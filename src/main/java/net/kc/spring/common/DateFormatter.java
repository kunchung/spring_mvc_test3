package net.kc.spring.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private SimpleDateFormat dateFormat;

	public DateFormatter(String pattern) {
		dateFormat = new SimpleDateFormat(pattern);
	}

	@Override
	public String print(Date d, Locale locale) {
		return dateFormat.format(d);
	}

	@Override
	public Date parse(String s, Locale locale) throws ParseException {
		return dateFormat.parse(s);
	}

}
