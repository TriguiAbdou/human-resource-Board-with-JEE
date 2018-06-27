package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quizs
 *
 */
@Entity

public class Event implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@OneToMany(mappedBy = "event")
	private List<BookingEvent> bookingevent ;
	private int place;
	private String day;
	private String state;
	private String destination;
	private String description;
	private String image;
	private int NbrLike;
	private int NbrDislike;
	@OneToMany(mappedBy="event")
	private List<CommentEvent> commentevents;
	@OneToMany(mappedBy="event")
	private List<LikeEvent> likes;
	public List<CommentEvent> getCommentevents() {
		return commentevents;
	}


	public void setCommentevents(List<CommentEvent> commentevents) {
		this.commentevents = commentevents;
	}


	public int getNbrLike() {
		return NbrLike;
	}


	public void setNbrLike(int nbrLike) {
		NbrLike = nbrLike;
	}


	public int getNbrDislike() {
		return NbrDislike;
	}


	public void setNbrDislike(int nbrDislike) {
		NbrDislike = nbrDislike;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	


	


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Event() {
		super();
	}


	


	public Event(int place, String state) {
		super();
		this.place = place;
		this.state = state;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	private static final long serialVersionUID = 1L;


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


	public List<BookingEvent> getBookingevent() {
		return bookingevent;
	}


	public void setBookingevent(List<BookingEvent> bookingevent) {
		this.bookingevent = bookingevent;
	}


	public int getPlace() {
		return place;
	}


	public void setPlace(int place) {
		this.place = place;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
   
}
