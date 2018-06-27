package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee extends User implements Serializable {

	
	private String post;
	private int score;
	private String note;
	private String approuved;
	private String matricule;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="employee")
	private List<Topic> topic;
	@OneToMany(mappedBy="employee")
	private List<Historique> historique;
	@OneToMany(mappedBy="employee")
	private List<Notification> notification ;
	
	
	public Employee() {
		super();
	}   
	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	public Employee(String post) {
		super();
		this.post = post;
	}
	public Employee(String name,String lastName, String login, String password, String email,String post,String role,String matricule ,String cin,
			String adresse) {
		super(name,lastName, login, password, email,role,cin,adresse);
		// TODO Auto-generated constructor stub
		this.post = post;
		this.matricule=matricule;
	}
	
	
	
	public Employee(String name, String lastName, String login, String password, String email,String post, String role,String matricule, String cin,
			String adresse, Department department) {
		super(name, lastName, login, password, email, role, cin, adresse, department);
		// TODO Auto-generated constructor stub
		this.post = post;
		this.matricule=matricule;
	}
	
	

	public Employee(int id,String name, String lastName, String login, String password, String email,String post, String role,String matricule, String cin,
			String adresse, Department department) {
		super(id,name, lastName, login, password, email, role, cin, adresse, department);
		// TODO Auto-generated constructor stub
		this.post = post;
		this.matricule=matricule;
	}
	
	
	
	public Employee(int id,String name,String lastName, String login, String password, String email,String post,String role,String matricule,String cin,
			String adresse) {
		super(id,name,lastName, login, password, email,role,cin,adresse);
		// TODO Auto-generated constructor stub
		this.post = post;
		this.matricule=matricule;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getApprouved() {
		return approuved;
	}
	public void setApprouved(String approuved) {
		this.approuved = approuved;
	}
	
	
	
	
	
	
	
   
}
