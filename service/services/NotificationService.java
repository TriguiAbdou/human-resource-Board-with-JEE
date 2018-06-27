package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class NotificationService extends GenericDAO<Notification> implements NotificationServiceLocal , NotificationServiceRemote{

	
	@PersistenceContext
	EntityManager entityManager;
	
	public NotificationService() {
		super(Notification.class);
	}
}
