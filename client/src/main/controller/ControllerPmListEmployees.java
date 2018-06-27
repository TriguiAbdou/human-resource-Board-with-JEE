package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

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
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

import java.util.concurrent.*;

public class ControllerPmListEmployees implements Initializable {

		public List<Employee> listemployees;
	    public ObservableList<Employee> data;
	    public List<Project> listprojects;
	
	    @FXML
	    private JFXButton planning;

	    @FXML
	    private JFXButton employees;

	    @FXML
	    private JFXButton project;

	    @FXML
	    private JFXButton newProject;
	    
	   @FXML
	    private TableView<Employee> listEmployees;

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
	    private JFXTextField setScore;

	    @FXML
	    private JFXButton done;
	    
	    @FXML
	    private Label selectedId;
	    
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
				 done.getScene().setRoot(root);
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
				 listprojects = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
					for (Project lspro:listprojects) {
						proxy.projectState(lspro);
					}
	    	} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	    	try {
				 Parent root=(Parent)loader.load();
			    done.getScene().setRoot(root);
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void SetScore(ActionEvent event) {

	    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		access.setVisible(false);
		respo.setVisible(false);
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		String jndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";

		Context context;
		try {
			context=new InitialContext();
			EmployeeServiceRemote proxy=(EmployeeServiceRemote) context.lookup(JndiName);
			DepartmentServiceRemote proxy2 =(DepartmentServiceRemote) context.lookup(jndiName2);

			matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
			Firstname.setCellValueFactory(new PropertyValueFactory<>("name"));
			Lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			email.setCellValueFactory(new PropertyValueFactory<>("email"));
			address.setCellValueFactory(new PropertyValueFactory<>("adresse"));
			post.setCellValueFactory(new PropertyValueFactory<>("post"));
			note.setCellValueFactory(new PropertyValueFactory<>("note"));
			score.setCellValueFactory(new PropertyValueFactory<>("score"));
			
			listemployees = proxy2.listEmployees(UserConnected.getUserConnected().getDepartment());
			data=FXCollections.observableArrayList(listemployees);
			listEmployees.setItems(data);
			
			
			listEmployees.setOnMouseClicked((Event) ->{
				setScore.setText(Integer.toString(data.get(listEmployees.getSelectionModel().getSelectedIndex()).getScore()));
				selectedId.setText(Integer.toString(data.get(listEmployees.getSelectionModel().getSelectedIndex()).getCode()));
			});
			
			done.setOnMouseClicked((Event) ->{
				int id=Integer.parseInt(selectedId.getText());
				Employee employeeSelected=proxy.find(id);
				employeeSelected.setScore(Integer.parseInt(setScore.getText()));
				proxy.update(employeeSelected);
				listemployees.clear();
				listemployees = proxy2.listEmployees(UserConnected.getUserConnected().getDepartment());
			    data=FXCollections.observableArrayList(listemployees);
			    listEmployees.setItems(data);
				
			});
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
