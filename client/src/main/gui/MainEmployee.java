package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;

public class MainEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		Context context;
		try {
			context=new InitialContext();
			EmployeeServiceRemote proxy=(EmployeeServiceRemote) context.lookup(JndiName);
			List<Employee> listEmployee =new ArrayList<>();
			List<Planning> listPlanning =new ArrayList<>();
			
			//test ajout d'une remarque a un employee
			/*proxy.updateNote("abdouu ya behi",proxy.find(3));*/
			
			
			//test ajout d'un score a un employee
			/*proxy.updateScore(5,proxy.find(3));*/
			
			
			/*listEmployee=proxy.listEmployeesNotProject();
			for(Employee emp:listEmployee) {
				System.out.println(emp.getName());
			}*/ //teste fondtion quiretourne les employee non pas affecter a un projet
			
			/*Calendar cal = Calendar.getInstance();
			DateFormat day = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println(day.format(cal.getTime()));*/
			
			
			//test du retoure de la liste de planning d'un employee
			/*
			listPlanning=proxy.ProjectState(proxy.find(3));
			for(Planning pl:listPlanning) {
				System.out.println("abdou");
			}*/
			
			
			
			
			
			//test d affectation automatique du score a lemployee selon son avancement sur un projet
		/*	SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
			Date myDate;
			Date myDate1;
			try {
				myDate = format.parse( "15/03/2018" );
				myDate1 = format.parse( "15/03/2018" );
				myDate1.setTime(myDate.getTime() + (15 * 24 * 3600 * 1000));
			Project project=new Project(3,"dev app","ce projet consiste a developpe une app mobile",6,myDate,18,"OK","not finish","this projeict could be edited any time",new Department(1,"commerciale", "responsable de vente de produit","interne"),myDate1);
		    proxy.scoreEmployee(proxy.find(3), project);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
