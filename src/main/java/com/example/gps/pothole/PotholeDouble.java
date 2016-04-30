package com.example.gps.pothole;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "potholedouble")
public class PotholeDouble 
{
	@Id private String id;
	
	private String gmobileId;
	
	
	private Double lattitude;
	private Double longitude;
	
	private Double diff;

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

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getDiff() {
		return diff;
	}

	public void setDiff(Double diff) {
		this.diff = diff;
	}
	
	
	
}