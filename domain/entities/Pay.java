package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pay
 *
 */
@Entity

public class Pay implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float prime;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user_pay;

	public Pay() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getPrime() {
		return this.prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}
   
}
