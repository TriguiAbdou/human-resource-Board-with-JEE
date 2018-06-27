package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity

public class Appointment implements Serializable {

	@EmbeddedId
	private AppointmentPk appointmentPk;
	private float time;
	@ManyToOne 
	@JoinColumn(name="id_user",referencedColumnName="USR_CODE",insertable=false,updatable=false)
	private User u;
	@ManyToOne
	@JoinColumn(name="id_offer",referencedColumnName="id",insertable=false,updatable=false)
	private Offer o;
	
	private static final long serialVersionUID = 1L;

	public Appointment() {
		super();
	}   
	public float getTime() {
		return this.time;
	}

	public void setTime(float time) {
		this.time = time;
	}
	
   
}
