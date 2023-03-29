package com.aixtor.training.service.persistence.impl;

/**
 * @author Urva Patel
 */

import com.aixtor.training.model.Employee;
import com.aixtor.training.service.persistence.EmployeeFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {

	private static Log log = LogFactoryUtil.getLog(EmployeeFinderImpl.class);

	@Reference
	private CustomSQL customSQL;
	
	private Session session = null;

	public List<Object[]> getDesignationNameByEmployee() {
		
		try {
			// 1. Open an ORM session
			session = openSession();
			
			// 2. Get SQL statement from XML file with its name
			String sql = customSQL.get(getClass(), "getDesignationNameByEmployee");
			
			// 3. Transform the normal query to SQL query
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			
			sqlQuery.setCacheable(false);
			
			// 4. Replace positional parameters in the query
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			
			// 5. Execute query and return results.
			return (List<Object[]>) sqlQuery.list();
			
		} catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getDesignationNameByEmployee >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getEmployeeByName(String employeeName) {
		Session session = null;
		try {
			//log.info(employeeName);
			
			// 1. Open an ORM session
	        session = openSession();
	        
	        // 2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getEmployeeByName");
	        log.info("EmployeeFinderImpl >>> getEmployeeByName >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("EmployeeFinderImpl >>> getEmployeeByName >>> Query :: " + query);
			
			query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        qPos.add("%"+employeeName+"%");
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
	        
	        
		} catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getEmployeeByName >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Object[]> getEmployeeByAllEntity(String searchData) {
		Session session = null;
		try {
			//log.info(searchData);
			
			// 1. Open an ORM session
	        session = openSession();
	        
	        //2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getEmployeeByAllEntity");
	        log.info("EmployeeFinderImpl >>> getEmployeeByAllEntity >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("EmployeeFinderImpl >>> getEmployeeByAllEntity >>> Query :: " + query);
			
	        query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
	        
	        
		} catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getEmployeeByAllEntity >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designationName) {
		// TODO Auto-generated method stub
		return null;
	}
}
