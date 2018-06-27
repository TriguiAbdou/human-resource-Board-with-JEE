package tn.esprit.b3.esprit1718b3hrboard.app.client.gui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application implements Initializable{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent=FXMLLoader.load(getClass().getResource("Sign_in.fxml"));
		Scene scene=new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	

}
