package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity

public class Booking implements Serializable {

	@EmbeddedId
	private BookingPk bookingpk;
	private Date date;
	@ManyToOne 
	@JoinColumn(name="id_user",referencedColumnName="USR_CODE",insertable=false,updatable=false)
	private User u;
	@ManyToOne
	@JoinColumn(name="id_training",referencedColumnName="id",insertable=false,updatable=false)
	private Training t;
	
	private static final long serialVersionUID = 1L;

	public BookingPk getBookingpk() {
		return bookingpk;
	}

	public void setBookingpk(BookingPk bookingpk) {
		this.bookingpk = bookingpk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getC() {
		return u;
	}

	public void setC(User c) {
		this.u = c;
	}

	public Training getT() {
		return t;
	}

	public void setT(Training t) {
		this.t = t;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Booking() {
		super();
	}
   
}
