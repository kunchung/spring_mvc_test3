package net.kc.spring.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
	private static Logger logger = LoggerFactory.getLogger(DateFormatter.class);

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
		logger.debug("parse " + s);
		return dateFormat.parse(s);
	}

}
