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
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import tn.esprit.b3.esprit1718b3hrboard.entities.BookingEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.CommentEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.Event;
import tn.esprit.b3.esprit1718b3hrboard.entities.LikeEvent;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.services.BookingEventServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.CommentEventServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.EventServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.LikeEventServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.UserServiceLocal;



@ManagedBean
@SessionScoped
public class EventBean {
	@EJB
	EventServiceLocal eventserviceLocal;
	@EJB
	BookingEventServiceLocal bookingserviceLocal;
	@EJB
	UserServiceLocal userservice;
	@EJB
	CommentEventServiceLocal commentservice;
	@EJB
	LikeEventServiceLocal likeEventservice;
	int id;
	private Event ev;
	private Event event=new Event();
	private BookingEvent booking =new BookingEvent();
	private CommentEvent comment=new CommentEvent();
	
	private List<Event> liste;
	private String destination;
	private String commentDescription;
	private String commentDescription2;
	
	public LikeEventServiceLocal getLikeEventservice() {
		return likeEventservice;
	}

	public void setLikeEventservice(LikeEventServiceLocal likeEventservice) {
		this.likeEventservice = likeEventservice;
	}

	public String getCommentDescription2() {
		return commentDescription2;
	}

	public void setCommentDescription2(String commentDescription2) {
		this.commentDescription2 = commentDescription2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@PostConstruct
	public void init(){
		liste=eventserviceLocal.findAll();
		
	}
	
	public String load(){
		Event o=eventserviceLocal.find(ev.getId());
		
		return "edit?selected=" + o.getId() + "faces-redirect=true";
	}
	
	public String doDelete(Event e) {
		eventserviceLocal.delete(e);
		liste=eventserviceLocal.findAll();
		return "allevents?faces-redirect=true";
		
	}
	
	public List<Event> getListe() {
		liste=eventserviceLocal.findAll();
		return liste;
	}

	public void setListe(List<Event> liste) {
		this.liste = liste;
	}

public String commenter(User u,Event e,String d) {
	Calendar cal = Calendar.getInstance();
		String v=null;
		comment.setDescription(commentDescription);
		comment.setUser(u);
		comment.setEvent(e);
		comment.setDate(cal.getTime());
		commentservice.save(comment);
		comment=new CommentEvent();
		if(u.getRole().equals("manager"))
		v= "detail?faces-redirect=true";
		else if(u.getRole().equals("employee"))
			v="detailEvent?faces-redirect=true";
		commentDescription=null;
			return v;
		
	}

public String Liked(User u,Event e){
	String v=null;
	List<LikeEvent> liste =likeEventservice.search(e, u);
	if(liste.size()!=0){
		
	
	for(LikeEvent i:liste){
		i.setEvent(e);
		i.setState("like");
		i.setUser(u);
		likeEventservice.update(i);
	}}
	else{
		LikeEvent i=new LikeEvent();
		i.setEvent(e);
		i.setState("like");
		i.setUser(u);
		likeEventservice.update(i);
	}
	
	if(u.getRole().equals("manager"))
		v= "detail?faces-redirect=true";
		else if(u.getRole().equals("employee"))
			v="detailEvent?faces-redirect=true";
		
			return v;
}

public String Disliked(User u,Event e){
	String v=null;
	List<LikeEvent> liste =likeEventservice.search(e, u);
	if(liste.size()!=0){
		
	
	for(LikeEvent i:liste){
		i.setEvent(e);
		i.setState("dislike");
		i.setUser(u);
		likeEventservice.update(i);
	}}
	else{
		LikeEvent i=new LikeEvent();
		i.setEvent(e);
		i.setState("dislike");
		i.setUser(u);
		likeEventservice.update(i);
	}
	
	if(u.getRole().equals("manager"))
		v= "detail?faces-redirect=true";
		else if(u.getRole().equals("employee"))
			v="detailEvent?faces-redirect=true";
		
			return v;
}
	public CommentEventServiceLocal getCommentservice() {
	return commentservice;
}

public void setCommentservice(CommentEventServiceLocal commentservice) {
	this.commentservice = commentservice;
}

public CommentEvent getComment() {
	return comment;
}

public void setComment(CommentEvent comment) {
	this.comment = comment;
}

public String getCommentDescription() {
	return commentDescription;
}

public void setCommentDescription(String commentDescription) {
	this.commentDescription = commentDescription;
}

	public String CreateEvent(){
				
				event.setState("empty");
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date sqldate = java.sql.Date.valueOf(day.format(new Date()));
				int d=Integer.parseInt(event.getDay().substring(0,2));
				int m=Integer.parseInt(event.getDay().substring(3,5));
				int a=Integer.parseInt(event.getDay().substring(6,10));
				
				if(sqldate.getMonth()==m && sqldate.getYear()==a && sqldate.getDate()<d && m<13 && d<30)
				{
				eventserviceLocal.save(event);
				}
				liste=eventserviceLocal.findAll();
				
				return "allevents?faces-redirect=true";
			
	}
	
	public String CreateBooking(User u){
		if(bookingserviceLocal.search(ev, u).size()==0){
			
		
		eventserviceLocal.Participate(ev);
		booking.setEvent(ev);
		BookingEvent bb = new BookingEvent(u,ev);
		booking.setUser(userservice.find(1));
		bookingserviceLocal.save(bb);}
		if(ev.getPlace()==0){
			ev.setState("full");
			eventserviceLocal.update(ev);
		}
		 return "testcard?faces-redirect=true";
		
	}
	
	public String Cancel(BookingEvent b){
		
		
		b.getEvent().setPlace(b.getEvent().getPlace()+1);
		bookingserviceLocal.delete(b);
		return "detailEvent?faces-redirect=true";
	
}
	
	
	
	public EventServiceLocal getEventserviceLocal() {
		return eventserviceLocal;
	}
	public void setEventserviceLocal(EventServiceLocal eventserviceLocal) {
		this.eventserviceLocal = eventserviceLocal;
	}
	public Event getEv() {
		return ev;
	}
	public void setEv(Event ev) {
		this.ev = ev;
	}
	
	public Event edit(int id){  
		Event ee=null;		 
		ee = new Event();  
		ee = eventserviceLocal.find(id);
		return ee;
		}
public String Detail() {
		
		
		Event o=eventserviceLocal.find(ev.getId());
		
			return "detailEvent?faces-redirect=true";
	
	}
public String DetailAdmin() {
	
	
	Event o=eventserviceLocal.find(ev.getId());
	
		return "detail?faces-redirect=true";

}

public BookingEventServiceLocal getBookingserviceLocal() {
	return bookingserviceLocal;
}

public void setBookingserviceLocal(BookingEventServiceLocal bookingserviceLocal) {
	this.bookingserviceLocal = bookingserviceLocal;
}

public UserServiceLocal getUserservice() {
	return userservice;
}

public void setUserservice(UserServiceLocal userservice) {
	this.userservice = userservice;
}


public String detaillerDate(Date date) {
	String msg = null;
	try {
		DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		long publishDate=date.getTime();
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
			msg=date.toString();
		}
		
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return msg;
}

	
}
