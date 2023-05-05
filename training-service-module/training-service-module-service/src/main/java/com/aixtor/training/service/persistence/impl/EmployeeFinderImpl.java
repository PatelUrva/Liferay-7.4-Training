package com.aixtor.training.service.persistence.impl;

/**
 * @author Urva Patel
 */

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

	@Reference
	private CustomSQL customSQL;
	
	private static Log log = LogFactoryUtil.getLog(EmployeeFinderImpl.class);
	
	private Session session = null;
	
	public List<Object[]> getEmployeesByAllEntity(String searchData){
		log.info("Search :: " + searchData + "\n");
		try {
			// 1. Open an ORM session
	        session = openSession();
	        
	        // 2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getEmployeesByAllEntity");
	        log.info("EmployeeFinderImpl >>> getEmployeesByAllEntity >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("EmployeeFinderImpl >>> getEmployeesByAllEntity >>> Query :: " + query);
	        
	        query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        qPos.add("%"+searchData+"%");
	        
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
	        
		}catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getEmployeesByAllEntity >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getAllEmployees(){
		try {
			// 1. Open an ORM session
			session = openSession();
	        
	        // 2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getAllEmployees");
	        log.info("EmployeeFinderImpl >>> getAllEmployees >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("EmployeeFinderImpl >>> getAllEmployees >>> Query :: " + query);
	        
	        query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
			
		}catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getAllEmployees >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getAllBranches(){
		try {
			// 1. Open an ORM session
			session = openSession();
	        
	        // 2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getAllBranches");
	        log.info("EmployeeFinderImpl >>> getAllBranches >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("EmployeeFinderImpl >>> getAllBranches >>> Query :: " + query);
	        
	        query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
			
		}catch (Exception e) {
			log.error("EmployeeFinderImpl >>> getAllBranches >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
}
