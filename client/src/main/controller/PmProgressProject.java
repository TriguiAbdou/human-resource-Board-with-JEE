package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class PmProgressProject implements Initializable {

	public ObservableList piechartData = FXCollections.observableArrayList();
	public List<Employee> listEmployeesProject;
	public List<Project> listprojects3;
	 @FXML
	    private JFXButton planning;

	    @FXML
	    private JFXButton employees;

	    @FXML
	    private JFXButton project;

	    @FXML
	    private JFXButton newProject;

	    @FXML
	    private Label access;

	    @FXML
	    private PieChart testchar;
	    
	    @FXML
	    private Label labelchaar;
	    
	    @FXML
	    private Label respo;

	    @FXML
	    void ConsulterPlanning(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmPlanning.fxml"));
			String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
			Context context;
			try {
				context=new InitialContext();
				EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

		    	int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
				Employee employeeConnected = proxy2.find(codeEmployeeConnected);
		    	if((employeeConnected.getPost()).equals("Responsable")) {
		    	access.setVisible(true);
		    	}else {
		    	try {
		        	
					 Parent root=(Parent)loader.load();
					 planning.getScene().setRoot(root);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
			
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    }
	    
	    @FXML
	    void Disconnect(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/b3/esprit1718b3hrboard/app/client/gui/Sign_in.fxml"));
	        try {
				 Parent root=(Parent)loader.load();
			     planning.getScene().setRoot(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void Home(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ProjectManagementHome.fxml"));
	        try {
				 Parent root=(Parent)loader.load();
				 planning.getScene().setRoot(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		

	    @FXML
	    void CreateNewProject(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmNewProject.fxml"));
	    	String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
			Context context;
	    	try {
				context=new InitialContext();
				EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

		    	int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
				Employee employeeConnected = proxy2.find(codeEmployeeConnected);
		    	if((employeeConnected.getPost()).equals("Responsable")) {
		    		try {
						 Parent root=(Parent)loader.load();
						 planning.getScene().setRoot(root);
					    } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					      }
		    		
		    	}else {
		    		respo.setVisible(true);
		    		
		    	}
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    }

	    @FXML
	    void ListEmployees(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListEmployees.fxml"));
	        try {
				 Parent root=(Parent)loader.load();
				 planning.getScene().setRoot(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void ListProjects(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListProjects.fxml"));
			String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
	    	Context context;
	    	try {
				context=new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				 listprojects3 = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
					for (Project lspro:listprojects3) {
						proxy.projectState(lspro);
					}
	    	} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	    	try {
				 Parent root=(Parent)loader.load();
				 planning.getScene().setRoot(root);
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		access.setVisible(false);
		respo.setVisible(false);
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		Context context;
		
			try {
				context=new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				listEmployeesProject=proxy.listEmployeesOfProject(ControllerPmListProjects.projectProgress);
				labelchaar.setText("The progress of project ".concat((ControllerPmListProjects.projectProgress).getName())); 
				for (Employee ls:listEmployeesProject) {
					 piechartData.addAll(
				    			new PieChart.Data(ls.getName(),ls.getScore())
				    			);
				 }
				 testchar.setData(piechartData);
				 if(((ControllerPmListProjects.projectProgress).getAdvenced()).equals("Bad")) {
					 testchar.setVisible(false);
					  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			          alert1.setTitle("Inform Dialog");
			          alert1.setHeaderText(null);
			          alert1.setContentText("This project is not started yet!");
			          alert1.show();
				 }
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

}
