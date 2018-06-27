package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CheckIn
 *
 */
@Entity

public class CheckIn implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private Date day;
	private Long time;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	

	public CheckIn() {
		super();
	}


	public CheckIn(String type) {
		this.type=type;
	}

	
	public CheckIn( String type, Date day, Long time, User user) {
		super();
		
		this.type = type;
		this.day = day;
		this.time = time;
		this.user = user;
	}


	public CheckIn(String type, Date day, Long time) {
		super();
		this.type = type;
		this.day = day;
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	


	public Date getDay() {
		return day;
	}


	public void setDay(Date day) {
		this.day = day;
	}


	public Long getTime() {
		return time;
	}


	public void setTime(Long time) {
		this.time = time;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	   
}
