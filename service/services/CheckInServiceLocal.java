package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.CheckIn;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface CheckInServiceLocal extends IGenericDAO<CheckIn>{
	
	void createCheckIn(CheckIn checkIn);
}
