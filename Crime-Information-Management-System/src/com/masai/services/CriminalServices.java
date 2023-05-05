package com.masai.services;

import java.util.Map;

import com.masai.entities.Criminal;
import com.masai.exceptions.criminalException;

public interface CriminalServices {
 
	public void updateCriminal(Criminal updatecriminal,	Map<Integer, Criminal> criminal)throws criminalException;
		
	

}
