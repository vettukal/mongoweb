package com.example.gps;


import java.util.ArrayList;

import org.junit.Test;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class Retrofit {
	private static final String LOCATION_SERVER = "http://52.35.159.233:80";
	private static GmobileSvc gmobileControl = new RestAdapter.Builder()
			.setEndpoint(LOCATION_SERVER)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(GmobileSvc.class);
	
//	//@Test
//	public static void main2(String[] args) throws Exception {
//		
//		Gmobile mobile = new Gmobile();
//		mobile.setXaxis("2");
//		mobile.setYaxis("511111");
//		mobile.setZaxis("6");
//		
//		mobile.setLattitude("23");
//		mobile.setLongitude("23");
//		
//		Gmobile mobile2 = new Gmobile();
//		mobile.setXaxis("2");
//		mobile.setYaxis("522222");
//		mobile.setZaxis("6");
//		
//		mobile.setLattitude("23");
//		mobile.setLongitude("23");
//		
//		ArrayList<Gmobile> list = new ArrayList<>();
//		System.out.println(gmobileControl.submitGmobileList(list));;
//		
//	}
}