package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import model.Game;
import util.SoundPlayer;

public class Main extends Application{
	private Game game;
	private PrincipalWindowController principal;
	private double xOffset = 0;
	private double yOffset = 0;
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrincipalWindow.fxml"));
			Parent root = fxmlLoader.load();
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
					primaryStage.setX(event.getScreenX() - xOffset);
					primaryStage.setY(event.getScreenY() - yOffset);
				}
			});
			setPrincipal(fxmlLoader.getController());
			Scene scene= new Scene(root);
			scene.setCursor(Cursor.cursor("https://icons.iconarchive.com/icons/imil/role-playing/32/Woman-3-icon.png"));
			scene.getStylesheets().add(getClass().getResource("/resources/fontstyle.css").toExternalForm());
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			SoundPlayer.play("/sounds/intro.wav");
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("video-game.png")));
			primaryStage.setTitle("Collector of heroes");
			primaryStage.setResizable(false);
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public PrincipalWindowController getPrincipal() {
		return principal;
	}

	public void setPrincipal(PrincipalWindowController principal) {
		this.principal = principal;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
