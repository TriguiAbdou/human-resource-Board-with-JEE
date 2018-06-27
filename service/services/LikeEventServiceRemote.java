package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.entities.LikeEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface LikeEventServiceRemote extends IGenericDAO<LikeEvent>{
	public List<LikeEvent> search(Event e, User uu);
	public int CalculDislike(Event e);
	public int CalculLike(Event e);

}
