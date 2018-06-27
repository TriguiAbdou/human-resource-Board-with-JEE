package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Notification;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceRemote;

public class MainTopic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/TopicService!tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceRemote";
		String JndiName3="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		try {
			context= new InitialContext();
			TopicServiceRemote proxy= (TopicServiceRemote) context.lookup(jndiName);
			EmployeeServiceRemote proxy3=(EmployeeServiceRemote) context.lookup(JndiName3);

			//#add a topic
			//proxy.save(new Topic("prob","comment afficher un message ??", "20/15/2018", "non resolu", 25, 2, 23, "depend", 3, 23, "related"));
			//proxy.save(new Topic("zaprob","cozamment afficher un message ??", "20az/15/2018", "non resoazlu", 25, 2, 23, "deazpend", 45, 23, "related"));
			//proxy.suppTopicSansReponse();
			
			//Employee employee=proxy3.find(7);
			//System.out.println(employee.getDepartment().getName());
			/*List<Topic> list=proxy.recommandedForYou(employee);
			for(Topic top:list) {
				System.out.println(top.getTitle());
			}*/
			/*Boolean bool;
			bool=proxy.TopicResolu("");
			System.out.println(bool);*/
			Employee em=proxy3.find(1);
			List<Notification> list=proxy.notifLIst(em);
			for(Notification top:list) {
				System.out.println(top.getType());
			}
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
