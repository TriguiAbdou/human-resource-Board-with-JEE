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
import javafx.scene.control.RadioButton;
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

public class ControllerPmManageAbsent implements Initializable {
	public List<Employee> listEmployees;
	public ObservableList<Employee> data;
	static Project projectSelected = new Project();
	static Employee employeeSelected =new Employee();
	public List<Project> listprojects3;
	public Project projetToUpdate=ControllerPMHome.projectSelected;
	 @FXML
	    private JFXButton planning;

	    @FXML
	    private JFXButton employees;

	    @FXML
	    private JFXButton project;

	    @FXML
	    private JFXButton newProject;

	    @FXML
	    private RadioButton prolonger;

	    @FXML
	    private RadioButton affecter;

	    @FXML
	    private JFXButton validate;
	    
	    @FXML
	    private JFXTextField durationFT;

	    @FXML
	    private Label labduration;

	    @FXML
	    private JFXButton updatebtn;

	    @FXML
	    private TableView<Employee> TableEmployees;

	    @FXML
	    private JFXButton affect;

	    @FXML
	    private TableColumn<Employee, String> matricule1;

	    @FXML
	    private TableColumn<Employee, String> Firstname1;

	    @FXML
	    private TableColumn<Employee, String> Lastname1;

	    @FXML
	    private TableColumn<Employee, String> post1;
	    
	    @FXML
	    private Label attention;
	    
	    @FXML
	    private Label affectLab;
	   
	    @FXML
	    private Label access;
	    
	    @FXML
	    private Label chooce;
	    
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

	    
	    @FXML
	    void ValidateChoice(ActionEvent event) {
	    	if ((prolonger.isSelected())&&((affecter.isSelected()==false))) {
				durationFT.setVisible(true);
				labduration.setVisible(true);
				updatebtn.setVisible(true);
				TableEmployees.setVisible(false);
				affect.setVisible(false);
				chooce.setVisible(false);
			}
			else if((affecter.isSelected())&&((prolonger.isSelected())==false)) {
				TableEmployees.setVisible(true);
				affect.setVisible(true);
				durationFT.setVisible(false);
				labduration.setVisible(false);
				updatebtn.setVisible(false);
				chooce.setVisible(true);
			}
			
			else {
				attention.setVisible(true);
				attention.setText("vous ne pouvez pas choisir les deux");
				durationFT.setVisible(false);
				labduration.setVisible(false);
				updatebtn.setVisible(false);
				TableEmployees.setVisible(false);
				affect.setVisible(false);
				chooce.setVisible(false);
			}
	    }
	    
	    @FXML
	    void affecterEmployees(ActionEvent event) {
			
			


	    	
	    }

	    @FXML
	    void updateDuration(ActionEvent event) {
	    	String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";

			Context context;
			
			try {
				context= new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				int dur=Integer.parseInt(durationFT.getText());
		    	ControllerPMHome.projectSelected.setDuration(dur);
		    	proxy.update(ControllerPMHome.projectSelected);
		    	Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			    alert1.setTitle("Info Dialog");
			    alert1.setHeaderText(null);
			    alert1.setContentText("duration updating with success!");
			    alert1.show();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }

	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		access.setVisible(false);
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
		affectLab.setVisible(false);
		chooce.setVisible(false);
		Context context;
		try {
			context = new InitialContext();
			DepartmentServiceRemote proxy =(DepartmentServiceRemote) context.lookup(jndiName);
			
			durationFT.setVisible(false);
			labduration.setVisible(false);
			updatebtn.setVisible(false);
			TableEmployees.setVisible(false);
			affect.setVisible(false);
			attention.setVisible(false);
			durationFT.setText(Integer.toString(ControllerPMHome.projectSelected.getDuration()));
			matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
			Firstname1.setCellValueFactory(new PropertyValueFactory<>("name"));
			Lastname1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			post1.setCellValueFactory(new PropertyValueFactory<>("post"));
			
			listEmployees=proxy.listEmployees(UserConnected.getUserConnected().getDepartment());
			 Iterator<Employee> iterator = listEmployees.iterator();
			    while ( iterator.hasNext() ) {
			        Employee o = iterator.next();
			        if (o.getPost().equals("Responsable")) {
			            // On supprime l'élément courant de la liste
			            iterator.remove();
			        }
			    }
			data=FXCollections.observableArrayList(listEmployees);
			TableEmployees.setItems(data);
			
			
			affect.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/PlanningService!tn.esprit.b3.esprit1718b3hrboard.services.PlanningServiceRemote";
					String jndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";

					 employeeSelected= data.get( TableEmployees.getSelectionModel().getSelectedIndex());
					 Context context;
					 try {
							context = new InitialContext();
							PlanningServiceRemote proxy =(PlanningServiceRemote) context.lookup(JndiName);
							ProjectServiceRemote proxy2= (ProjectServiceRemote) context.lookup(jndiName2);

							proxy.affectationProjEmp(employeeSelected,ControllerPMHome.projectSelected);
							projetToUpdate.setNbOfEmployee((projetToUpdate.getNbOfEmployee())+1);
							proxy2.update(projetToUpdate);
							
							proxy.createPlanning(employeeSelected, ControllerPMHome.projectSelected);
							affectLab.setText(employeeSelected.getName().concat(" is affect with succes!"));
							affectLab.setVisible(true);
					 } catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			});
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
