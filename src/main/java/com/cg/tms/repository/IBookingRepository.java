package com.cg.tms.repository;

import java.util.List;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;

public interface IBookingRepository  {
	
	
	public  Booking  makeBooking(Booking booking);
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	
	
	
	
	

}
