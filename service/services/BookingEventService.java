package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.entities.Pay;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
@LocalBean
public class BookingEventService extends GenericDAO<BookingEvent> implements BookingEventServiceRemote, BookingEventServiceLocal{
	@PersistenceContext
	private EntityManager entityManager;
	
	public BookingEventService() {
		super(BookingEvent.class);
		
	}
	public List<BookingEvent> search(Event e, User uu){
		Query query = (Query) entityManager.
				
				createQuery("SELECT u FROM BookingEvent u WHERE u.user=:user AND u.event=:event",BookingEvent.class)
				.setParameter("user", uu).setParameter("event", e);
				    List<BookingEvent> list = query.getResultList();
						
				    return list;
		
	}
	public List<BookingEvent> findbyEvent(Event e){
		Query query = (Query) entityManager.
				
				createQuery("SELECT u FROM BookingEvent u WHERE u.event=:event",BookingEvent.class)
				.setParameter("event", e);
				    List<BookingEvent> list = query.getResultList();
						
				    return list;
		
	}
	
	public List<BookingEvent> findMyBooking(Event e,User u){
		Query query = (Query) entityManager.
				
				createQuery("SELECT u FROM BookingEvent u WHERE u.event=:event AND u.user=:user ",BookingEvent.class)
				.setParameter("event", e).setParameter("user", u);
				    List<BookingEvent> list = query.getResultList();
						
				    return list;
		
	}
	

}
