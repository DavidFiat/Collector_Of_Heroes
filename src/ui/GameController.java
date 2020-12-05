package ui;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Character;

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
    
    private PrincipalWindowController principal;
    
    private Image image1, image2, image3, image4, image5,
    			image6, image7, image8, image9, image10;

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
    }
    
    @FXML
    void close(MouseEvent event) {
    	Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    public void defeatCharacter() {
    	
    }
    
    public void displayCharacterImage() {
    	List<Character> playerCharacters = principal.getGame().getPlayers().get("DavidFiat24").getCharacters().returnHash();
    	image1 = new Image(getClass().getResource(playerCharacters.get(0).getName()).toExternalForm());
    	image2 = new Image(getClass().getResource(playerCharacters.get(1).getName()).toExternalForm());
    	image3 = new Image(getClass().getResource(playerCharacters.get(2).getName()).toExternalForm());
    	image4 = new Image(getClass().getResource(playerCharacters.get(3).getName()).toExternalForm());
    	image5 = new Image(getClass().getResource(playerCharacters.get(4).getName()).toExternalForm());
    	card1.setImage(image1);
    	card2.setImage(image2);
    	card3.setImage(image3);
    	card4.setImage(image4);
    	card5.setImage(image5);
    	
    	card1.setOnMouseClicked(e -> {
    		character.setImage(image1);
        });
    	card2.setOnMouseClicked(e -> {
    		character.setImage(image2);
        });
    	card3.setOnMouseClicked(e -> {
    		character.setImage(image3);
        });
    	card4.setOnMouseClicked(e -> {
    		character.setImage(image4);
        });
    	card5.setOnMouseClicked(e -> {
    		character.setImage(image5);
        });
    }
    
    public void displayEnemyImage() {
    	List<Character> enemyCharacters = principal.getGame().getPlayers().get("DavidFiat24").getCharacters().returnHash();
    	image1 = new Image(getClass().getResource(playerCharacters.get(0).getName()).toExternalForm());
    	image2 = new Image(getClass().getResource(playerCharacters.get(1).getName()).toExternalForm());
    	image3 = new Image(getClass().getResource(playerCharacters.get(2).getName()).toExternalForm());
    	image4 = new Image(getClass().getResource(playerCharacters.get(3).getName()).toExternalForm());
    	image5 = new Image(getClass().getResource(playerCharacters.get(4).getName()).toExternalForm());
    	card1.setImage(image1);
    	card2.setImage(image2);
    	card3.setImage(image3);
    	card4.setImage(image4);
    	card5.setImage(image5);
    }
    
    public void setPrincipalWindow(PrincipalWindowController principal) {
    	this.principal = principal;
    }

    @FXML
    void fight(ActionEvent event) {

    }
}
