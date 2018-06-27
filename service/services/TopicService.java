package tn.esprit.b3.esprit1718b3hrboard.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.utilities.GenericDAO;

@Stateless
@LocalBean
public class TopicService extends GenericDAO<Topic> implements TopicServiceLocal,TopicServiceRemote {
	@PersistenceContext
	EntityManager entityManager;
	
	public TopicService() {
		super(Topic.class);
	}
	
	
	
	//return nb comments of topic given
		public int nbCommentsOfTopic(Topic topic) {
			Query query = (Query) entityManager.createQuery("SELECT c FROM Comment c WHERE c.topic=:top");
			query.setParameter("top", topic);
		    List<Comment> list = query.getResultList();
		    int nb = 0;
		    for(Comment ls:list) {
		    	nb++;
		    }
		return nb;    
		}
		
		
		
		
		//retunr list of topics of an employee 
		public List<Topic> topicsOfEmployee(Employee employee){
			Query query = (Query) entityManager.createQuery("SELECT t FROM Topic t WHERE t.employee=:emp");
			query.setParameter("emp", employee);
		     List<Topic> list = query.getResultList();
		return list;   	      
		}
		
		
		
		
		//permet d'incrementer le nb de signale d'un topic
		public void signalez(Topic topic) {
			boolean test=false;
			topic.setNbSignale((topic.getNbSignale())+1);
			entityManager.merge(topic);
			
		}
		
		
		
		//retourner la date depublication détailler
		public String detaillerDate(String date) {
			String msg = null;
			try {
				DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date d = day.parse(date);
				long publishDate=d.getTime();
				Calendar cal = Calendar.getInstance();
			    Date myDate;
				myDate = day.parse( day.format(cal.getTime()) );
				long actualDate=myDate.getTime();
				long diffDate=actualDate-publishDate;
				String plus;
				long mill;
				if( diffDate < 15000) {
					msg ="publish now";
				}
				else if ((15000 <= diffDate)&&(diffDate <60000)) {
					mill=diffDate/1000;
					plus =Long.toString(mill); 
					msg=plus.concat(" secondes ago");
				} 
				else if ((60000<= diffDate)&&(diffDate <3600000)){
					mill=diffDate/60000;
					plus =Long.toString(mill);
					msg=plus.concat(" minutes ago");
				}
				else if((3600000 <= diffDate)&&(diffDate< 86400000)){
					mill=diffDate/3600000;
					plus =Long.toString(mill);
					msg=plus.concat(" hours ago");
				}
				else {
					msg=date;
				}
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return msg;
		}
		
		
		//supprimer des sujets sans reponses aprés la duree proposée par l'utulisateur
		public void suppTopicSansReponse() {
			
				try {
					Query query = (Query) entityManager.createQuery("SELECT t FROM Topic t");
				    List<Topic> list = query.getResultList();
				     for(Topic top:list){
				    	 DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						 Date d;
						 d = day.parse(top.getDate());
						 long publishDate=d.getTime();
						 long gracePeriod=top.getNote()*86400000;
						 Calendar cal = Calendar.getInstance();
						 Date myDate;
						 myDate = day.parse( day.format(cal.getTime()) );
						 long actualDate=myDate.getTime();
						 if((publishDate+gracePeriod) <= actualDate) {
							 if(top.getNbResponse() == 0) {
							 entityManager.remove(top);
							 }
						 }
				     }
				     
				     
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
		public void stateTopic() {
			Query query = (Query) entityManager.createQuery("SELECT t FROM Topic t");
		    List<Topic> list = query.getResultList();
		    for(Topic top:list) {
		    	if((top.getNbLike()+top.getNbDislike() >= 3)&&(top.getNbLike() > (top.getNbDislike()/2))&&(top.getNbResponse()>2)) {
		    		top.setState("interesting");
		    	}
		    }   
		}
		
		//retourne la liste de recommandation des sujets des employees de meme départment que le user connected
		public List<Topic> recommandedForYou(Employee employee){
			Query query = (Query) entityManager.createQuery("SELECT t FROM Topic t");
		    List<Topic> list = query.getResultList();
		    
		    
		    for (Iterator<Topic> iterator = list.iterator(); iterator.hasNext(); ) {
		        Topic ls = iterator.next();
		        String dep=ls.getEmployee().getDepartment().getName();
		        System.out.println(dep);
		        String depp=employee.getDepartment().getName();
		        String statee=ls.getState();
		        if((dep.equals(depp))  || (statee.equals("interesting"))) {
		        }
		        else {
		        	iterator.remove();	
		        }
		    }
		    return list;
		}
		
		
		
		//retourne si le probélme est resolu ou non automatiquement a partir du commentaire écrit par l'utulisateur
		public Boolean TopicResolu(String commentaire) {
			Boolean resolu=false;
			int nb= commentaire.indexOf("résolue");
			int nb1= commentaire.indexOf("resolved");
			int nb2= commentaire.indexOf("résolu");
			int nb3= commentaire.indexOf("cette discussion est résolue");
			int nb4= commentaire.indexOf("thank you");
			int nb5= commentaire.indexOf("resolved problem");
			int nb6= commentaire.indexOf("probleme resolu");
			int nb7= commentaire.indexOf("this worked");
			int nb8= commentaire.indexOf("super");
			int nb9= commentaire.indexOf("j'ai trouvé la solution");
			int nb10= commentaire.indexOf("resolu");
			int nb11= commentaire.indexOf("résolue");
			if((nb>=0) || (nb1>=0) || (nb2>=0) || (nb3>=0) || (nb4>=0) || (nb5>=0) || (nb6>=0) || (nb7>=0) || (nb8>=0) || (nb9>=0) || (nb10 >= 0) || (nb11 >= 0)) {
				resolu =true;
			}
			else {
				resolu=false;
			}
		return resolu;	
		}
		
		
		
		//service de recherche selon deux criitere
		public List<Topic> recherche(String mot){
			Query query = (Query) entityManager.createQuery("SELECT t FROM Topic t");
		    List<Topic> list = query.getResultList();
		    if(mot.equals("")) {
		    }
		    else {
			    for (Iterator<Topic> iterator = list.iterator(); iterator.hasNext(); ) {
			        Topic ls = iterator.next();
			    	String title=ls.getTitle();
			    	String key=ls.getKeywords();
			    	int a=key.indexOf(mot);
			    	if ((title.equals(mot)) || (a >= 0)) {
				    }
				    else {
				    	iterator.remove();		
				    }
			    }
		    }
		return list;
		}
		
	
		
		
		
		public List<Notification> notifLIst(Employee employee){
			Query query = (Query) entityManager.createQuery("SELECT t FROM Notification t");
		    List<Notification> list = query.getResultList();
		    for (Iterator<Notification> iterator = list.iterator(); iterator.hasNext(); ) {
		        Notification ls = iterator.next();
		        if((ls.getTopic().getEmployee().getLastName()).equals(employee.getLastName())) {
		        	
		        }
		        else {
		        	iterator.remove();
		        }
			
			
		    }
		    return list;
		}	

		
		public String messageNotif(Notification notification) {
			String msg = null;
			String not=notification.getType();
			if(not.equals("comment")) {
				msg="commented on your publication";	
			}
			else if(not.equals("like")) {
				msg="liked your publication" ;
			}
			else if(not.equals("dislike")) {
				msg="disliked your publication" ;
			}
			else if(not.equals("signale")) {
				msg="Your post has been reported by other users" ;
			}
			
		return msg;	
		}


}
