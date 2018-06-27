package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.CommentEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;
@Local
public interface CommentEventServiceLocal extends IGenericDAO<CommentEvent>{
	public List<CommentEvent> getCommentByEvent(Event e);

}
