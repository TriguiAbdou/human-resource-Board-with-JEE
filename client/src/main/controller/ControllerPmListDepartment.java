package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote;

public class ControllerPmListDepartment implements Initializable {
	public List<Department> listdepartment;
	public ObservableList<Department> data;
	static Department departmentUpdate =new Department();
	@FXML
    private JFXButton department;

    @FXML
    private JFXButton employees;

    @FXML
    private JFXButton NewDepartment;
    
    @FXML
    private TableView<Department> DepartmentTable;

    @FXML
    private TableColumn<Department, String> name;

    @FXML
    private TableColumn<Department,String> description;

    @FXML
    private TableColumn<Department, String> relationType;

    @FXML
    private TableColumn<Department, Integer> employeesNb;

    @FXML
    private TableColumn<Department, String> local;
    
    @FXML
    void CreateNewDepartment(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmNewDepartment.fxml"));
        try {
			 Parent root=(Parent)loader.load();
		     employees.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ListEmployees(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListDepEmployees.fxml"));
        try {
			 Parent root=(Parent)loader.load();
		     employees.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ListOfDepartment(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListDep.fxml"));
        try {
			 Parent root=(Parent)loader.load();
		     employees.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

   
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			DepartmentServiceRemote proxy =(DepartmentServiceRemote) context.lookup(jndiName);

			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			description.setCellValueFactory(new PropertyValueFactory<>("description"));
			relationType.setCellValueFactory(new PropertyValueFactory<>("relation_type"));
			employeesNb.setCellValueFactory(new PropertyValueFactory<>("employeesNb"));
			local.setCellValueFactory(new PropertyValueFactory<>("NumAdmin"));
		
			listdepartment=proxy.findAll();
			data=FXCollections.observableArrayList(listdepartment);
			DepartmentTable.setItems(data);
		
	
			DepartmentTable.setRowFactory(new Callback<TableView<Department>, TableRow<Department>>() {
				
				@Override
				public TableRow<Department> call(TableView<Department> param) {
					// TODO Auto-generated method stub
					final TableRow<Department> row = new TableRow<>();

	                 final ContextMenu contextMenu = new ContextMenu();
	                 final MenuItem removeMenuItem = new MenuItem("Delete");
	                 final MenuItem editMenuItem = new MenuItem("Edit");
	                 
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
	                        	  listdepartment=proxy.findAll();
	              				data=FXCollections.observableArrayList(listdepartment);
	              				DepartmentTable.setItems(data);
	                          }
						}
					});
	                 
	                 editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							departmentUpdate=row.getItem();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("PmUpdateDepartment.fxml"));
					        try {
								 Parent root=(Parent)loader.load();
								 employees.getScene().setRoot(root);
							
					        
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
	                 contextMenu.getItems().add(removeMenuItem);
	                 contextMenu.getItems().add(editMenuItem);
	                
	                 return row;
				}
			});
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
