package com.example.ISAproject.util;

import java.time.LocalDateTime;

public class DateUtil {

	public static boolean dateIntertwine(LocalDateTime startDate1, LocalDateTime endDate1, LocalDateTime startDate2, LocalDateTime endDate2) {
		if( endDate1.isBefore(startDate2) || endDate2.isBefore(startDate1)) {
			return false;
		}
		
		return true;
	}
}
