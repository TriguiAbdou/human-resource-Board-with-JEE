package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote;

public class MainPlanning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/PlanningService!tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote";
		Context context;
		
		try {
			context =new InitialContext();
			PlanningServiceRemote proxy=(PlanningServiceRemote) context.lookup(JndiName);
			
			
			//test de creation d'un planning pour un employee
			/*Employee employee=new Employee(3,"abdou", "trigui","123","trigui.abdou95@gmail.com","PDG","employee");
			proxy.createPlanning(employee, project);*/
			
			//proxy.updateState(proxy.find(1),"ok");
		//	List<Planning> listplanning =new ArrayList<>();
			//proxy.ProjectState(employee, project);
		/*} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}

}
