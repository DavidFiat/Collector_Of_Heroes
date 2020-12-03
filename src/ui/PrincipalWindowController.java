package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import customExceptions.AlreadyHaveCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import javafx.scene.Node;
import javafx.scene.Scene;

public class PrincipalWindowController {
	private double xOffset = 0;
	private double yOffset = 0;
	private Game game;

	@FXML
	private Label gameName;

	@FXML
	public void initialize(){
		System.out.println("Hola");
		game = new Game();
		//saveData();
		loadData();
	}

	@FXML
	void startGame(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("selectPlayer.fxml"));
		Pane root = fxmlLoader.load();
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
		stage.setTitle("Heroes");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
    }

	@FXML
	void min(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true);
	}

	@FXML
	void close(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}

	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/data.fiat_fernandez_pelaez"));
		oos.writeObject(game);
		oos.close();
	}

	private void loadData(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/data.fiat_fernandez_pelaez"));
		game = (Game) ois.readObject();
		if (game == null) {
			game = new Game();
		}
		ois.close();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
