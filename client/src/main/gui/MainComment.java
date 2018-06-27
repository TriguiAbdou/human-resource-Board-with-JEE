package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Historique;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.HistoriqueServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceRemote;

public class MainComment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/HistoriqueService!tn.esprit.b3.esprit1718b3hrboard.services.HistoriqueServiceRemote";
		String jndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/TopicService!tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceRemote";
		String JndiName3="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		try {
			context= new InitialContext();
		
			HistoriqueServiceRemote proxy= (HistoriqueServiceRemote) context.lookup(jndiName);
			TopicServiceRemote proxy2= (TopicServiceRemote) context.lookup(jndiName2);
			EmployeeServiceRemote proxy3=(EmployeeServiceRemote) context.lookup(JndiName3);

			
			
			
			//boolean test=proxy.autorisation(proxy3.find(1),"like", proxy2.find(1));
			//System.out.println(test);
			//proxy.autorisationlist(proxy3.find(1),"like", proxy2.find(1));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
