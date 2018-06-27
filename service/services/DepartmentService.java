package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
public class DepartmentService extends GenericDAO<Department> implements DepartmentServiceLocal,DepartmentServiceRemote{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public DepartmentService() {
		super(Department.class);
	}
	
	
	//(USED)
	@Override
	public List<Employee> listEmployees(Department department){
		Query query = (Query) entityManager.createQuery("SELECT u FROM User u WHERE u.department=:dep");
		query.setParameter("dep", department);
	    List<Employee> list = query.getResultList();
	return list;   	      
	}//return list user of specific department 
	
	//(USED)
	public List<Project> listProjectsDep(Department department){
		Query query = (Query) entityManager.createQuery("SELECT p FROM Project p WHERE p.department=:dep");
		query.setParameter("dep", department);
	    	      List<Project> list = query.getResultList();
	return list;   	
	}
	//(USED)
	public boolean EmployeeAffectOrNot(Employee employee ,Department department) {
		List<Project> list=listProjectsDep(department);
		boolean affect=false;
		for(Project pro:list) {
			try {
			if((employee.getProject().getName()).equals(pro.getName())) {
				affect=true;
			}
			
		}
		catch(NullPointerException e){
			affect=false;
			}
		}
		return affect;
	}
	
	
	
	
}
