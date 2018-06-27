package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface CommentServiceLocal extends IGenericDAO<Comment>{
	
	public List<Comment> listComment(Topic topic);
	public String interComment(Comment comment);
}
