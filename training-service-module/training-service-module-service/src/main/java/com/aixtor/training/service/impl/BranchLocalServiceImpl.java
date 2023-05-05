package com.aixtor.training.service.impl;

import com.aixtor.training.exception.NoSuchBranchException;
import com.aixtor.training.model.Branch;
import com.aixtor.training.service.base.BranchLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Urva Patel
 */
@Component(
	property = "model.class.name=com.aixtor.training.model.Branch",
	service = AopService.class
)
public class BranchLocalServiceImpl extends BranchLocalServiceBaseImpl {
	
	public Branch findByBranchId(long branchId) throws SystemException, NoSuchBranchException{
		return branchPersistence.findBybranchId(branchId);
	}

	@Override
	public List<Object[]> getAllBranches() {
		// TODO Auto-generated method stub
		return branchFinder.getAllBranches();
	}
	
	public Branch findBybranchName(String branchName) throws NoSuchBranchException{
		return branchPersistence.findBybranchName(branchName);
	}
}