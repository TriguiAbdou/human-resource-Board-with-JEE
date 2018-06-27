package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tn.esprit.b3.esprit1718b3hrboard.entities.CheckIn;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.CheckInServiceRemote;

public class ControllerHomeEmployee implements Initializable{

	@FXML
    private Button bb;

    @FXML
    private Button proMan;
	
	@FXML
	public void handleActionButton(ActionEvent event)
	{
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/CheckInService!tn.esprit.b3.esprit1718b3hrboard.services.CheckInServiceRemote";
		
		
		Context context;
		try {
			context = new InitialContext();
			CheckInServiceRemote proxy=(CheckInServiceRemote) context.lookup(jndiName);
			Calendar cal = Calendar.getInstance();
			
			DateFormat day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			//System.out.println(dateFormat.format(cal.getTime()));
			Date myDate;
			try {
				myDate = day.parse( day.format(cal.getTime()) );
				proxy.save(new CheckIn("entree",myDate,System.nanoTime (),UserConnected.getUserConnected()));
				//import date util
				Date startDate;
				System.out.println(UserConnected.getUserConnected().getCode());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//startDate = heure.parse(heure.format(cal.getTime()));
		    //String newDateString = heure.format(startDate); //string
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//button Project management du premier interface after login 
	 @FXML
	    void handleActionButton2(ActionEvent event) {
		 Parent parent = null;
			/*try {
				parent = FXMLLoader.load(getClass().getResource("ProjectManagementHome.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Scene scene=new Scene(parent);
			Stage stage=new Stage();
			stage.setScene(scene);
			
			stage.show();*/

					FXMLLoader loader = new FXMLLoader(getClass().getResource("ProjectManagementHome.fxml"));
	               
					try {
						 Parent root=(Parent)loader.load();
					     bb.getScene().setRoot(root);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	               
	    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//System.out.println(UserConnected.getIdConnected());
		
	}

}
