package tn.esprit.b3.esprit1718b3hrboard.mBeans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Historique;
import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.services.HistoriqueServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.NotificationServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceLocal;

@ManagedBean
@SessionScoped
public class TopicBean {
	
	@ManagedProperty(value="#{identity}")
	 private Identity identity ;
	
	@EJB
	TopicServiceLocal topicServiceLocal ;
	@EJB
	HistoriqueServiceLocal historiqueServiceLocal;
	@EJB
	NotificationServiceLocal notificationServiceLocal;
	private Topic topic=new Topic();
	private Topic topiccc;
	private List<Topic> liste;
	private String recherche;
	private String mott;
	private Notification not=new Notification() ;
	
	public HistoriqueServiceLocal getHistoriqueServiceLocal() {
		return historiqueServiceLocal;
	}
	public void setHistoriqueServiceLocal(HistoriqueServiceLocal historiqueServiceLocal) {
		this.historiqueServiceLocal = historiqueServiceLocal;
	}
	public Topic getTopiccc() {
		return topiccc;
	}
	public void setTopiccc(Topic topiccc) {
		this.topiccc = topiccc;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public void setListe(List<Topic> liste) {
		this.liste = liste;
	}
	public void createTopic() {
		 try {
			 Calendar cal = Calendar.getInstance();
		    DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date myDate;
			myDate = day.parse( day.format(cal.getTime()) );
			String datee=day.format(myDate);
			topic.setDate(datee);
			topic.setStateTopic("unresolved");
			topic.setNbDislike(0);
			topic.setNbLike(0);
			topic.setNbSignale(0);
			topic.setNbVue(0);
			topic.setState("null");
			System.out.println(identity.getUser().getName());
			topic.setEmployee((Employee) identity.getUser());
			topicServiceLocal.save(topic);
			//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, , ));
			//FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","Topic has been added successfully");
	        //FacesContext.getCurrentInstance().addMessage(null, message);
			topic=new Topic();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Dodelete(Topic topic) {
		if(topic.getStateTopic().equals("unresolved")) {
		topicServiceLocal.delete(topic);
		//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Topic has been added successfully"));

		}
	}
	public TopicServiceLocal getTopicServiceLocal() {
		return topicServiceLocal;
	}
	public void setTopicServiceLocal(TopicServiceLocal topicServiceLocal) {
		this.topicServiceLocal = topicServiceLocal;
	}
	
	/*@PostConstruct
	public void init(){
		liste=topicServiceLocal.findAll();
		
	}*/
	
	public List<Topic> getListe() {
		
		topicServiceLocal.stateTopic();
		liste=topicServiceLocal.findAll();
		for (Topic top:liste) {
			int nb;
			nb=topicServiceLocal.nbCommentsOfTopic(top);
			top.setNbResponse(nb);
			topicServiceLocal.update(top);
		}
		topicServiceLocal.suppTopicSansReponse();
		return liste;
	}
	
	
	public void doUpdate(Topic topic) {
		if((topic.getNbResponse())==0) {
		topicServiceLocal.update(topic);
		}
	}
	
	public String nbVue(Topic topic) {
		topic.setNbVue((topic.getNbVue())+1);
		topicServiceLocal.update(topic);
		String lien="view.jsf";
		return lien;
	}
	
	
	public List<Topic> listTopicEmployee(){
		List<Topic> listee;
		listee=topicServiceLocal.topicsOfEmployee((Employee) identity.getUser());
		return listee;
	}
	
	public void doLike(Topic topic) {
		
		boolean canLike =historiqueServiceLocal.autorisation(identity.getUser().getName(), "like", topic);
		List<Historique> histo = null;
		if(canLike==false) {
			topic.setNbLike((topic.getNbLike())+1);
			topicServiceLocal.update(topic);
			not.setType("like");
			not.setEmployee((Employee) identity.getUser());
			not.setTopic(topic);
			notificationServiceLocal.save(not);
			not=new Notification();
			Historique historique=new Historique("like",(Employee) identity.getUser(),topic);
			historiqueServiceLocal.save(historique);
		}	
		else if(canLike==true){
			topic.setNbLike((topic.getNbLike())-1);
			topicServiceLocal.update(topic);
			Employee employeeCOnnect =(Employee) identity.getUser();
			Historique searched = null;
			histo=historiqueServiceLocal.findAll();
			for(Historique his:histo) {
				if((his.getTopic().getId() == topic.getId()) && (his.getEmployee().getCode() == employeeCOnnect.getCode())   && ((his.getType()).equals("like"))) {
					searched = his;
				}
			}
			Historique historiquee = null;
			historiquee=historiqueServiceLocal.find(searched.getId());
			historiqueServiceLocal.delete(historiquee);
		}
	}	
	
	public void doDislike(Topic topic) {
		boolean canLike =historiqueServiceLocal.autorisation(identity.getUser().getName(), "dislike", topic);
		List<Historique> histo = null;
		if(canLike==false) {
			topic.setNbDislike((topic.getNbDislike())+1);
			topicServiceLocal.update(topic);
			not.setType("dislike");
			not.setEmployee((Employee) identity.getUser());
			not.setTopic(topic);
			notificationServiceLocal.save(not);
			not=new Notification();
			Historique historique=new Historique("dislike",(Employee) identity.getUser(),topic);
			historiqueServiceLocal.save(historique);
		}	
		else if(canLike==true){
			topic.setNbDislike((topic.getNbDislike())-1);
			topicServiceLocal.update(topic);
			Employee employeeCOnnect =(Employee) identity.getUser();
			Historique searched = null;
			histo=historiqueServiceLocal.findAll();
			for(Historique his:histo) {
				if((his.getTopic().getId() == topic.getId()) && (his.getEmployee().getCode() == employeeCOnnect.getCode())   && ((his.getType()).equals("dislike"))) {
					searched = his;
				}
			}
			Historique historiquee = null;
			historiquee=historiqueServiceLocal.find(searched.getId());
			historiqueServiceLocal.delete(historiquee);	
		}
	}
	
	
	//retrun true si le topic est signlaer(warning : a afficher un message d'info)
	public boolean testsignale(Topic topic) {
		boolean test=false;
		boolean canLike =historiqueServiceLocal.autorisation(identity.getUser().getName(), "signale", topic);
		if(canLike==false) {
		
		topicServiceLocal.signalez(topic);
		int nb=topic.getNbSignale();
		if(nb >= 7) {
			Topic topicrem=topicServiceLocal.find(topic.getId());
			topicServiceLocal.delete(topicrem);
			test=true;
		}
		}	
		
		return test;

	}
	
	
	
	//retourner la date détailler de publication
	public String publishdatee(String date) {
		String msg;
		msg=topicServiceLocal.detaillerDate(date);
	return msg;	
	}
	
	
	
	public String imageCorrepondant(Topic topic) {
		String src;
		if ((topic.getStateTopic()).equals("resolved")) {
			src="../assets/images/icon/color_18/checkmark2.png";
		}
		else {
			src="../assets/images/icon/color_18/cross.png";
		}
		return src;
	}
	
	
	
	public String stateTopic(Topic topic) {
		String src;
		if((topic.getState()).equals("interesting")) {
			src="interesting /";
		}
		else {
			src="";
		}
	return src;	
		
	}
	
	
	public List<Topic> recommandedList(){
		List<Topic> listecom=topicServiceLocal.recommandedForYou((Employee) identity.getUser());
	return listecom;	
	}
	
	
	public String resoTopic(Topic topic) {
		String src="";
		if((topic.getStateTopic()).equals("resolved")) {
			src="(resolved)" ;
		}
		else {
			src="";
		}
	return src;	
	}
	
	
	
	
	public String stateTopic1(Topic topic) {
		String src;
		if((topic.getState()).equals("interesting")) {
			src="(interesting)";
		}
		else {
			src="";
		}
	return src;	
		
	}
	
	
	public List<Topic> fctRecherche(String mot){
		List<Topic> list;
		list=topicServiceLocal.recherche(mot);
	
		return list;
	}
	
	
	public String getRecherche() {
		return recherche;
	}
	
	
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	
	
	public String getMott() {
		return mott;
	}
	
	
	
	public void setMott(String mott) {
		this.mott = mott;
	}
	
	
	
	public List<Notification> listNotif(){
		List<Notification> notif;
		notif=topicServiceLocal.notifLIst((Employee) identity.getUser());
		return notif;
	}
	
	
	public String msgg(Notification notif) {
		String msg;
		msg=topicServiceLocal.messageNotif(notif);
		return msg;
	}
	
	public void Dodelete1(Notification notif) {
		
		notificationServiceLocal.delete(notif);
		
	}
	
	
     
    
   
	

}
