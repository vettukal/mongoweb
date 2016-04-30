package com.example.gps.pothole2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pothole2")
public class Pothole2 
{
	@Id private String id;
	
	private String gmobileId;
	
	
	private String lattitude;
	private String longitude;
	
	private String diff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGmobileId() {
		return gmobileId;
	}

	public void setGmobileId(String gmobileId) {
		this.gmobileId = gmobileId;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDiff() {
		return diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	
	
}