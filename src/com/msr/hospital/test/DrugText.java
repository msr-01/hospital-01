package com.msr.hospital.test;

import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.dao.impl.DrugDaoImpl;

public class DrugText {

	public static void main(String[] args) {
		
		List<Drug> drList = new ArrayList<Drug>();
		DrugDao drugDao = new DrugDaoImpl();
		Drug drug = new Drug();
		//System.out.println(drugDao.findAll().size());
		//System.out.println(drugDao.findByDrid("1"));
		System.out.println(drugDao.findbyDrname("药品名称"));
	}

}
