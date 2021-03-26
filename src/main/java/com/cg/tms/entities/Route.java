package com.cg.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Route {
	
	
	private String routeId;
	private String  routeFrom;
	private String  routeTo;
	private  List<Bus> buses;
	private  LocalDateTime  departureTime;
	private  LocalDateTime   arrivalTime;
	private  LocalDate   doj;
	private String pickupPoint;
	private  double fare;
	
	

}
