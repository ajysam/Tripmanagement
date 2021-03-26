package com.cg.tms.repository;

import java.util.List;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;

public interface ITravelsRespository {
	
		
			public Travels  addTravels(Travels travels);
			public Travels  updateTravels(Travels travels) throws TravelsNotFoundException;
			public Travels  removeTravels(int travelsId) throws TravelsNotFoundException;
			public Travels searchTravels(int travelsId) throws TravelsNotFoundException;
			public  List<Travels>  viewTravels();
	
	

}
