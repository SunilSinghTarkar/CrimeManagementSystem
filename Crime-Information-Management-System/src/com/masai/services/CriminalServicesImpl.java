package com.masai.services;

import java.util.Map;

import com.masai.entities.Criminal;
import com.masai.exceptions.criminalException;



public class CriminalServicesImpl implements CriminalServices{

	@Override
	public void updateCriminal(Criminal updatecriminal, Map<Integer, Criminal> criminal) throws criminalException {
        int ID = updatecriminal.getCriminalId();
		
		if(criminal.containsKey(ID)) {
			criminal.put(ID, updatecriminal);
		}else {
			throw new criminalException("Please enter the correct ID");
		}
		
	}

	

}
