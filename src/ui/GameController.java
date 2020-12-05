package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameController{
    @FXML
    private ImageView card1;
    
    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;

    @FXML
    private ImageView card9;

    @FXML
    private ImageView card10;

    @FXML
    private ImageView card6;

    @FXML
    private ImageView card7;

    @FXML
    private ImageView card8;
    
    @FXML
    private ImageView character;
    
    @FXML
    private ImageView enemy;
    
    /** BIG IMAGES*/
    public Image image1 = new Image(getClass().getResource("/resources/cards/DOCTOR-STRANGE.jpg").toExternalForm());
    public Image image2 = new Image(getClass().getResource("/resources/cards/SPIDERMAN.jpg").toExternalForm());
    public Image image3 = new Image(getClass().getResource("/resources/cards/Black-Widow.jpg").toExternalForm());
    public Image image4 = new Image(getClass().getResource("/resources/cards/Flash.jpg").toExternalForm());
    public Image image5 = new Image(getClass().getResource("/resources/cards/THOR.jpg").toExternalForm());
    public Image image6 = new Image(getClass().getResource("/resources/cards/THANOS.jpg").toExternalForm());
    public Image image7 = new Image(getClass().getResource("/resources/cards/Scarlet-Witch.jpg").toExternalForm());
    public Image image8 = new Image(getClass().getResource("/resources/cards/CAPTAIN-AMERICA.jpg").toExternalForm());
    public Image image9 = new Image(getClass().getResource("/resources/cards/IRONMAN.jpg").toExternalForm());
    public Image image10 = new Image(getClass().getResource("/resources/cards/HULK.jpg").toExternalForm());
    
    /**SMALL IMAGES*/
    public Image cardI1 = new Image(getClass().getResource("/resources/cards/blackwidow.jpg").toExternalForm());
    public Image cardI2 = new Image(getClass().getResource("/resources/cards/captainAmerica.jpg").toExternalForm());
    public Image cardI3 = new Image(getClass().getResource("/resources/cards/doctorStrange.jpg").toExternalForm());
    public Image cardI4 = new Image(getClass().getResource("/resources/cards/spidermanS.jpg").toExternalForm());
    public Image cardI5 = new Image(getClass().getResource("/resources/cards/THOR-6.jpg").toExternalForm());
    public Image cardI6 = new Image(getClass().getResource("/resources/cards/flash2.jpg").toExternalForm());
    public Image cardI7 = new Image(getClass().getResource("/resources/cards/scarlet.jpg").toExternalForm());
    public Image cardI8 = new Image(getClass().getResource("/resources/cards/thanos2.jpg").toExternalForm());
    public Image cardI9 = new Image(getClass().getResource("/resources/cards/hulk2.jpg").toExternalForm());
    public Image cardI10 = new Image(getClass().getResource("/resources/cards/ironman2.jpg").toExternalForm());
    
    @FXML
    public void initialize() {
    	card1.setClip(new Circle(70,70,70));
    	card2.setClip(new Circle(70,70,70));
    	card3.setClip(new Circle(70,70,70));
    	card4.setClip(new Circle(70,70,70));
    	card5.setClip(new Circle(70,70,70));
    	card6.setClip(new Circle(70,70,70));
    	card7.setClip(new Circle(70,70,70));
    	card8.setClip(new Circle(70,70,70));
    	card9.setClip(new Circle(70,70,70));
    	card10.setClip(new Circle(70,70,70));
    	displayCharacterImage();
    }
    
    @FXML
    void close(MouseEvent event) {
    	Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    public void defeatCharacter() {
    	
    }
    
    public void displayCharacterImage() {
    	card1.setOnMouseClicked(e -> {
    		character.setImage(image1);
        });
    	card2.setOnMouseClicked(e -> {
    		character.setImage(image2);
        });
    }
    
    public void displayEnemyImage() {
    	
    }
    
    @FXML
    void fight(ActionEvent event) {

    }
}
