package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Employee> listEmployee =new ArrayList<>();
		List<Vacation> listVacation =new ArrayList<>();
		List<Project> list =new ArrayList<>();
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		
		try {
			
			context= new InitialContext();
			ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
			EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

			
			
			//ajouter un projet tel que la date de fin d'enregistre automatiquement selon la date de debut et la duree 
			SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss" );
			Date myDate;
			Date myDate1;
			try {
				myDate = format.parse( "15-03-2018 08:00:00" );
				myDate1 = format.parse( "15-03-2018 08:00:00" );
				myDate1.setTime(myDate.getTime() + ((15 * 24 * 3600 * 1000)+32400000));
			proxy.save(new Project("dev app","ce projet consiste a developpe une app mobile",6,myDate,18,"OK","not finish","this projeict could be edited any time",new Department(1,"commerciale", "responsable de vente de produit","interne"),myDate1));       //Add test
				//System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			 //List View test
			/*listProject=proxy.findAll();
			  for(Project p:listProject) {
				  System.out.println(p.getName());     
			  }*/
			
			//Search test
			//System.out.println(proxy.find(1).getName());    
 			
			
			//update test
			/*Project p=proxy.find(1);
			p.setDescription("aaaa");   
			proxy.update(p);*/
			
			//delete test
			//proxy.delete(proxy.find(1));     
			
			
			//list of employees affected to project
			/*listEmployee =	proxy.listEmployeesOfProject(proxy.find(1));
				for(Employee u:listEmployee) {					
					System.out.println(u.getName());
				}
			*/
			
			
			
			//Return nb of employees of project
			//System.out.println(proxy.nbEmployeesOfProject(proxy.find(1)));   
			
			
			
			
			//test si un employee est en conge durant un projet ou non
			/*Employee employee=proxy2.find(6);
			boolean a=proxy.EmployeeAvailable(employee, proxy.find(1));
			System.out.println(a);*/
			
			
			
			//tester si un emlpoyee est absent ou nn
			/*
			Employee employee=new Employee(3,"abdou", "trigui","123","trigui.abdou95@gmail.com","PDG","employee");
			System.out.println(proxy.employeeAbsent(employee));
			*/
			
			
			//tester si les employees affecter a un projet donnee sont absent ou non
			/*listEmployee=proxy.employeeProjectAbsent(proxy.find(1));
			for(Employee u:listEmployee) {					
				System.out.println(u.getName());
			}*/
			
			
		/*	Employee employee=new Employee(3,"dou","trigui","trigui","123","trigui.abdou95@gmail.com","PDG","employee","0z7e468678","soukra","07468678");
			proxy.createPlanning(employee, proxy.find(1));*/
			
			/*int i;
			for(i=0;i<3;i++) {
			Date date=proxy.find(1).getStartDate();
			date.setTime(date.getTime()+ i*86400000 );
			System.out.println(date);
			}*/
			
			/*list=proxy.listProjectsOfEmployees(new Department(1,"commerciale", "reponsable de vente des produit","interne"));
			
			for(Project u:list) {					
				
				try {
					System.out.println(u.getStartDate());
					String test= format.format(u.getStartDate());
					Date test2=format.parse(test);
					System.out.println(test);
					System.out.println(test2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}*/
			
			//System.out.println(proxy2.find(3).getProject().getName());
			//test d'affectation automatique de l etat du projet
			//proxy.projectState(proxy.find(1));
			
			
			Employee employee=proxy2.find(6);
			employee.setProject(null);
			proxy2.update(employee);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
