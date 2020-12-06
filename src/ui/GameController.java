package ui;

import java.util.ArrayList;
import java.util.List;
import graphs.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
    
    @FXML
  	private Label totalEnergy;
  
    private PrincipalWindowController principal;

    private Image image1, image2, image3, image4, image5,
    			image6, image7, image8, image9, image10;
    private Vertex<Character> currentCharacter, currentEnermy;
    
    private List<Vertex<Character>> enemies;
    
    private List<ImageView> playerCharacters, enemyCharacters;
    
    private int counter, victories, defeats;
    
    @FXML
    public void initialize() {
    	counter = 0;
    	victories = 0;
    	defeats = 0;
    	playerCharacters = new ArrayList<ImageView>();
    	enemyCharacters = new ArrayList<ImageView>();
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
    
    public void displayCharacterImage() {
    	List<Vertex<Character>> characters = principal.getGame().getPlayerCharactersVertex(principal.getGame().getPlayers().get("DavidFiat24"));
    	image1 = new Image(getClass().getResource(characters.get(0).getValue().getUrl()).toExternalForm());
    	image2 = new Image(getClass().getResource(characters.get(1).getValue().getUrl()).toExternalForm());
    	image3 = new Image(getClass().getResource(characters.get(2).getValue().getUrl()).toExternalForm());
    	image4 = new Image(getClass().getResource(characters.get(3).getValue().getUrl()).toExternalForm());
    	image5 = new Image(getClass().getResource(characters.get(4).getValue().getUrl()).toExternalForm());
    	card1.setImage(image1);
    	card2.setImage(image2);
    	card3.setImage(image3);
    	card4.setImage(image4);
    	card5.setImage(image5);
    	playerCharacters.add(card1);
    	playerCharacters.add(card2);
    	playerCharacters.add(card3);
    	playerCharacters.add(card4);
    	playerCharacters.add(card5);
    	
    	card1.setOnMouseClicked(e -> {
    		character.setImage(image1);
    		currentCharacter = characters.get(0);
        });
    	card2.setOnMouseClicked(e -> {
    		character.setImage(image2);
    		currentCharacter = characters.get(1);
        });
    	card3.setOnMouseClicked(e -> {
    		character.setImage(image3);
    		currentCharacter = characters.get(2);
        });
    	card4.setOnMouseClicked(e -> {
    		character.setImage(image4);
    		currentCharacter = characters.get(3);
        });
    	card5.setOnMouseClicked(e -> {
    		character.setImage(image5);
    		currentCharacter = characters.get(4);
        });
    } 
    
    public void displayEnemyImage() {
    	enemies = principal.getGame().getEnemyCharactersVertex();
    	image6 = new Image(getClass().getResource(enemies.get(0).getValue().getUrl()).toExternalForm());
    	image7 = new Image(getClass().getResource(enemies.get(1).getValue().getUrl()).toExternalForm());
    	image8 = new Image(getClass().getResource(enemies.get(2).getValue().getUrl()).toExternalForm());
    	image9 = new Image(getClass().getResource(enemies.get(3).getValue().getUrl()).toExternalForm());
    	image10 = new Image(getClass().getResource(enemies.get(4).getValue().getUrl()).toExternalForm());
    	card6.setImage(image6);
    	card7.setImage(image7);
    	card8.setImage(image8);
    	card9.setImage(image9);
    	card10.setImage(image10);
    	enemy.setImage(image6);
    	currentEnermy = enemies.get(0);
    	enemyCharacters.add(card6);
    	enemyCharacters.add(card7);
    	enemyCharacters.add(card8);
    	enemyCharacters.add(card9);
    	enemyCharacters.add(card10);
    }
    
    public void setPrincipalWindow(PrincipalWindowController principal) {
    	this.principal = principal;
    }

    @FXML
    void fight(ActionEvent event) {
    	principal.getGame().setTotalEnergy(Integer.parseInt(totalEnergy.getText()));
    	if(principal.getGame().battleTime(currentCharacter, currentEnermy)) {
    		if(principal.getGame().fight(currentCharacter, currentEnermy)) {
    			enemyCharacters.get(counter).setOpacity(0.56);
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("Victory!");
    			alert.setContentText(currentCharacter.getValue().getName()+" wins this fight!");
    			alert.show();
    			counter++;
    			currentEnermy = enemies.get(counter);
    			if(counter<5)
    				enemy.setImage(enemyCharacters.get(counter).getImage());
    		}else {
    			for (ImageView imageView : playerCharacters) {
					if(getClass().getResource(currentCharacter.getValue().getUrl()).toExternalForm().equals(imageView.getImage().impl_getUrl())) {
						imageView.setOnMouseClicked(null);
						imageView.setOpacity(0.56);
						break;
					}
				}
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("Defeat!");
    			alert.setContentText(currentCharacter.getValue().getName()+" lost this fight...");
    			alert.show();
    			character.setImage(null);
    		}
    	}else {
    		String story = principal.getGame().tellStory(currentCharacter, currentEnermy);
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Story");
			alert.setContentText(story);
			alert.show();
    		principal.getGame().createBattle(currentCharacter, currentEnermy);
    	}
    	totalEnergy.setText(principal.getGame().getTotalEnergy()+"");
    	
    	
    }
    
    @FXML
    public void prim() {
    	double mstWeight = principal.getGame().getBestPossibleScore(currentCharacter);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("BS");
		alert.setContentText(mstWeight+"");
		alert.show();
    }
}
