package com.example.gps.inter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "intergps")
public class InterGPS 
{
	@Id private String id;
	
	private String gmobileId;
	
	private String xaxis;
	private String yaxis;
	private String zaxis;
	
	private String lattitude;
	private String longitude;
	
	private String x2;
	private String y2;
	private String z2;
	
	private String squaresum;
	private String diff;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXaxis() {
		return xaxis;
	}
	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}
	public String getYaxis() {
		return yaxis;
	}
	public void setYaxis(String yaxis) {
		this.yaxis = yaxis;
	}
	public String getZaxis() {
		return zaxis;
	}
	public void setZaxis(String zaxis) {
		this.zaxis = zaxis;
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
	public String getX2() {
		return x2;
	}
	public void setX2(String x2) {
		this.x2 = x2;
	}
	public String getY2() {
		return y2;
	}
	public void setY2(String y2) {
		this.y2 = y2;
	}
	public String getZ2() {
		return z2;
	}
	public void setZ2(String z2) {
		this.z2 = z2;
	}
	public String getSquaresum() {
		return squaresum;
	}
	public void setSquaresum(String squaresum) {
		this.squaresum = squaresum;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	public String getGmobileId() {
		return gmobileId;
	}
	public void setGmobileId(String gmobileId) {
		this.gmobileId = gmobileId;
	}
	
	
	
	
	
	
	
}