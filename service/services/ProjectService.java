package tn.esprit.b3.esprit1718b3hrboard.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.CheckIn;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class ProjectService extends GenericDAO<Project> implements ProjectServiceLocal,ProjectServiceRemote{
	@PersistenceContext
	EntityManager entityManager;
	
	
	public ProjectService(){
		super(Project.class);
	}
	//(USED)
	@Override
	public List<Employee> listEmployeesOfProject(Project project){
		Query query = (Query) entityManager.createQuery("SELECT e FROM Employee e WHERE e.project=:proj");
		query.setParameter("proj", project);
	     List<Employee> list = query.getResultList();
	return list;   	      
	}//return list employees of a project  
	
	
	
	//return nb employees of project
	public int nbEmployeesOfProject(Project project){
		int i=0;
		Query query = (Query) entityManager.createQuery("SELECT u FROM User u WHERE u.project=:proj");
		query.setParameter("proj", project);
	     List<User> list = query.getResultList();
	     for (User l:list) {
	    	 i=i+1;
	     }
	return i;   	      
	}
	
	
	//(USED)
	//return if employee is on vacation during a project or not
	public boolean EmployeeAvailable(Employee employee,Project project) {
		Query query = (Query) entityManager.createQuery("SELECT v FROM Vacation v WHERE v.user_vac=:empl");
		query.setParameter("empl", employee);
	    List<Vacation> list = query.getResultList();
	    boolean ok=true;
	    int a,b;
	    for (Vacation v:list) {
	    	if (v.getStatut().equals("approuved")) {
	    		a=(v.getEndDate()).compareTo(project.getStartDate());
	    		b=(v.getStartDate().compareTo(project.getEndDate()));
	    		if ((a>0)||(b<0)) {
	    			ok=false;
	    		}
	    		else {
	    			ok=true;
	    		}
	    	}
	    }
	    return ok;
	}
	
	
	
	
	//return if employee is absent for a project or not (USED)
	public boolean employeeAbsent(Employee employee) {
		
		Query query = (Query) entityManager.createQuery("SELECT ch FROM CheckIn ch WHERE ch.user=:empl");
		query.setParameter("empl", employee);
	    List<CheckIn> list = query.getResultList();
	    boolean present=false;
	    Calendar cal = Calendar.getInstance();
	    DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date myDate;
	    try {
			myDate = day.parse( day.format(cal.getTime()) );
			for (CheckIn ch:list) {
				long intervalle1=(ch.getDay().getTime());
				long intervalle2=(ch.getDay().getTime()) + 21600000 ;
				long sysDate=myDate.getTime();
				if((intervalle1 < sysDate)&&(sysDate<intervalle2)) {
					present=true;
				}
				else {
					present =false;
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return present;
	}
	
	
	
	
	//return list of the absent employees of a specific project in parameter (USED)
	public List<Employee> employeeProjectAbsent(Project project) {
		List<Employee> listEmployee =new ArrayList<>();
		List<Employee> listEmployeeAbsent =new ArrayList<>();
		listEmployee=listEmployeesOfProject(project);
		boolean presence=false;
		for(Employee emplo:listEmployee) {
			presence=employeeAbsent(emplo);
			if(presence==false) {
				listEmployeeAbsent.add(emplo);
			}
		}
		return listEmployeeAbsent;
	}
	
	
	
	//test de creation d'un planning automatiquement  (USED)
	public void createPlanning(Employee employee,Project project) {
		int i;
		for (i=1;i<=project.getDuration();i++ ) {
			String date="";
			date = i+"éme jour";
			entityManager.persist(new Planning(date, "Project",project.getName(), project.getDescription(), "a faire", "not",employee));
		}
	}
	
	
	//(USED)
	//fonction qui affecte un etat a un projet selon le score des employees affectés a ce projet
	public void projectState(Project project) {
		
	    List<Employee> list = listEmployeesOfProject(project);
	    int allScore=0;
	    for(Employee emp:list) {
	    	allScore=allScore+(emp.getScore());
	    }
	    if (   allScore   == ((project.getNbOfEmployee()) *100)) {
	    	project.setAdvenced("Excelent");
	    	project.setState("the project will end in the estimated date");
	    }
	    else if ((   allScore   <  ((project.getNbOfEmployee()) *100)) && (   allScore   >=  ((project.getNbOfEmployee()) *80))) {
	    	project.setAdvenced("Good");
	    	project.setState("Maybe the project will end in the estimated date");
	    }
	    else if ((   allScore   <  ((project.getNbOfEmployee()) *80)) && (   allScore   >=  ((project.getNbOfEmployee()) *40))) {
	    	project.setAdvenced("Not bad");
	    	project.setState("Maybe the project will end in the estimated date");
	    }
	    else {
	    	project.setAdvenced("Bad");
	    	project.setState("Warning ,the project is not going to end in the estimated date");
	    }
	    entityManager.merge(project);
	}
	
	
//	(USED)
	public List<Project> listProjectsOfEmployees(Department department){
		Query query = (Query) entityManager.createQuery("SELECT u FROM Project u WHERE u.department=:dep");
		query.setParameter("dep",department);
	     List<Project> list = query.getResultList();
	     
	     return list;
	}
	
	
	   public Project searchProject(String name){
			Project projet=null; 
			projet = entityManager.createQuery("SELECT p FROM Project p WHERE p.name=:nam",Project.class)
			 .setParameter("nam", name).getSingleResult();
			 
		      return projet;   	      
	  }//return list employees of a project  
			
		
	   public List<Project> searchProject1(String name){
		   Query query = (Query) entityManager.createQuery("SELECT u FROM Project u WHERE u.name=:nom");
			query.setParameter("nom",name);
		     List<Project> list = query.getResultList();
		     
		     return list;
	   }
	
}
