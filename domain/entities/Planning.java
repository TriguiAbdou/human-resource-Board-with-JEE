package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Planning
 *
 */
@Entity

public class Planning implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private String type;
	private String name;
	private String description;
	private String note;
	private String state;
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	

	public Planning() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Planning(String date, String type, String name, String description, String note, String state) {
		this.date = date;
		this.type = type;
		this.name = name;
		this.description = description;
		this.note = note;
		this.state = state;
	}
	public Planning(String date, String type, String name, String description, String note, String state, User user) {
		this.date = date;
		this.type = type;
		this.name = name;
		this.description = description;
		this.note = note;
		this.state = state;
		this.user = user;
	}
   
}
