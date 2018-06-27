package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BookingPk
 *
 */
@Embeddable

public class BookingPk implements Serializable {

	private int id_user;
	private int id_training;
	
	
	private static final long serialVersionUID = 1L;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_training;
		result = prime * result + id_user;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingPk other = (BookingPk) obj;
		if (id_training != other.id_training)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}


	public BookingPk() {
		super();
	}
	

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_training() {
		return id_training;
	}

	public void setId_training(int id_training) {
		this.id_training = id_training;
	}

	

	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
}
