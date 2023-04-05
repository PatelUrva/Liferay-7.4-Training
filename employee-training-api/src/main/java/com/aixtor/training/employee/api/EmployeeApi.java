package com.aixtor.training.employee.api;

import java.text.ParseException;
import java.util.Date;


/**
 * @author Urva Patel
 */
public interface EmployeeApi {
	
	public Date parseFromDate(Date fromDate,String fromDates, String formatPattern) throws ParseException;

	public Date parseToDate(Date toDate,String toDates, String formatPattern) throws ParseException;
	
}