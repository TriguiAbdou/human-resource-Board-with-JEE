package tn.esprit.b3.esprit1718b3hrboard.mBeans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.services.CommentServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.NotificationServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceLocal;

@ManagedBean
@SessionScoped
public class CommentBean {	
	
	
	@ManagedProperty(value="#{identity}")
	 private Identity identity ;
	
	
	@EJB
	CommentServiceLocal commentServiceLocal;
	@EJB
	TopicServiceLocal topicServiceLocal;
	@EJB
	NotificationServiceLocal notificationServiceLocal;
	private Comment comment=new Comment();
	private List<Comment> liste;
	private Comment commentt;
	private Notification not=new Notification() ;
	
	
	public CommentServiceLocal getCommentServiceLocal() {
		return commentServiceLocal;
	}
	public void setCommentServiceLocal(CommentServiceLocal commentServiceLocal) {
		this.commentServiceLocal = commentServiceLocal;
	}
	
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Comment> getListe() {
		return liste;
	}
	public void setListe(List<Comment> liste) {
		this.liste = liste;
	}
	public Comment getCommentt() {
		return commentt;
	}
	public void setCommentt(Comment commentt) {
		this.commentt = commentt;
	}
	
	
	
	public void createComment(Topic topic) {
		try {
			Calendar cal = Calendar.getInstance();
		    DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date myDate;
			myDate = day.parse( day.format(cal.getTime()) );
			String datee=day.format(myDate);
			comment.setDate(datee);
			comment.setNbDislike(0);
			comment.setNbLike(0);
			comment.setNbSignale(0);
			comment.setState("not interesting");
			comment.setTopic(topic);
			comment.setPublisher(identity.getUser().getLastName());
			commentServiceLocal.save(comment);
			topic.setNbResponse((topic.getNbResponse())+1);
			
			
			not.setType("comment");
			not.setEmployee((Employee) identity.getUser());
			not.setTopic(topic);
			notificationServiceLocal.save(not);
			not=new Notification();
			String publisherComment=comment.getPublisher();
			String publisherTopic=topic.getEmployee().getLastName();
			if(publisherComment.equals(publisherTopic)) {
				boolean bool=false;
				bool=topicServiceLocal.TopicResolu(comment.getText());
				if(bool == true) {
					topic.setStateTopic("resolved");
				}
				else if (bool == false){
					topic.setStateTopic("unresolved");
				}
				topicServiceLocal.update(topic);
			}
			comment=new Comment();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Comment> getliste(){
		liste=commentServiceLocal.findAll();
	return liste;
	}
	
	public List<Comment> listcommentaire(Topic topic){
		List<Comment> lista;
		lista=commentServiceLocal.listComment(topic);
		return lista;
	}
	
	
	public void DoLike(Comment comment) {
		comment.setNbLike((comment.getNbLike())+1);
		String a=commentServiceLocal.interComment(comment);
		comment.setState(a);
		commentServiceLocal.update(comment);
		
	}
	
	public void DoDislike(Comment comment) {
		comment.setNbDislike((comment.getNbDislike())+1);
		String a=commentServiceLocal.interComment(comment);
		comment.setState(a);
		commentServiceLocal.update(comment);
	}
	
	
}
