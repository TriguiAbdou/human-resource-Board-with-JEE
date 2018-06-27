package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);
	
}
