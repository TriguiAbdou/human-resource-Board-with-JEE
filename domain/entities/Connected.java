package tn.esprit.b3.esprit1718b3hrboard.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Connected
 *
 */
@Entity

public class Connected implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_CODE")
	private Long code;
	public Connected() {
		super();
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
