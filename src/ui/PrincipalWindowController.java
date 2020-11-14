package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;

public class PrincipalWindowController {
	double x=0,y=0;
    @FXML
    private Label gameName;

    @FXML
    void startGame(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("selectPlayer.fxml"));
		Pane root= fxmlLoader.load();
		Scene scene= new Scene(root);
		Stage stage= new Stage();
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.jpg")));
		stage.setTitle("Heroes");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
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

