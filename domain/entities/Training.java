package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Training
 *
 */
@Entity

public class Training implements Serializable {

	   
	@Id
	private int id;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="t")
	private List<Booking> booking;
	
	public Training() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
