package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Department
 *
 */
@Entity

public class Department implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String relation_type;
	private int employeesNb;
	private String NumAdmin;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="department")
	private List<User> user;
	@OneToMany(mappedBy="department")
	private List<Project> project;

	public Department() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department(String name, String description, String relation_type) {
		this.name = name;
		this.description = description;
		this.relation_type = relation_type;
	
	}
	public Department(int id, String name, String description, String relation_type) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.relation_type = relation_type;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Department(List<User> user) {
		this.user = user;
	}
	public String getRelation_type() {
		return relation_type;
	}
	public void setRelation_type(String relation_type) {
		this.relation_type = relation_type;
	}
	public int getEmployeesNb() {
		return employeesNb;
	}
	public void setEmployeesNb(int employeesNb) {
		this.employeesNb = employeesNb;
	}
	public String getNumAdmin() {
		return NumAdmin;
	}
	public void setNumAdmin(String numAdmin) {
		NumAdmin = numAdmin;
	}
	public Department(String name, String description, String relation_type, int employeesNb, String numAdmin) {
		this.name = name;
		this.description = description;
		this.relation_type = relation_type;
		this.employeesNb = employeesNb;
		NumAdmin = numAdmin;
	}
	public Department(int id, String name, String description, String relation_type, int employeesNb, String numAdmin) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.relation_type = relation_type;
		this.employeesNb = employeesNb;
		NumAdmin = numAdmin;
	}
	
	
	
	
	
	
	
	
   
}
