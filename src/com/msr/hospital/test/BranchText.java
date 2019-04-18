package com.msr.hospital.test;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.impl.BranchDaoImple;

public class BranchText {

	public static void main(String[] args) {
		BranchDao branchDao = new BranchDaoImple();
		System.out.println(branchDao.findAll().size());
		//System.out.println(branchDao.findByBrid("1"));
		//branchDao.deleteBranch("5");
		Branch branch = new Branch("22","223","223");
		
		branchDao.modifyBranch(branch);
		//System.out.println();
		//System.out.println(branchDao.findAll().size());
		//System.out.println(branchDao.findAll().size());
		
	}

}
