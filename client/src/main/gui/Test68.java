package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;


public class Test68 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserConnected a;
		//Department b=new Department("commerciale");
		  
		  List<Department> listDepartment =new ArrayList<>();
		  List<User> listUser =new ArrayList<>();
		  List<Project> list =new ArrayList<>();
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		try {
			context = new InitialContext();
			DepartmentServiceRemote proxy =(DepartmentServiceRemote) context.lookup(jndiName);
			EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName);

			
			
			//proxy.save(new Department("commerciale", "reponsable de vente des produit","interne"));   //Add test
			
			
			/*listDepartment=proxy.findAll();
			  for(Department d: listDepartment) {
				  System.out.println(d.getName());      //List View test
			  }*/
			
			
			
			//System.out.println(proxy.find(7).getName());   //Search Test
		
			
			
			/*Department dep=proxy.find(7);
			dep.setName("aaa");			//Update test
			proxy.update(dep);*/
			
			
			
			//proxy.delete(proxy.find(2));    //Delete test
			
			
			
			
			/*listUser=proxy.listEmployees(new Department(1,"commerciale", "responsable de vente de produit","interne"));
			for (User u:listUser) {						
  	    	  System.out.println(u.getName());	    //list employees of a specific department
  	        }*/
			
			/*list=proxy.listProjectsDep(proxy.find(1));
			for(Project pro:list) {
				System.out.println(pro.getName());
			}*/
			
			
			boolean affect=proxy.EmployeeAffectOrNot(proxy2.find(3),proxy.find(1));
			System.out.println(affect);
			
			//System.out.println(proxy2.find(3).getProject().getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
