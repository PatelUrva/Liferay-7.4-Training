package com.aixtor.training.service.impl;

import com.aixtor.training.employee.api.EmployeeApi;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = EmployeeApi.class)

public class EmployeeImpl implements EmployeeApi {

	private static Log log = LogFactoryUtil.getLog(EmployeeImpl.class);
	
	@Override
	public Date parseFromDate(Date fromDate, String fromDates, String formatPattern) throws ParseException {
		log.info("EmployeeImpl >>> parseFromDate >>> Inside parseFromDate ");
		log.info("EmployeeImpl >>> parseFromDate >>> from parameter  :: " +fromDates+ "\n");
		formatPattern = "yyyy-MM-dd";
		if(Validator.isNull(fromDates)) {
			String newDate = "1990-01-01";
			fromDate = new SimpleDateFormat(formatPattern).parse(newDate);
			log.info("EmployeeImpl >>> parseFromDate >>> If null :: " +fromDate+ "\n");
		}else {
			fromDate = new SimpleDateFormat(formatPattern).parse(fromDates);
			log.info("EmployeeImpl >>> parseFromDate >>> If not null :: " +fromDate+ "\n");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fromDate);
			calendar.set(Calendar.HOUR, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			fromDate = calendar.getTime();
		}
		return fromDate;
	}

	@Override
	public Date parseToDate(Date toDate, String toDates, String formatPattern) throws ParseException {
		log.info("EmployeeImpl >>> parseToDate >>> Inside parseToDate ");
		log.info("EmployeeImpl >>> parseToDate >>> from parameter :: " +toDates+ "\n");
		formatPattern = "yyyy-MM-dd";
		if(Validator.isNull(toDates)) {
			Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 0);
			today.set(Calendar.MINUTE, 0);
			today.set(Calendar.SECOND, 0);
			toDate = today.getTime();
			log.info("EmployeeImpl >>> parseToDate >>> If null :: " +toDate+ "\n");
		}
		else {
			toDate = new SimpleDateFormat(formatPattern).parse(toDates);
			log.info("EmployeeImpl >>> parseToDate >>> If not null :: " +toDate+ "\n");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(toDate);
			calendar.set(Calendar.HOUR, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			toDate = calendar.getTime();
		}
		return toDate;
	}
}
