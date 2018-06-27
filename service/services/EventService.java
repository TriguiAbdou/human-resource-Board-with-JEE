package tn.esprit.b3.esprit1718b3hrboard.services;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;

import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
@LocalBean
public class EventService extends GenericDAO<Event> implements EventServiceRemote, EventServiceLocal{
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
    
	public EventService() {
		super(Event.class);
		
	}
	
	public BookingEvent createBooking(BookingEvent booking) {
		entityManager.merge(booking);
		return booking;
	}
	
	
	public void UpdateLike(Event ct) {
		int like = ct.getNbrLike();
		int newLike = like+1;
		ct.setNbrLike(newLike);
		entityManager.merge(ct);
		
	}

	
	public void UpdateDislike(Event ct) {
		int dislike = ct.getNbrDislike();
		int newdislike = dislike+1;
		ct.setNbrDislike(newdislike);
		entityManager.merge(ct);
		
	}

	
	public void Participate(Event ct) {
		int place = ct.getPlace();
		int newNb = place-1;
		ct.setPlace(newNb);
		entityManager.merge(ct);
		
	}

}
