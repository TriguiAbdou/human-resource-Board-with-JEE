package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class ControllerListEmployeesProject implements Initializable {

	public List<Employee> listemployees;
	public List<Employee> listemployees2;
    public ObservableList<Employee> data;
    public List<Project> listprojects;
    public List<Project> listprojects3;
	  @FXML
	    private Label projectName;

	    @FXML
	    private TableView<Employee> employeesProject;

	    @FXML
	    private TableColumn<Employee, String> matricule;

	    @FXML
	    private TableColumn<Employee, String> Firstname;

	    @FXML
	    private TableColumn<Employee, String> Lastname;

	    @FXML
	    private TableColumn<Employee, String> email;

	    @FXML
	    private TableColumn<Employee, String> address;

	    @FXML
	    private TableColumn<Employee, String> post;

	    @FXML
	    private TableColumn<Employee, String> note;

	    @FXML
	    private TableColumn<Employee, Integer> score;
	    
	    @FXML
	    private Label access;

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
					 projectName.getScene().setRoot(root);
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
				 access.getScene().setRoot(root);
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
				 access.getScene().setRoot(root);
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
						 projectName.getScene().setRoot(root);
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
				 projectName.getScene().setRoot(root);
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
				 projectName.getScene().setRoot(root);
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	    	
	    }

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		access.setVisible(false);
		respo.setVisible(false);
		Context context;
		try {
			context=new InitialContext();
			ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
			EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

			matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
			Firstname.setCellValueFactory(new PropertyValueFactory<>("name"));
			Lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			email.setCellValueFactory(new PropertyValueFactory<>("email"));
			address.setCellValueFactory(new PropertyValueFactory<>("adresse"));
			post.setCellValueFactory(new PropertyValueFactory<>("post"));
			note.setCellValueFactory(new PropertyValueFactory<>("note"));
			score.setCellValueFactory(new PropertyValueFactory<>("score"));
			
			listemployees = proxy.listEmployeesOfProject(ControllerPmListProjects.projectConsult);
			for(Employee lst:listemployees) {
				proxy2.scoreEmployee(lst, ControllerPmListProjects.projectConsult);
			}
			listemployees2 = proxy.listEmployeesOfProject(ControllerPmListProjects.projectConsult);

			data=FXCollections.observableArrayList(listemployees2);
			employeesProject.setItems(data);
			projectName.setText(ControllerPmListProjects.projectConsult.getName());
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
