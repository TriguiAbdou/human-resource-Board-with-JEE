package tn.esprit.b3.esprit1718b3hrboard.services;


import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
	User login(String login, String password);
	
}
