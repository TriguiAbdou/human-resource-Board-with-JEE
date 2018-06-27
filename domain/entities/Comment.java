package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String publisher;
	private String date;
	private int nbLike;
	private int nbDislike;
	private int nbSignale;
	private String text;
	private String state;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Topic topic;
	@OneToMany(mappedBy="comment")
	private List<Historique> historique;
	
	public Comment() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public int getNbLike() {
		return this.nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}   
	public int getNbDislike() {
		return this.nbDislike;
	}

	public void setNbDislike(int nbDislike) {
		this.nbDislike = nbDislike;
	}   
	public int getNbSignale() {
		return this.nbSignale;
	}

	public void setNbSignale(int nbSignale) {
		this.nbSignale = nbSignale;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Comment(String publisher, String date, int nbLike, int nbDislike, int nbSignale, String text, String state,
			Topic topic) {
		this.publisher = publisher;
		this.date = date;
		this.nbLike = nbLike;
		this.nbDislike = nbDislike;
		this.nbSignale = nbSignale;
		this.text = text;
		this.state = state;
		this.topic = topic;
	}
   
}
