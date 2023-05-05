package com.masai.services;

import java.util.Map;

import com.masai.entities.Crime;
import com.masai.exceptions.crimeException;

public interface CrimeServices { 
	
	public void updateCrime(Crime updateCrime, Map<Integer,Crime> crime) throws crimeException;
	
}
