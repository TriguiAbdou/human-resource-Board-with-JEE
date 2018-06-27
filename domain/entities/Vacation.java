package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vacation
 *
 */
@Entity

public class Vacation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nbJour;
	private Date startDate;
	private Date endDate;
	private String statut;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user_vac;
	@Enumerated(EnumType.STRING)
	Leave_type leave_type ;
	
	public Vacation() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getNbJour() {
		return this.nbJour;
	}

	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Leave_type getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(Leave_type leave_type) {
		this.leave_type = leave_type;
	}
	
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Vacation(int nbJour, Date startDate, Date endDate,String statut) {
		this.nbJour = nbJour;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statut=statut;
		
	}
	
	
   
}
