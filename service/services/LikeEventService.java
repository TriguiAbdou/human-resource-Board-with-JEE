package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.entities.LikeEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
@LocalBean
public class LikeEventService extends GenericDAO<LikeEvent> implements LikeEventServiceLocal,LikeEventServiceRemote{

	public LikeEventService() {
		super(LikeEvent.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<LikeEvent> search(Event e, User uu){
		Query query = (Query) entityManager.
				
				createQuery("SELECT u FROM LikeEvent u WHERE u.user=:user AND u.event=:event",LikeEvent.class)
				.setParameter("user", uu).setParameter("event", e);
				    List<LikeEvent> list = query.getResultList();
						
				    return list;
		
	}
	
	public int CalculLike(Event e)
	{
		Long c;
		
		c = (Long) entityManager.createQuery("SELECT COUNT(id) FROM LikeEvent u WHERE u.event=:event AND u.state=:state")
				.setParameter("event", e).setParameter("state", "like").getSingleResult();
	int cc = c.intValue();
	return cc;
		
		
	}
	
	public int CalculDislike(Event e)
	{
		Long c;
		
		c = (Long) entityManager.createQuery("SELECT COUNT(id) FROM LikeEvent u WHERE u.event=:event AND u.state=:state")
				.setParameter("event", e).setParameter("state", "dislike").getSingleResult();
	int cc = c.intValue();
	return cc;
		
		
	}
	
}
