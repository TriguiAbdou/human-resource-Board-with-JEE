package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class CommentService extends GenericDAO<Comment> implements CommentServiceLocal, CommentServiceRemote {
	@PersistenceContext
	EntityManager entityManager;
	
	public CommentService() {
		super(Comment.class);
	}
	
	
	
	
	//(used)
    public List<Comment> listComment(Topic topic){
    	Query query = (Query) entityManager.createQuery("SELECT c FROM Comment c WHERE c.topic=:top");
		query.setParameter("top", topic);
	     List<Comment> list = query.getResultList();
	return list;   	      
    }
    
    
    public String interComment(Comment comment) {
    	int a=comment.getNbLike();
    	int b=comment.getNbDislike();
    	String msg;
    	if(((a+b)>=3) && (a > (b/2))){
    		msg="interesting";
    	
    	}
    	else {
    		msg="not interesting";
    	}
    return msg;	
    }
	
	
}
