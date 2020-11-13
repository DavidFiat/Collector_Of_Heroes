package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PrincipalWindowController {
	double x=0,y=0;
    @FXML
    private Label gameName;

    @FXML
    void startGame(ActionEvent event) {

    }
    

    @FXML
    void min(MouseEvent event) {
    	Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.setIconified(true);
    }	
    
    @FXML
    void close(MouseEvent event) {
    	Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
}

