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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote;

public class ControllerListDepEmployees implements Initializable {
	public List<Employee> listemployees;
	public ObservableList<Employee> data;

	  @FXML
	    private JFXButton department;

	    @FXML
	    private JFXButton employees;

	    @FXML
	    private JFXButton NewDepartment;

	    @FXML
	    private TableView<Employee> DepEmployees;

	    @FXML
	    private TableColumn<Employee, String> matricule;

	    @FXML
	    private TableColumn<Employee, String> firstName;

	    @FXML
	    private TableColumn<Employee, String> lastName;

	    @FXML
	    private TableColumn<Employee, String> email;

	    @FXML
	    private TableColumn<Employee, String> cin;

	    @FXML
	    private TableColumn<Employee, String> address;

	    @FXML
	    private TableColumn<Employee, String> post;

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
		String JndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/EmployeeService!tn.esprit.b3.esprit1718b3hrboard.services.EmployeeServiceRemote";
		Context context;
		try {
			context=new InitialContext();
			EmployeeServiceRemote proxy=(EmployeeServiceRemote) context.lookup(JndiName);

			firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
			lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			email.setCellValueFactory(new PropertyValueFactory<>("email"));
			cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
			address.setCellValueFactory(new PropertyValueFactory<>("adresse"));
			post.setCellValueFactory(new PropertyValueFactory<>("post"));
			matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
			
			listemployees=proxy.findAll();
			data=FXCollections.observableArrayList(listemployees);
			DepEmployees.setItems(data);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
