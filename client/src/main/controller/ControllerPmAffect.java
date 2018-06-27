package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class ControllerPmAffect implements Initializable {

	public List<Employee> listemployees;
    public ObservableList<Employee> data;
    public boolean testVacation;
    public Employee empo;
    int nbAffect=0;
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
    private Label selectedId;

    @FXML
    private Label access;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> matricule1;

    @FXML
    private TableColumn<Employee, String> Firstname1;

    @FXML
    private TableColumn<Employee, String> Lastname1;

    @FXML
    private TableColumn<Employee, String> post1;

    @FXML
    private JFXButton affectbtn;
    
    @FXML
    private Label reste;
    
    @FXML
    private Label message;

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
		reste.setVisible(false);
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
		String jndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		String JndiName4="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/PlanningService!tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote";
		String JndiName3="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		try {
			context = new InitialContext();
			DepartmentServiceRemote proxy =(DepartmentServiceRemote) context.lookup(jndiName);
			ProjectServiceRemote proxy2= (ProjectServiceRemote) context.lookup(jndiName2);
			PlanningServiceRemote proxy4 =(PlanningServiceRemote) context.lookup(JndiName4);
			EmployeeServiceRemote proxy3=(EmployeeServiceRemote) context.lookup(JndiName3);

			
		    listemployees=proxy.listEmployees(UserConnected.getUserConnected().getDepartment());
		    Iterator<Employee> iterator = listemployees.iterator();
		    while ( iterator.hasNext() ) {
		        Employee o = iterator.next();
		        if (o.getPost().equals("Responsable")) {
		            // On supprime l'élément courant de la liste
		            iterator.remove();
		        }
		    }
		    
			matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
			Firstname1.setCellValueFactory(new PropertyValueFactory<>("name"));
			Lastname1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			post1.setCellValueFactory(new PropertyValueFactory<>("post"));
			
			data=FXCollections.observableArrayList(listemployees);
			table.setItems(data);
		
			table.setOnMouseClicked((Event) ->{
				selectedId.setText(Integer.toString(data.get(table.getSelectionModel().getSelectedIndex()).getCode()));
				reste.setVisible(false);
			});
			
			
			affectbtn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					 int nb=(ControllerPmNewProject.projett).getNbOfEmployee();
					 int resteInt=0;
		    		empo=proxy3.find(Integer.parseInt(selectedId.getText()));
					System.out.println(empo.getLastName());
		    		testVacation=proxy2.EmployeeAvailable(empo,(ControllerPmNewProject.projett));
					boolean affect=proxy.EmployeeAffectOrNot(empo, empo.getDepartment());
					if(affect==false) {
						if (testVacation==true) {
							
							nbAffect=nbAffect+1;
							resteInt=nb-nbAffect;
							
							if(resteInt<0) {
								message.setText("you have completed the assignment of employees !");
							}
							else {
							proxy4.affectationProjEmp(empo,(ControllerPmNewProject.projett));
							message.setText(empo.getName().concat(" is affect with succes!"));
							proxy4.createPlanning(empo, (ControllerPmNewProject.projett));
							System.out.println(resteInt);
							String a=Integer.toString(resteInt);
							String b=(("you must affect ").concat(a)).concat(" other employees !");
							reste.setText(b);
							reste.setVisible(true);
							}
						}
						else {
							message.setText(empo.getName().concat(" is in vacation during this project!"));
						}
					
					}
					else {
						message .setText(empo.getName().concat(" is affected to another project"));
					}
					
					
				}
			});
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
