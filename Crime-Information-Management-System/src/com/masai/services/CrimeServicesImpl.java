package com.masai.services;

import java.util.Map;

import com.masai.entities.Crime;
import com.masai.exceptions.*;

public class CrimeServicesImpl implements CrimeServices{

	@Override
	public void updateCrime(Crime updateCrime, Map<Integer, Crime> crime) throws crimeException {
		// TODO Auto-generated method stub
		int ID = updateCrime.getCrimeId();
		
		if(crime.containsKey(ID)) {
			crime.put(ID, updateCrime);
		}else {
			throw new crimeException("Please enter the correct ID");
		}
		
	}
}
