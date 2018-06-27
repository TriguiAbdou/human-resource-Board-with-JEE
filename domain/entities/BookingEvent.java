package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PersonalQuizs
 *
 */
@Entity

public class BookingEvent implements Serializable {

	
	@EmbeddedId
	private BookingEventId bookingeventId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UserID",referencedColumnName="USR_CODE", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id",referencedColumnName="id", insertable = false, updatable = false)
	private Event event;
	
	private static final long serialVersionUID = 1L;

	public BookingEvent() {
		super();
	}

	public BookingEvent(User user, Event event) {
		super();
		this.bookingeventId =new BookingEventId(user.getCode(),event.getId());
		this.user = user;
		this.event = event;
	}

	public BookingEvent(User user) {
		super();
		
		this.user = user;
		
	}
	public BookingEventId getBookingeventId() {
		return bookingeventId;
	}

	public void setBookingeventId(BookingEventId bookingeventId) {
		this.bookingeventId = bookingeventId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
   
}
