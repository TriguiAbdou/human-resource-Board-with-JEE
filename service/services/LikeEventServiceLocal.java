package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.entities.LikeEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface LikeEventServiceLocal extends IGenericDAO<LikeEvent>{
	public List<LikeEvent> search(Event e, User uu);
	public int CalculDislike(Event e);
	public int CalculLike(Event e);

}
