package com.msr.hospital.test;


import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.Druglist;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Permission;
import com.msr.hospital.bean.Registered;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.DruglistDao;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.PermissionDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.dao.impl.BranchDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.DruglistDaoImpl;
import com.msr.hospital.dao.impl.MedicalrecordDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.PermissionDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

public class Test {
	public static void main(String[] args) {
		PermissionDao psd = new PermissionDaoImpl();
		
		System.out.println(psd.findAllPermission().size());
	}
}
