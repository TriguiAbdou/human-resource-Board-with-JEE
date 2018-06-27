package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class VacationService extends GenericDAO<Vacation> implements VacationServiceLocal,VacationServiceRemote  {

	@PersistenceContext
	EntityManager entityManager;
	
	public VacationService() {
		super(Vacation.class);
	}
}
