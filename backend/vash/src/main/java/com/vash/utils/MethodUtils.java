package com.vash.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class MethodUtils {

	public static LocalDate parseDateInLocalDate(Date date, String pattern) {
		LocalDate localDate = null;
		if (!ObjectUtils.isEmpty(date) && StringUtils.hasText(pattern)) {
			localDate = LocalDate.parse(new SimpleDateFormat(pattern).format(date));
		}
		return localDate;
	}

}
