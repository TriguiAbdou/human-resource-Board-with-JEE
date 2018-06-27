package tn.esprit.b3.esprit1718b3hrboard.services;

import tn.esprit.b3.esprit1718b3hrboard.entities.CheckIn;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;
import javax.ejb.Remote;

@Remote
public interface CheckInServiceRemote extends IGenericDAO<CheckIn> {

	void createCheckIn(CheckIn checkIn);
}
