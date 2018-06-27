package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote;

public class ControllerPmNewDepartment implements Initializable {
	public ObservableList<String> ls1=FXCollections.observableArrayList("External","Internal" ,"External and internal");

	
	@FXML
    private JFXButton department;

    @FXML
    private JFXButton employees;

    @FXML
    private JFXButton NewDepartment;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField EmployeesNb;

    @FXML
    private JFXTextField local;

    @FXML
    private JFXTextArea description;

    @FXML
    private JFXComboBox<String> relationtype;

    @FXML
    private JFXButton add;

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

    @FXML
    void ajouterDepartment(ActionEvent event) {
    	Department department=new Department();
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/DepartmentService!tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			DepartmentServiceRemote proxy =(DepartmentServiceRemote) context.lookup(jndiName);
		
			if (((name.getText()).length()) == 0){ 
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
              alert1.setTitle("Error Dialog");
              alert1.setHeaderText(null);
              alert1.setContentText("You must enter a name for this department!");
              alert1.show();}
			else if (((description.getText()).length()) == 0){ 
	             Alert alert1 = new Alert(Alert.AlertType.ERROR);
	          alert1.setTitle("Error Dialog");
	          alert1.setHeaderText(null);
	          alert1.setContentText("You must enter a description for this department !");
	          alert1.show();}
			else if (((local.getText()).length()) == 0){ 
	             Alert alert1 = new Alert(Alert.AlertType.ERROR);
	          alert1.setTitle("Error Dialog");
	          alert1.setHeaderText(null);
	          alert1.setContentText("You must enter a local of this department !");
	          alert1.show();}
			else if (((EmployeesNb.getText()).length()) == 0){ 
	             Alert alert1 = new Alert(Alert.AlertType.ERROR);
	          alert1.setTitle("Error Dialog");
	          alert1.setHeaderText(null);
	          alert1.setContentText("You must enter a number of employees working in this department !");
	          alert1.show();}
			else {
				department.setName(name.getText());
				department.setDescription(description.getText());
				department.setEmployeesNb(Integer.parseInt(EmployeesNb.getText()));
				department.setNumAdmin(local.getText());
				department.setRelation_type(relationtype.getValue());
				proxy.save(department);
				Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
	            alert1.setTitle("Info Dialog");
	            alert1.setHeaderText(null);
	            alert1.setContentText("Department creating with success!");
	            alert1.show();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		relationtype.setItems(ls1);
	}

}
