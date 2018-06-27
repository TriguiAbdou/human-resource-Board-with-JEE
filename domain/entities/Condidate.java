package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;

/**
 * Entity implementation class for Entity: Condidate
 *
 */
@Entity

public class Condidate extends User implements Serializable {

	
	private String cv;
	private static final long serialVersionUID = 1L;

	public Condidate() {
		super();
	}   
	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
	public Condidate(int code, String name) {
		super(code, name);
		// TODO Auto-generated constructor stub
	}
	public Condidate(String name,String lastName, String login, String password, String email, String role,String cv) {
		super(name,lastName, login, password, email, role);
		this.cv=cv;
		// TODO Auto-generated constructor stub
	}
	
	
	
   
}
