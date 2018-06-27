package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class ControllerPmUpdateProject implements Initializable {
	
	public ObservableList<String> ls1=FXCollections.observableArrayList("Very good","Good" ,"Bad");
	public Project Pro= ControllerPmListProjects.projectUpdate;
	public List<Project> listprojects3;
	String ab;
	public static int a;
	@FXML
	private JFXButton planning;

	@FXML
	private JFXButton employees;

	@FXML
	private JFXButton project;

	@FXML
	private JFXButton newProject;

	    
	@FXML
	private JFXTextField name;

	@FXML
    private JFXTextField duration;

	@FXML
	private JFXTextField nbEmployees;

	@FXML
	private JFXTextArea description;

	@FXML
	private JFXDatePicker startDays;

	@FXML
    private JFXComboBox<String> advanced;


    @FXML
    private JFXButton update;
    
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


    @FXML
	void updateProject(ActionEvent event) {
    	String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		Context context;
		try {
			context=new InitialContext();
			ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
			Department department=UserConnected.getUserConnected().getDepartment();
			int bbb=Integer.parseInt(nbEmployees.getText());
			if ((bbb)>(department.getEmployeesNb())){ 
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
             alert1.setTitle("Error Dialog");
             alert1.setHeaderText(null);
             ab=Integer.toString(department.getEmployeesNb());
             alert1.setContentText("You must choose a correct number of employees less than ".concat(ab));
             alert1.show();}
			else if (((name.getText()).length()) == 0){ 
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
    		else {
    			Pro.setName(name.getText());
        		Pro.setDescription(description.getText());
        		Pro.setDuration(Integer.parseInt(duration.getText()));
        		Pro.setNbOfEmployee(Integer.parseInt(nbEmployees.getText()));
        		LocalDate localDate=startDays.getValue();
        		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        		Pro.setStartDate(date);
        		Pro.setAdvenced(advanced.getValue());
    			 proxy.update(Pro);
    			 Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
	   	          alert3.setTitle("Info Dialog");
	   	          alert3.setHeaderText(null);
	   	          alert3.setContentText("Project update with success!");
	   	          alert3.show();
    			if(a<Pro.getNbOfEmployee()) {
    		
    			 Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("INFO Dialog");
                 alert1.setHeaderText(null);
                 int b=(Pro.getNbOfEmployee())-a;
                 String bb=Integer.toString(b);
                 alert1.setContentText("You must affect ".concat(bb).concat(" other employees to this project"));
                 alert1.show();
    			}
    		}
    		
    		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    		
	 }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		access.setVisible(false);
		respo.setVisible(false);
		advanced.setItems(ls1);
		SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
		String datee=format.format(Pro.getStartDate());
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 LocalDate myDayLocalDate = LocalDate.parse(datee, formatter);
		
		name.setText(Pro.getName());
		duration.setText(Integer.toString(Pro.getDuration()));
		nbEmployees.setText(Integer.toString(Pro.getNbOfEmployee()));
		description.setText(Pro.getDescription());
		String test=Pro.getAdvenced();
		System.out.println(test);
		advanced.setValue(test);
		startDays.setValue(myDayLocalDate);
		a=Pro.getNbOfEmployee();
	}

}
