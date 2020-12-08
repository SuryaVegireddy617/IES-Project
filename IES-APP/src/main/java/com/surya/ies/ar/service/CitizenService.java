package com.surya.ies.ar.service;

import java.util.List;

import com.surya.ies.ar.domain.Citizen;

public interface CitizenService
{
	public String saveCitizen(Citizen citizen);
	
	public Citizen getCitizenByArId(String arId);
	
	public List<Citizen> getAllCitizens();
	
	public boolean deactivateCitizen(String arId);
	
	public boolean activateCitizen(String arId);
	
	public boolean checkCitizenState(String ssnNo);
}
