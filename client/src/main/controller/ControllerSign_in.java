package tn.esprit.b3.esprit1718b3hrboard.app.client.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.UserConnected;
import tn.esprit.b3.esprit1718b3hrboard.services.UserServiceRemote;

public class ControllerSign_in implements Initializable{

	
	@FXML
	private AnchorPane siw;
	@FXML
	private ImageView img;
	@FXML
	private Pane siw2;
	@FXML
	private JFXTextField username;
	@FXML
	private JFXTextField pass;
	
	
	
	public void handleActionButton1(ActionEvent event){
		String jndiName="esprit1718b3hrboard-ear/esprit1718b3hrboard-service/UserService!tn.esprit.b3.esprit1718b3hrboard.services.UserServiceRemote";
		
		try {
			Context context=new InitialContext();
			UserServiceRemote proxy =(UserServiceRemote) context.lookup(jndiName);
			//proxy.createUser(new User("siwar"));
			
			/*Calendar cal = Calendar.getInstance();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
			System.out.println(dateFormat.format(cal.getTime()));
			//////format 2
			 Date tz = cal.getTime();
		      System.out.print(tz);
	*/		UserConnected a=new UserConnected();
			
			//System.out.println(proxy.login("u", "u").getCode());
			System.out.println(username.getText());
			System.out.println(pass.getText());
			//System.out.println(proxy.login(username.getText(), pass.getText()));
			if((proxy.login(username.getText(), pass.getText()))== null)
			{
				System.out.print("ya abdouu erreur");
				
			}
			else
			{
				if(proxy.login(username.getText(), pass.getText()).getRole().equals("employee"))
				{
					System.out.println(proxy.login(username.getText(), pass.getText()).getName());
					//a.setIdConnected(proxy.login(username.getText(), pass.getText()).getCode());
					
					a.setUserConnected(proxy.login(username.getText(), pass.getText()));
					System.out.println(a.getUserConnected().getCode());
					System.out.println(a.getUserConnected().getName());
					
				Parent parent = null;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEmployee.fxml"));
					Parent root=(Parent)loader.load();
				    username.getScene().setRoot(root);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
				else if(proxy.login(username.getText(), pass.getText()).getRole().equals("Rrh"))
				{
					System.out.print("eroooooor");
					System.out.print(proxy.login(username.getText(), pass.getText()).getName());
					//a.setIdConnected(proxy.login(username.getText(), pass.getText()).getCode());
					//System.out.println(a.getIdConnected());
				Parent parent = null;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("PmListDep.fxml"));

					Parent root=(Parent)loader.load();
				    username.getScene().setRoot(root);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			//	System.out.print(proxy.login(username.getText(), pass.getText()).getRole());
			
				
			}
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		


	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Image image1 = new Image(ControllerSign_in.class.getResourceAsStream("future-hr-roles.jpg"));
        
        img.setImage(image1);
		FadeTransition ft = new FadeTransition(Duration.millis(6000), siw2);
	       ft.setFromValue(0.0);
	       ft.setToValue(1.0);
	       ft.setCycleCount(1);
	       ft.setAutoReverse(false);
	       ft.play();
	     //  ft.setOnFinished(event1 -> {

               
	           TranslateTransition translateTransition0 = new TranslateTransition(Duration.seconds(2), siw2);
	           translateTransition0.setByY(+250);
	           translateTransition0.play();
	           
	    //   });
	      // siw2.setVisible(true);	
		
		
	}

}
