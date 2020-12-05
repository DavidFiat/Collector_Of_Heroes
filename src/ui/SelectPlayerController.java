package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SelectPlayerController{
	private double xOffset = 0;
	private double yOffset = 0;
	
	@FXML
    private Pane pane;

    @FXML
    private HBox tab;

    @FXML
    private Label player;

    @FXML
    private Label text;
    private PrincipalWindowController principal;
	private GameController gameController;
    
    @FXML
    public void initialize() {
    	
    }
    
    @FXML
    void proceed(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Pane root = fxmlLoader.load();
		gameController = fxmlLoader.getController();
		gameController.setPrincipalWindow(principal);
		gameController.displayCharacterImage();
		gameController.displayEnemyImage();
		Stage stage = new Stage();
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
			}
		});
		Scene scene = new Scene(root);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("video-game.png")));
		stage.setTitle("Collector of heroes");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		Stage stage2 = (Stage) text.getScene().getWindow();
		stage2.close();
    }
    
	@FXML
    void close(MouseEvent event) {
    	Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }

	public void setPrincipal(PrincipalWindowController principalWindowController) {
		principal = principalWindowController;
	}
}
