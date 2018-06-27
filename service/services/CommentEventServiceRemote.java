package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.CommentEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface CommentEventServiceRemote extends IGenericDAO<CommentEvent>{
	public List<CommentEvent> getCommentByEvent(Event e);
}
