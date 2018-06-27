package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;


@Remote
public interface EventServiceRemote extends IGenericDAO<Event>{

	
	public BookingEvent createBooking(BookingEvent booking);
	public void Participate(Event ct);
	public void UpdateDislike(Event ct);
	public void UpdateLike(Event ct);
}
