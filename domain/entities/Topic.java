package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Topic
 *
 */
@Entity

public class Topic implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(name="TEXT", length=512)
	private String text;
	private String date;
	private String state;
	private int nbVue;
	private int nbLike;
	private int nbDislike;
	private String dependency;
	private int note;
	private int nbSignale;
	private String stateTopic;
	private String keywords;
	private int nbResponse;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Employee employee;
	@OneToMany(mappedBy="topic")
	private List<Comment> comment;
	@OneToMany(mappedBy="topic")
	private List<Historique> historique;
	@OneToMany(mappedBy="topic")
	private List<Notification> notification;
	
	public Topic() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}   
	public int getNbVue() {
		return this.nbVue;
	}

	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
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
	
	public String getDependency() {
		return this.dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}   
	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}   
	public int getNbSignale() {
		return this.nbSignale;
	}

	public void setNbSignale(int nbSignale) {
		this.nbSignale = nbSignale;
	}
	public String getStateTopic() {
		return stateTopic;
	}
	public void setStateTopic(String stateTopic) {
		this.stateTopic = stateTopic;
	}
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Topic(String title, String text, String date, String state, int nbVue, int nbLike, int nbDislike,
			 String dependency, int note, int nbSignale, String stateTopic) {
		this.title = title;
		this.text = text;
		this.date = date;
		this.state = state;
		this.nbVue = nbVue;
		this.nbLike = nbLike;
		this.nbDislike = nbDislike;
		this.dependency = dependency;
		this.note = note;
		this.nbSignale = nbSignale;
		this.stateTopic = stateTopic;
		
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getNbResponse() {
		return nbResponse;
	}
	public void setNbResponse(int nbResponse) {
		this.nbResponse = nbResponse;
	}
	public Topic(String title, String text, String date, String state, int nbVue, int nbLike, int nbDislike,
			String dependency, int note, int nbSignale, String stateTopic, String keywords, int nbResponse,
			Employee employee) {
		this.title = title;
		this.text = text;
		this.date = date;
		this.state = state;
		this.nbVue = nbVue;
		this.nbLike = nbLike;
		this.nbDislike = nbDislike;
		this.dependency = dependency;
		this.note = note;
		this.nbSignale = nbSignale;
		this.stateTopic = stateTopic;
		this.keywords = keywords;
		this.nbResponse = nbResponse;
		this.employee = employee;
	}
	public Topic(int id, String title, String text, String date, String state, int nbVue, int nbLike, int nbDislike,
			String dependency, int note, int nbSignale, String stateTopic, String keywords, int nbResponse,
			Employee employee) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
		this.state = state;
		this.nbVue = nbVue;
		this.nbLike = nbLike;
		this.nbDislike = nbDislike;
		this.dependency = dependency;
		this.note = note;
		this.nbSignale = nbSignale;
		this.stateTopic = stateTopic;
		this.keywords = keywords;
		this.nbResponse = nbResponse;
		this.employee = employee;
	}
	
   
	
	
}
