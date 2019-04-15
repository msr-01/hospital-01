package com.msr.hospital.test;


import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.dao.impl.BranchDaoImple;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.TimeUtil;

public class Test {
	public static void main(String[] args) {
		DoctorsDao dd = new DoctorsDaoImpl();
		System.out.println(dd.findByBT("1", "2").size());
	}
}
