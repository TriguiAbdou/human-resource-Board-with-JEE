package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface EmployeeServiceLocal extends IGenericDAO<Employee>{
	void updateNote(String note,Employee employee);
	void updateScore(int score,Employee employee);
	public List<Employee> listEmployeesNotProject();
	public void scoreEmployee(Employee employee,Project project);
	
}
