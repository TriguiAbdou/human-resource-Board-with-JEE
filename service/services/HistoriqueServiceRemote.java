package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Historique;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface HistoriqueServiceRemote extends IGenericDAO<Historique> {
	public boolean autorisation(String employee,String type ,Topic topic);
	public void autorisationlist(String employee,String type ,Topic topic);
}
