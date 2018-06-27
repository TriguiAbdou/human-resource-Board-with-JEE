package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.CheckIn;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class CheckInService extends GenericDAO<CheckIn> implements CheckInServiceRemote, CheckInServiceLocal{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public CheckInService() {
		super(CheckIn.class);
		
	}


	
	
	public void createCheckIn(CheckIn checkIn) {
		entityManager.persist(checkIn);
	}
	

}
