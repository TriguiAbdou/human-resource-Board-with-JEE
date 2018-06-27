package tn.esprit.b3.esprit1718b3hrboard.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.IGenericDAO;

@Remote
public interface TopicServiceRemote extends IGenericDAO<Topic> {
	public int nbCommentsOfTopic(Topic topic);
	public List<Topic> topicsOfEmployee(Employee employee);
	public void signalez(Topic topic);
	public String detaillerDate(String date);
	public void suppTopicSansReponse();
	public void stateTopic();
	public List<Topic> recommandedForYou(Employee employee);
	public Boolean TopicResolu(String commentaire);
	public List<Topic> recherche(String mot);
	public List<Notification> notifLIst(Employee employee);
	public String messageNotif(Notification notification);
}
