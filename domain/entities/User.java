package tn.esprit.b3.esprit1718b3hrboard.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_user")
public class User implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_CODE")
	private int code;
	@Column(name = "USR_NAME")
	private String name;
	@Column(name = "USR_LastName")
	private String lastName;
	@Column(name = "USR_LOGIN")
	private String login;
	@Column(name = "USR_PWD")
	private String password;
	@Column(name = "USR_EMAIL")
	private String email;
	@Column(name = "role")
	private String role;
	@Column(name = "USR_CIN")
	private String cin;
	@Column(name = "USR_ADRESSE")
	private String adresse;
	@OneToOne
	private Contract contract ;
	@OneToMany(mappedBy="user")
	private List<CheckIn> checkin;
	@OneToMany(mappedBy="u")
	private List<Booking> bookings;
	@OneToMany(mappedBy="user_vac")
	private List<Vacation> vacation;
	@OneToMany(mappedBy="user_pay")
	private List<Pay> pay;
	@OneToMany(mappedBy="user_claim")
	private List<Claim> claim;
	@OneToMany(mappedBy="user_offer")
	private List<Offer> offer;
	@OneToMany(mappedBy="user")
	private List<Planning> planning;
	@ManyToOne
	private Department department;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Project project;
	
	@OneToMany(mappedBy = "user")
	private List<CommentEvent> commentUser;
	@OneToMany(mappedBy="user")
	private List<LikeEvent> likes;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}
	
	public User(String name,String lastName, String login, String password, String email, String role) {
		this.name = name;
		this.lastName=lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	

	public User(int code, String name, String lastName, String login, String password, String email, String role) {
		this.code = code;
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	

	public User(String name, String lastName, String login, String password, String email, String role, String cin,
			String adresse) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
		this.cin = cin;
		this.adresse = adresse;
	}
	
	
	

	public User(String name, String lastName, String login, String password, String email, String role, String cin,
			String adresse, Department department) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
		this.cin = cin;
		this.adresse = adresse;
		this.department = department;
	}
	
	public User(int code,String name, String lastName, String login, String password, String email, String role, String cin,
			String adresse, Department department) {
		this.code = code;
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
		this.cin = cin;
		this.adresse = adresse;
		this.department = department;
	}

	public User(String name, String login, String password, String email) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public User(String name) {
		this.name = name;
	}

	public User(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int code, String name, String lastName, String login, String password, String email, String role,String cin,
			String adresse ) {
		this.code = code;
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
		this.adresse=adresse;
		this.cin=cin;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<CheckIn> getCheckin() {
		return checkin;
	}

	public void setCheckin(List<CheckIn> checkin) {
		this.checkin = checkin;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Vacation> getVacation() {
		return vacation;
	}

	public void setVacation(List<Vacation> vacation) {
		this.vacation = vacation;
	}

	public List<Pay> getPay() {
		return pay;
	}

	public void setPay(List<Pay> pay) {
		this.pay = pay;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	public List<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(List<Planning> planning) {
		this.planning = planning;
	}

	public List<CommentEvent> getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(List<CommentEvent> commentUser) {
		this.commentUser = commentUser;
	}

	public List<LikeEvent> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeEvent> likes) {
		this.likes = likes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	

}
