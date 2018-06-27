package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class ControllerPmNewProject implements Initializable {

	
	
	public List<Employee> listemployees;
    public ObservableList<Employee> data;
    public List<Employee> listemplo;
    public ObservableList<Employee> data1;
    static public Project projett;
    public boolean testVacation;
    public Employee empo;
    public List<Project> listprojects3;
    int nbAffect=0;
    String ab;
    
	 	@FXML
	    private JFXButton planning;

	 	@FXML
	    private Label message;

	    @FXML
	    private JFXButton project;

	    @FXML
	    private JFXButton newProject;

	    @FXML
	    private JFXTextField name;

	    @FXML
	    private JFXTextField nbEmployees;

	    @FXML
	    private JFXTextField duration;

	    @FXML
	    private JFXDatePicker startDate;

	    @FXML
	    private JFXTextArea description;


	    @FXML
	    private JFXButton affectLien;

	    @FXML
	    private JFXButton create;
	    
	    @FXML
	    private Label selectedId;

	    @FXML
	    private Label access;
	   
	    
	   
	    @FXML
	    void CreateProject(ActionEvent event) {
			String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
			String jndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
			
			Context context;
			Project project=new Project();
			
			try {
				context= new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				DepartmentServiceRemote proxy2 =(DepartmentServiceRemote) context.lookup(jndiName2);

			
	    		Department depa=proxy2.find(UserConnected.getUserConnected().getDepartment().getId());
	    		String ccc=nbEmployees.getText();
	    		
	    		if (((name.getText()).length()) == 0){ 
	                Alert alert1 = new Alert(Alert.AlertType.ERROR);
	              alert1.setTitle("Error Dialog");
	              alert1.setHeaderText(null);
	              alert1.setContentText("You must enter a name for the project!");
	              alert1.show();}
	    		else if (((description.getText()).length()) == 0){ 
		             Alert alert1 = new Alert(Alert.AlertType.ERROR);
		          alert1.setTitle("Error Dialog");
		          alert1.setHeaderText(null);
		          alert1.setContentText("You must enter a description for the project !");
		          alert1.show();}
	    		else if (((duration.getText()).length()) == 0){ 
		             Alert alert1 = new Alert(Alert.AlertType.ERROR);
		          alert1.setTitle("Error Dialog");
		          alert1.setHeaderText(null);
		          alert1.setContentText("You must enter a duration for the project !");
		          alert1.show();}
	    		else if ((((nbEmployees.getText())).length()) == 0){ 
		             Alert alert1 = new Alert(Alert.AlertType.ERROR);
		          alert1.setTitle("Error Dialog");
		          alert1.setHeaderText(null);
		          alert1.setContentText("You must enter a number of employees works for the project!");
		          alert1.show();}
	    	/*	else if (((project.getStartDate()).toString().length()) == 0){ 
		             Alert alert1 = new Alert(Alert.AlertType.ERROR);
		          alert1.setTitle("Error Dialog");
		          alert1.setHeaderText(null);
		          alert1.setContentText("You must enter the start date of the project !");
		          alert1.show();}*/
	    		else if ((Integer.parseInt(ccc))>(depa.getEmployeesNb())){ 
		             Alert alert1 = new Alert(Alert.AlertType.ERROR);
		          alert1.setTitle("Error Dialog");
		          alert1.setHeaderText(null);
		          ab=Integer.toString(depa.getEmployeesNb());
		          alert1.setContentText("You must choose a correct number of employees less than ".concat(ab));
		          alert1.show();}
	    		else {
	    			project.setName(name.getText());
					project.setNbOfEmployee(Integer.parseInt(nbEmployees.getText()));
					project.setDescription(description.getText());
					project.setDuration(Integer.parseInt(duration.getText()));
					LocalDate localDate=startDate.getValue();
		    		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		    		project.setStartDate(date);
		    		LocalDate localDate2=startDate.getValue();
		    		Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		    		int dur=Integer.parseInt(duration.getText());
		    		Date myDate1 = date2;
		    		Date myDate2=date2;
		    		myDate1.setTime((myDate2.getTime() )+ ((dur * 24 * 3600 * 1000)+32400000));
		    		project.setEndDate(myDate1);
		    		project.setAdvenced("not started");
		    		project.setState("not started");
		    		project.setDepartment(UserConnected.getUserConnected().getDepartment());
	    			proxy.save(project);
	    			projett=proxy.searchProject(name.getText());
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("PmAffectation.fxml"));
	    	        try {
	    				 Parent root=(Parent)loader.load();
	    				 planning.getScene().setRoot(root);
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		}
	    		
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	    void affectLien(ActionEvent event) {
	    	/*FXMLLoader loader = new FXMLLoader(getClass().getResource("PmAffectation.fxml"));
	        try {
				 Parent root=(Parent)loader.load();
				 planning.getScene().setRoot(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	    }

	    
	    @FXML
	    void AffecterEmployees(ActionEvent event) {
		

		
	    }

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
	    void CreateNewProject(ActionEvent event) {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmNewProject.fxml"));
	        try {
				 Parent root=(Parent)loader.load();
				 planning.getScene().setRoot(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
	
	}

}
