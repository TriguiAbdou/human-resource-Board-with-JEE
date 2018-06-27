package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface ProjectServiceRemote extends IGenericDAO<Project> {
	public List<Employee> listEmployeesOfProject(Project project);
	public int nbEmployeesOfProject(Project project);
	public boolean EmployeeAvailable(Employee employee,Project project);
	public boolean employeeAbsent(Employee employee);
	public List<Employee> employeeProjectAbsent(Project project);
	public void createPlanning(Employee employee,Project project);
	public void projectState(Project project);
	public List<Project> listProjectsOfEmployees(Department department);
	Project searchProject(String name);
	public List<Project> searchProject1(String name);
}
