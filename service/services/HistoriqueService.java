package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Historique;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class HistoriqueService extends GenericDAO<Historique> implements HistoriqueServiceLocal,HistoriqueServiceRemote{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public HistoriqueService() {
		super(Historique.class);
	}
	
	
	//retourne si un employee aa fait like ou non 
	public boolean autorisation(String employee,String type ,Topic topic) {
		Query query = (Query) entityManager.createQuery("SELECT h FROM Historique h WHERE h.topic=:top");
		query.setParameter("top", topic);
	    List<Historique> list = query.getResultList();
	    boolean auto=false;
	    for(Historique histo:list) {
	    	if (((histo.getEmployee().getName()).equals(employee))&& ((histo.getType()).equals(type)))
	    		auto=true;
	    }
	return auto;
	   
	}
	
	
	//fontion juste pour tester
	public void autorisationlist(String employee,String type ,Topic topic) {
		Query query = (Query) entityManager.createQuery("SELECT h FROM Historique h ");
		
	    List<Historique> list = query.getResultList();
	    
	    for(Historique histo:list) {
	    	System.out.println(histo.getType());
	    	System.out.println(histo.getEmployee().getName());
	    	if((histo.getEmployee().getName()).equals("abdou")) {
	    		System.out.println("mawjoud");
	    	}
	    	else {
	    		System.out.println("mouch mawjoud");
	    	}
	    }
	
	   
	}
	
}
