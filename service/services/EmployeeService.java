package tn.esprit.b3.esprit1718b3hrboard.services;

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
public class EmployeeService extends GenericDAO<Employee> implements EmployeeServiceLocal,EmployeeServiceRemote {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public EmployeeService() {
		super(Employee.class);
	}
	
	
	//(USED)
	 //ajouter une remarque sur un employees
	 public void updateNote(String note,Employee employee) {
		 employee.setNote(note);
		 entityManager.merge(employee);
	 }
	 
	 
	 //ajouter un score a un employee
	 public void updateScore(int score,Employee employee) {
		 employee.setScore(score);
		 entityManager.merge(employee);
	 }
	 
	 
	//return list employees has not a project !!!but warnning !not doing
	 public List<Employee> listEmployeesNotProject(){
		 Query query = (Query) entityManager.createQuery("SELECT e FROM Employee e");
		 List<Employee> list = query.getResultList();
		 return list;   	      
		}
		
	
	 
	//(USED)
	 //fonction qui affecte un score a un employee donne selon sn avancement dans un projet donnee aussi
		public void scoreEmployee(Employee employee,Project project) {
			Query query = (Query) entityManager.createQuery("SELECT p FROM Planning p WHERE p.user=:emplo");
			query.setParameter("emplo", employee);
		    List<Planning> list = query.getResultList();
		    int bad=0;
		    int good=0;
		    int veryGood=0;
		    for(Planning pnl:list) {
		    	if((pnl.getState()).equals("Bad")){
		    		bad=bad+1;
		    	}
		    	else if((pnl.getState()).equals("Good")){
		    		good=good+1;
		    	}
		    	else if((pnl.getState()).equals("Very good")) {
		    		veryGood=veryGood+1;
		    	}
		    }
		    int duration=project.getDuration();
		    if(((duration/2)<veryGood)&&(bad<=1)){
		    	employee.setScore(100);
		    }
		    else if(((duration/2)<veryGood)&&(bad>=2)) {
		    	employee.setScore(80);
		    }
		    else if(((duration/2)>=veryGood) && (good>=(duration/2)) && (bad<=1)){
		    	employee.setScore(60);
		    }
		    else if((veryGood==0) && (good>=(duration/2)) && (bad<=1)){
		    	employee.setScore(60);
		    }
		    else if((veryGood<=1)&& ((duration/5)< good) && (good <=(duration/2))) {
		    	employee.setScore(40);
		    }
		    else if(bad> ((duration)-(duration/5))){
		    	employee.setScore(10);
		    }
		    else {
		    	employee.setScore(0);
		    }
		    entityManager.merge(employee);
		    
		
		}
		
	 
		
	 
	 
	 

}
