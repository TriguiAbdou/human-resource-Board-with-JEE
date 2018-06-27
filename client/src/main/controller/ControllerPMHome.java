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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Planning;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.UserServiceRemote;

public class ControllerPMHome implements Initializable {
	
	public List<Employee> listEmployees;
	public List<Employee> listEmployeesProject;
	public ObservableList<Employee> data;
	public List<Project> listprojects;
	public List<Project> listprojectsAbsent;
	public ObservableList<Project> data1;
	static Project projectSelected = new Project();
	public ObservableList piechartData = FXCollections.observableArrayList();
	@FXML
    private JFXButton planning;

    @FXML
    private JFXButton employees;

    @FXML
    private JFXButton project;

    @FXML
    private JFXButton newProject;
    
    @FXML
    private Label department;

    @FXML
    private Label post;

    @FXML
    private Label score;
    
    @FXML
    private TableColumn<Employee,String> postAbsent;

    @FXML
    private TableColumn<Employee,Integer> scoreAbsent;

    @FXML
    private JFXButton check;

    @FXML
    private TableView<Employee> absenceTab;

    @FXML
    private TableColumn<Employee,String> nameAbsent;

    @FXML
    private TableColumn<Employee,String> lastNameAbsent;

    @FXML
    private Button gerer;
    
    @FXML
    private TableView<Project> ProjectAbsenceTab;
    
    @FXML
    private TableColumn<Project, String> name;

    @FXML
    private TableColumn<Project, String> description;

    @FXML
    private TableColumn<Project, Integer> number;

    @FXML
    private TableColumn<Project, String> state;

    @FXML
    private Button validate;
    
    @FXML
    private Label access;

    @FXML
    private PieChart test;

    @FXML
    private Label respo;
    
    @FXML
    private Label labchar;

    @FXML
    private Label scorelab;
    
    
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
		     score.getScene().setRoot(root);
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
		     score.getScene().setRoot(root);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void checkEmployeeAbsent(ActionEvent event) {
    	
    	
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
    	String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

		Context context;
		
		
			try {
				context= new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

				
				int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
				Employee employeeConnected = proxy2.find(codeEmployeeConnected);
		    	
				if((employeeConnected.getPost()).equals("Responsable")) {
					ProjectAbsenceTab.setVisible(true);
					 validate.setVisible(true);
				name.setCellValueFactory(new PropertyValueFactory<>("name"));
				description.setCellValueFactory(new PropertyValueFactory<>("description"));
				number.setCellValueFactory(new PropertyValueFactory<>("nbOfEmployee"));
				state.setCellValueFactory(new PropertyValueFactory<>("state"));
				 listprojectsAbsent = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
				 data1=FXCollections.observableArrayList(listprojectsAbsent);
				 ProjectAbsenceTab.setItems(data1);
				 ProjectAbsenceTab.setOnMouseClicked((Event) ->{
				
					 projectSelected= data1.get( ProjectAbsenceTab.getSelectionModel().getSelectedIndex());
				 });
				 
				}else {
		    		respo.setVisible(true);
		    		
		    	}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
    }
    
    @FXML
    void ValiderProject(ActionEvent event) {
    	absenceTab.setVisible(true);
    	gerer.setVisible(true);
    	String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";

		Context context;
		
		
			try {
				context= new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				nameAbsent.setCellValueFactory(new PropertyValueFactory<>("name"));
				lastNameAbsent.setCellValueFactory(new PropertyValueFactory<>("lastName"));
				postAbsent.setCellValueFactory(new PropertyValueFactory<>("post"));
				scoreAbsent.setCellValueFactory(new PropertyValueFactory<>("score"));
				
				
				
				listEmployees =proxy.employeeProjectAbsent(projectSelected);
				data=FXCollections.observableArrayList(listEmployees);
				absenceTab.setItems(data);
			
				
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
		     score.getScene().setRoot(root);
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
		     score.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
    @FXML
    void manageAbsent(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmManageAbsent.fxml"));
        try {
			 Parent root=(Parent)loader.load();
		     score.getScene().setRoot(root);
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
		String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";

		Context context;
		try {
			context=new InitialContext();
			
			EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);
			ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);

			String yourDepartment =UserConnected.getUserConnected().getDepartment().getName();
			department.setText(yourDepartment);
			
			int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
			Employee employeeConnected = proxy2.find(codeEmployeeConnected);
			
			String yourPost = employeeConnected.getPost();
			post.setText(yourPost);
			
			if(yourPost.equals("Responsable")) {
			score.setVisible(false);
			scorelab.setVisible(false);
			}
			else {
			String yourScore=Integer.toString(employeeConnected.getScore());
			score.setText(yourScore);
			}
			
			
			
			absenceTab.setVisible(false);
			gerer.setVisible(false);
			 ProjectAbsenceTab.setVisible(false);
			 validate.setVisible(false);
			 test.setVisible(false);
			 labchar.setVisible(false);
			 if (((UserConnected.getUserConnected().getProject()) != null)&&((employeeConnected.getScore()) != 0)) {
				 test.setVisible(true);	
				 labchar.setVisible(true);
				 listEmployeesProject=proxy.listEmployeesOfProject(UserConnected.getUserConnected().getProject());
				 for (Employee ls:listEmployeesProject) {
					 piechartData.addAll(
				    			new PieChart.Data(ls.getName(),ls.getScore())
				    			);
				 }
				 test.setData(piechartData);
			 }
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
