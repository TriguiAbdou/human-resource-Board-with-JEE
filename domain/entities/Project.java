package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int duration;
	private Date startDate;
	private int nbOfEmployee;
	private String advenced;
	private String state;
	private String remarque;
	private Date endDate;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="project")
	private List<User> user;
	@ManyToOne
	private Department department;

	public Project() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getNbOfEmployee() {
		return nbOfEmployee;
	}
	public void setNbOfEmployee(int nbOfEmployee) {
		this.nbOfEmployee = nbOfEmployee;
	}
	public String getAdvenced() {
		return advenced;
	}
	public void setAdvenced(String advenced) {
		this.advenced = advenced;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Project(String name, String description, int duration, Date startDate, int nbOfEmployee,
			String advenced, String state, String remarque , Department department,Date endDate) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.nbOfEmployee = nbOfEmployee;
		this.advenced = advenced;
		this.state = state;
		this.remarque = remarque;
		this.department =department;
		this.endDate=endDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Project(int id, String name, String description, int duration, Date startDate, int nbOfEmployee,
			String advenced, String state, String remarque, Department department,Date endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.nbOfEmployee = nbOfEmployee;
		this.advenced = advenced;
		this.state = state;
		this.remarque = remarque;
		this.department = department;
		this.endDate=endDate;
	}
	public Project(int id, String name, String description, int duration, Date startDate, int nbOfEmployee,
			String advenced, String state, String remarque, Date endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.nbOfEmployee = nbOfEmployee;
		this.advenced = advenced;
		this.state = state;
		this.remarque = remarque;
		this.endDate = endDate;
	}
	
	
	
	
	
	
	
   
}
