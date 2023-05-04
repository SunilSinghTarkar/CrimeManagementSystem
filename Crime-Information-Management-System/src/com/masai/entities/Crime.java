package com.masai.entities;

import java.io.Serializable;

public class Crime implements Serializable {
	
	
	    private int crimeId;
	    private String type;
	    private String description;
	    private String psArea;
	    private String date;
	    private String victimName;
	    public Crime() {
	    	super();
	    }
		public Crime(int crimeId, String type, String description, String psArea, String date, String victimName) {
			super();
			this.crimeId = crimeId;
			this.type = type;
			this.description = description;
			this.psArea = psArea;
			this.date = date;
			this.victimName = victimName;
		}
		public int getCrimeId() {
			return crimeId;
		}
		public void setCrimeId(int crimeId) {
			this.crimeId = crimeId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPsArea() {
			return psArea;
		}
		public void setPsArea(String psArea) {
			this.psArea = psArea;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getVictimName() {
			return victimName;
		}
		public void setVictimName(String victimName) {
			this.victimName = victimName;
		}
	    

	  

     
}
