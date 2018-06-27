package tn.esprit.b3.esprit1718b3hrboard.services;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface NotificationServiceRemote extends IGenericDAO<Notification>{

}
