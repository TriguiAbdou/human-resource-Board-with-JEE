package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookingEventId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private int id;
	
	
	
	public BookingEventId() {
		super();
	}
	public BookingEventId(int userId, int id) {
		super();
		this.userId = userId;
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + id;
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
		BookingEventId other = (BookingEventId) obj;
		if (userId != other.userId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
