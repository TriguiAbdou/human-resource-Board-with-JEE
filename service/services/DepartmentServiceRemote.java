package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface DepartmentServiceRemote extends IGenericDAO<Department> {
	public List<Employee> listEmployees(Department department);
	public List<Project> listProjectsDep(Department department);
	public boolean EmployeeAffectOrNot(Employee employee ,Department department);
}
