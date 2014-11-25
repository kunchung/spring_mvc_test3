package net.kc.spring.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
	private static Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

	private String pattern;

	public StringToDateConverter(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public Date convert(String s) {
		logger.debug("convert " + s);
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format, please use " + pattern);
		}
	}

}
