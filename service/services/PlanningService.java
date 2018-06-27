package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class PlanningService extends GenericDAO<Planning> implements PlanningServiceLocal,PlanningServiceRemote{

	@PersistenceContext
	EntityManager entityManager;
	
	public PlanningService() {
		super(Planning.class);
	}
	
	
	//(USED)
	//fonction qui mermet de creer le planning d'un employee affecter a un projet automatiquement
	public void createPlanning(Employee employee,Project project) {
		int i;
		for (i=1;i<=project.getDuration();i++ ) {
			String date="";
			date = i+"ieme jour";
			entityManager.persist(new Planning(date, "Project",project.getName(), project.getDescription(), "a faire", "not",employee));
		}
	}
	
	//(USED)
	//fonction qui permet modifier l'etat d'avancement du projet par l employee
	public void updateState(Planning planning,String state) {
		planning.setState(state);
		entityManager.merge(planning);
	}
	
	//(USED)
	//fonction qui retourne la liste dupanning 
	public List<Planning> ProjectState(Employee employee,Project project) {
		Query query = (Query) entityManager.createQuery("SELECT p FROM Planning p WHERE p.user=:emplo");
		query.setParameter("emplo", employee);
	    List<Planning> list = query.getResultList();
	    return list;
	}
	
	//(USED)
	//affectation un employee a un projet
	 public void affectationProjEmp(Employee employee,Project project) {
		 employee.setProject(project);	
		 entityManager.merge(employee);
	}
	 
}
