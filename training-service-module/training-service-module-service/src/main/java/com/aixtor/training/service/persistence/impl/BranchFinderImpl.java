package com.aixtor.training.service.persistence.impl;

/**
 * @author Urva Patel
 */

import com.aixtor.training.service.persistence.BranchFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = BranchFinder.class)
public class BranchFinderImpl extends BranchFinderBaseImpl implements BranchFinder {

	@Reference
	CustomSQL customSQL;
	
	private static Log log = LogFactoryUtil.getLog(BranchFinderImpl.class);
	private Session session = null;
	
	public List<Object[]> getAllBranches(){
		try {
			// 1. Open an ORM session
			session = openSession();
	        
	        // 2. Get SQL statement from XML file with its name
	        String sql = customSQL.get(getClass(), "getAllBranches");
	        log.info("BranchFinderImpl >>> getAllBranches >>> SQL :: " + sql);
	        
	        // 3. Transform the normal query to SQL query
	        SQLQuery query = session.createSQLQuery(sql);
	        log.info("BranchFinderImpl >>> getAllBranches >>> Query :: " + query);
	        
	        query.setCacheable(false);
	        
	        // 4. Replace positional parameters in the query
	        QueryPos qPos = QueryPos.getInstance(query);
	        
	        // 5. Execute query and return results.
	        return (List<Object[]>) query.list();
			
		}catch (Exception e) {
			log.error("BranchFinderImpl >>> getAllBranches >>> Exception Occurred :: " +e);
		} finally {
			closeSession(session);
		}
		return null;
	}
}
