package com.msr.hospital.bean;

public class Medicalrecord {
		private String mrid;
		private Patientinformation patientinformation;
		private Prescription prescription;
		private Doctors doctors;
		private String diagnosistime;
		private String diagnosisresult;
		private String diagnosismethod;
		public String getMrid() {
			return mrid;
		}
		public void setMrid(String mrid) {
			this.mrid = mrid;
		}
		public Patientinformation getPatientinformation() {
			return patientinformation;
		}
		public void setPatientinformation(Patientinformation patientinformation) {
			this.patientinformation = patientinformation;
		}
		public Prescription getPrescription() {
			return prescription;
		}
		public void setPrescription(Prescription prescription) {
			this.prescription = prescription;
		}
		public Doctors getDoctors() {
			return doctors;
		}
		public void setDoctors(Doctors doctors) {
			this.doctors = doctors;
		}
		public String getDiagnosistime() {
			return diagnosistime;
		}
		public void setDiagnosistime(String diagnosistime) {
			this.diagnosistime = diagnosistime;
		}
		public String getDiagnosisresult() {
			return diagnosisresult;
		}
		public void setDiagnosisresult(String diagnosisresult) {
			this.diagnosisresult = diagnosisresult;
		}
		public String getDiagnosismethod() {
			return diagnosismethod;
		}
		public void setDiagnosismethod(String diagnosismethod) {
			this.diagnosismethod = diagnosismethod;
		}
		public Medicalrecord(String mrid, Patientinformation patientinformation, Prescription prescription,
				Doctors doctors, String diagnosistime, String diagnosisresult, String diagnosismethod) {
			super();
			this.mrid = mrid;
			this.patientinformation = patientinformation;
			this.prescription = prescription;
			this.doctors = doctors;
			this.diagnosistime = diagnosistime;
			this.diagnosisresult = diagnosisresult;
			this.diagnosismethod = diagnosismethod;
		}
		public Medicalrecord() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
}
