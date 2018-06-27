package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

import java.util.concurrent.*;


public class ControllerPmPlanning implements Initializable {

	public ObservableList<String> ls1=FXCollections.observableArrayList("Very good","Good" ,"Bad");
	public List<Planning> listplanning;
	public ObservableList<Planning> data;
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
    private Label projectName;

    @FXML
    private Label projectDate;
    
    @FXML
    private TableView<Planning> listPlanning;

    @FXML
    private TableColumn<Planning, String> day;

    @FXML
    private TableColumn<Planning, String> type;

    @FXML
    private TableColumn<Planning, String> name;

    @FXML
    private TableColumn<Planning, String> description;

    @FXML
    private TableColumn<Planning, String> note;

    @FXML
    private TableColumn<Planning, String> state;
    
    @FXML
    private JFXButton done;

    @FXML
    private ComboBox<String> comboState;
    
    @FXML
    private Label selectedId;
    
    @FXML
    private Label respo;

    @FXML
    void ConsulterPlanning(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmPlanning.fxml"));
        try {
			 Parent root=(Parent)loader.load();
			 planning.getScene().setRoot(root);
		} catch (IOException e) {
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
    void affecterState(ActionEvent event) {
    	
		
    }
	public Context context;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/PlanningService!tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote";
		respo.setVisible(false);
		
		try {
			context=new InitialContext();
			EmployeeServiceRemote proxy=(EmployeeServiceRemote) context.lookup(JndiName);
			PlanningServiceRemote proxy2=(PlanningServiceRemote) context.lookup(JndiName2);

			String ProjectName =UserConnected.getUserConnected().getProject().getName();
			projectName.setText(ProjectName);
			Date ProjectDate=UserConnected.getUserConnected().getProject().getStartDate();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String reportDate = df.format(ProjectDate);
			projectDate.setText(reportDate);
		
			
			day.setCellValueFactory(new PropertyValueFactory<>("date"));
			type.setCellValueFactory(new PropertyValueFactory<>("type"));
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			description.setCellValueFactory(new PropertyValueFactory<>("description"));
			note.setCellValueFactory(new PropertyValueFactory<>("note"));
			state.setCellValueFactory(new PropertyValueFactory<>("state"));
			
			
			int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
			Employee employeeConnected = proxy.find(codeEmployeeConnected);
			
			listplanning =proxy2.ProjectState(employeeConnected, employeeConnected.getProject());
			data=FXCollections.observableArrayList(listplanning);
			listPlanning.setItems(data);
			
			comboState.setItems(ls1);
			
			listPlanning.setOnMouseClicked((Event) ->{
				
					comboState.setValue(data.get(listPlanning.getSelectionModel().getSelectedIndex()).getState());
					selectedId.setText(Integer.toString(data.get(listPlanning.getSelectionModel().getSelectedIndex()).getId()));
				
					
			
			});
			
			done.setOnMouseClicked((Event) ->{
					int id=Integer.parseInt(selectedId.getText());
					Planning planningSelected=proxy2.find(id);
					planningSelected.setState(comboState.getValue());
					proxy2.update(planningSelected);
					listplanning.clear();
					listplanning = proxy2.ProjectState(employeeConnected, employeeConnected.getProject());
				    data=FXCollections.observableArrayList(listplanning);
					listPlanning.setItems(data);
				});
			
		
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("zzz");
		}
		
		
	}

}
