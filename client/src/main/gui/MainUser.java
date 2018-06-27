package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.services.UserServiceRemote;

public class MainUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/UserService!tn.esprit.b3.esprit1718b3hrboard.services.UserServiceRemote";
		Context context;
		try {
			
			
			context=new InitialContext();
			UserServiceRemote proxy=(UserServiceRemote) context.lookup(JndiName);
			
			
			//Affectation employee in project test
			/*Project project=new Project(1,"dev app","ce projet consiste a developpe une app mobile","15j","19/03/2018",18,"OK","not finish","this projeict could be edited any time",new Department(1,"commerciale", "responsable de vente de produit","interne"));
			proxy.affectationProjEmp(proxy.find(3),project);*/
		
			
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
