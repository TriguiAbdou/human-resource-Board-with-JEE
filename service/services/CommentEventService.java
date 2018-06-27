package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.CommentEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
@LocalBean
public class CommentEventService extends GenericDAO<CommentEvent> implements CommentEventServiceLocal,CommentEventServiceRemote {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CommentEventService() {
		super(CommentEvent.class);
	}

	
	
	public List<CommentEvent> getCommentByEvent(Event e) {
		Query query = (Query) entityManager.
				
				createQuery("SELECT u FROM CommentEvent u WHERE u.event=:event",CommentEvent.class)
				.setParameter("event", e);
				    List<CommentEvent> list = query.getResultList();
						
				    return list;
	}
	

}
