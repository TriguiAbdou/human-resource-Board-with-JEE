package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Historique
 *
 */
@Entity

public class Historique implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Topic topic;
	@ManyToOne
	private Comment comment;
	
	
	
	public Historique() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Historique(String type, Employee employee, Topic topic) {
		this.type = type;
		this.employee = employee;
		this.topic = topic;
	}
	public Historique(String type, Employee employee, Comment comment) {
		this.type = type;
		this.employee = employee;
		this.comment = comment;
	}
	public Historique(String type, Topic topic) {
		this.type = type;
		this.topic = topic;
	}
	
	
   
}
