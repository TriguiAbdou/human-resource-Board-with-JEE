package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AppointmentPk
 *
 */
@Embeddable

public class AppointmentPk implements Serializable {

	private int id_user;
	private int id_offer;
	
	private static final long serialVersionUID = 1L;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_offer;
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
		AppointmentPk other = (AppointmentPk) obj;
		if (id_offer != other.id_offer)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}


	public AppointmentPk() {
		super();
	}
   
}
