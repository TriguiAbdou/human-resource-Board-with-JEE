package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote;

public class ControllerPmListProjects implements Initializable {
	public List<Project> listprojects;
	public List<Project> listprojects1;
    public ObservableList<Project> data;
    static Project projectUpdate = new Project();
    static Project projectConsult = new Project();
    static Project projectProgress = new Project();
    public List<Project> listprojects3;
    public List<Project> listprojects4;
    @FXML
    private TableView<Project> projects;

    @FXML
    private TableColumn<Project, String> name;

    @FXML
    private TableColumn<Project, String> description;

    @FXML
    private TableColumn<Project, Integer> duration;

    @FXML
    private TableColumn<Project,Date> startDate;

    @FXML
    private TableColumn<Project, Integer> number;

    @FXML
    private TableColumn<Project, String> state;

    @FXML
    private TableColumn<Project, String> advenced;
	
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
    private JFXTextField recherche;

    @FXML
    private JFXButton recherchebtn;


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
    void rechercher(ActionEvent event) {
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
		Context context;
		try {
			context=new InitialContext();
			ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
			listprojects4=proxy.searchProject1(recherche.getText());
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			description.setCellValueFactory(new PropertyValueFactory<>("description"));
			duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
			startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
			number.setCellValueFactory(new PropertyValueFactory<>("nbOfEmployee"));
			state.setCellValueFactory(new PropertyValueFactory<>("state"));
			advenced.setCellValueFactory(new PropertyValueFactory<>("advenced"));
			data=FXCollections.observableArrayList(listprojects4);
			projects.setItems(data);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
    	
    }

    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			access.setVisible(false);
    		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/ProjectService!tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceRemote";
    		String JndiName2="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";

    		Context context;
    		
			try {
				context=new InitialContext();
				ProjectServiceRemote proxy= (ProjectServiceRemote) context.lookup(jndiName);
				EmployeeServiceRemote proxy2=(EmployeeServiceRemote) context.lookup(JndiName2);

				
				listprojects = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
				
				name.setCellValueFactory(new PropertyValueFactory<>("name"));
				description.setCellValueFactory(new PropertyValueFactory<>("description"));
				duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
				startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
				number.setCellValueFactory(new PropertyValueFactory<>("nbOfEmployee"));
				state.setCellValueFactory(new PropertyValueFactory<>("state"));
				advenced.setCellValueFactory(new PropertyValueFactory<>("advenced"));
				
				for (Project lst:listprojects) {
					proxy.projectState(lst);
				}
				
				listprojects1 = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
				data=FXCollections.observableArrayList(listprojects1);
				projects.setItems(data);
				
				projects.setRowFactory(new Callback<TableView<Project>, TableRow<Project>>() {
					
					@Override
					public TableRow<Project> call(TableView<Project> param) {
						// TODO Auto-generated method stub
						 final TableRow<Project> row = new TableRow<>();

		                 final ContextMenu contextMenu = new ContextMenu();
		                 final MenuItem removeMenuItem = new MenuItem("Delete");
		                 final MenuItem editMenuItem = new MenuItem("Edit");
		                 final MenuItem projectMenuItem = new MenuItem("Consult list of employees");
		                 final MenuItem progressItem = new MenuItem("Consult progress of this project");
		                 int codeEmployeeConnected =UserConnected.getUserConnected().getCode();
		     			Employee employeeConnected = proxy2.find(codeEmployeeConnected);
		                 
		     			 removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								
								  Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
		                          alerte.setTitle("confirmation");
		                          alerte.setHeaderText("voulez vous vraiment supprimer?");
		                          Optional<ButtonType> result = alerte.showAndWait();
		                          if (result.get() == ButtonType.OK) {
		                        	  proxy.delete(row.getItem());
		              				listprojects1 = proxy.listProjectsOfEmployees(UserConnected.getUserConnected().getDepartment());
		              				data=FXCollections.observableArrayList(listprojects1);
		            				 projects.setItems(data);
		                          }
							}
						});
		                
		                editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								projectUpdate=row.getItem();
								FXMLLoader loader = new FXMLLoader(getClass().getResource("PmUpdateProject.fxml"));
						        try {
									 Parent root=(Parent)loader.load();
									 planning.getScene().setRoot(root);
								
						        
						        } catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
							}
						}); 
		             
		                 
		                projectMenuItem.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								projectConsult=row.getItem();
								FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListEmployeesProject.fxml"));
						        try {
									 Parent root=(Parent)loader.load();
									 planning.getScene().setRoot(root);
									 
						        
						        } catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
		                
		                
		                progressItem.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								projectProgress=row.getItem();
								FXMLLoader loader = new FXMLLoader(getClass().getResource("PmProgressProject.fxml"));
						        try {
									 Parent root=(Parent)loader.load();
									 planning.getScene().setRoot(root);
									 
						        
						        } catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
		                
		                 row.contextMenuProperty().bind(
		                         Bindings.when((row.emptyProperty()))
		                                 .then((ContextMenu) null)
		                                 .otherwise(contextMenu)
		                 );
		                
		                 if((employeeConnected.getPost()).equals("Responsable")) {
		                 contextMenu.getItems().add(removeMenuItem);
			             contextMenu.getItems().add(editMenuItem);
			             contextMenu.getItems().add(progressItem);
		                 }
		                 contextMenu.getItems().add(projectMenuItem);
		                 
		                
		                 return row;
					}
				});
				 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
	}

}
