package com.masai.entities;

public class Criminal {
	 private int criminalId;
	    private String name;
	    private String dob;
	    private String gender;
	    private String identifyingMark;
	    private String firstArrestDate;
	    private String arrestedFromPsArea;
		public Criminal(int criminalId, String name, String dob, String gender, String identifyingMark,
				String firstArrestDate, String arrestedFromPsArea) {
			super();
			this.criminalId = criminalId;
			this.name = name;
			this.dob = dob;
			this.gender = gender;
			this.identifyingMark = identifyingMark;
			this.firstArrestDate = firstArrestDate;
			this.arrestedFromPsArea = arrestedFromPsArea;
		}
		public int getCriminalId() {
			return criminalId;
		}
		public void setCriminalId(int criminalId) {
			this.criminalId = criminalId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getIdentifyingMark() {
			return identifyingMark;
		}
		public void setIdentifyingMark(String identifyingMark) {
			this.identifyingMark = identifyingMark;
		}
		public String getFirstArrestDate() {
			return firstArrestDate;
		}
		public void setFirstArrestDate(String firstArrestDate) {
			this.firstArrestDate = firstArrestDate;
		}
		public String getArrestedFromPsArea() {
			return arrestedFromPsArea;
		}
		public void setArrestedFromPsArea(String arrestedFromPsArea) {
			this.arrestedFromPsArea = arrestedFromPsArea;
		}
	    
}
