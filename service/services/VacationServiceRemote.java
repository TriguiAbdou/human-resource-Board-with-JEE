package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface VacationServiceRemote extends IGenericDAO<Vacation>{

}
