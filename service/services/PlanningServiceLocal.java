package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface PlanningServiceLocal extends IGenericDAO<Planning>{
	public void createPlanning(Employee employee,Project project);
	public void updateState(Planning planning,String state);
	public List<Planning> ProjectState(Employee employee,Project project);
	public void affectationProjEmp(Employee employee,Project project);
}
