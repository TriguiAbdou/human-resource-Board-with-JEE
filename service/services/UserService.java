package tn.esprit.b3.esprit1718b3hrboard.services;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
	
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}
	
	
	
	
	 public User authenticate(String login, String password) {
	    	User found = null;
			String jpql = "select u from User u where u.login=:login and u.password=:password";
			TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
			query.setParameter("login", login);
			query.setParameter("password", password);
			try {
			System.out.print(found = query.getSingleResult());
			} catch (Exception ex) {
				Logger.getLogger(UserService.class.getName()).log(
						Level.WARNING,
						"authentication attempt failure with login=" + login
								+ " and password=" + password);
			}
			return found;
		}
	 
	 
	
	
}
