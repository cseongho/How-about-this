package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login_Controller implements Initializable {
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private VBox vb;
	
	@FXML
	private BorderPane titleBP;
	
	@FXML
	private Label titleText;
	
	@FXML
	private BorderPane idBP;
	
	@FXML
	private HBox idBox;
	
	@FXML
	private Label idText;
	
	@FXML
	private TextField idField;
	
	@FXML
	private BorderPane pwBP;
	
	@FXML
	private HBox pwBox;
	
	@FXML
	private Label pwText;
	
	@FXML
	private TextField pwField;
	
	@FXML
	private BorderPane warningBP;
	
	@FXML
	private Label warningText;
	
	@FXML
	private BorderPane loginBP;
	
	@FXML
	private Button loginBtn;
	
	@FXML
	private BorderPane signUpBP;
	
	@FXML
	private Button signUpBtn;
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

    }
    
    public void testClick(ActionEvent actionEvent) {
        if (actionEvent.getSource() == loginBtn) {
        	if(idField.getText().equals("test") && pwField.getText().equals("test")) {
        		try{
            	    FXMLLoader loader = new FXMLLoader(getClass().getResource("./SideBar.fxml"));
            	    Parent root = (Parent) loader.load();
            	    Stage stage = new Stage();
            	    stage.setTitle("Home");
            	    stage.setScene(new Scene(root));
            	    stage.show();
            	    // get a handle to the stage
            	    Stage stageNow = (Stage) loginBtn.getScene().getWindow();
            	    // do what you have to do
            	    stageNow.close();
            	  }catch(Exception e) {
            	  
            	  }
        	}
        	else {
        		warningText.setVisible(true);
        	}
        }
        if (actionEvent.getSource() == signUpBtn) {
        	try{
        	    FXMLLoader loader = new FXMLLoader(getClass().getResource("./SignUp.fxml"));
        	    Parent root = (Parent) loader.load();
        	    Stage stage = new Stage();
        	    stage.setTitle("Sign Up page");
        	    stage.setScene(new Scene(root));
        	    stage.show();
        	  }catch(Exception e) {
        	  
        	  }
        }
        if (actionEvent.getSource() == idField) {
        	System.out.println("input your id");
        }
        if (actionEvent.getSource() == pwField) {
        	System.out.println("input password!");
        }
        if (actionEvent.getSource() == warningText) {
        	System.out.println("warning");
        }
    }
}