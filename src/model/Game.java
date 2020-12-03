package model;

import java.util.HashMap;

import customExceptions.AlreadyHaveCharacter;
import graphs.*;

public class Game {
	private Score firstPlace;
	private Score secondPlace;
	private Score thirPlace;
	private IGraph<Character> characters;
	private HashMap<String, Player> players;
	public static final int NUMBER_OF_CHARACTERS = 10;

	public Game(){
		players = new HashMap<>();
//		characters = new AdjMatrixGraph<Character>(true, true);
		Character one = new Character("Flash", 80);
//		Character two = new Character("Captain America", 35);
//		Character three = new Character("Doctor Strange", 83);
//		Character four = new Character("Iron Man", 58);
//		Character five = new Character("Thor", 70);
//		Character six = new Character("Spiderman", 45);
//		Character seven = new Character("Black Widow", 13);
//		Character eight = new Character("Thanos", 90);
//		Character nine = new Character("Scarlet Witch", 85);
//		Character ten = new Character("Hulk", 79);
		Player p = new Player("DavidFiat24");
		players.put(p.getNickname(), p);
//		System.out.println(p.assignCharacter(one));
//		characters.addVertex(one);
//		characters.addVertex(two);
//		characters.addVertex(three);
//		characters.addVertex(four);
//		characters.addVertex(five);
//		characters.addVertex(six);
//		characters.addVertex(seven);
//		characters.addVertex(eight);
//		characters.addVertex(nine);
//		characters.addVertex(ten);

	}
	
	public void addPlayer(String nickname) {
		
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, Player> players) {
		this.players = players;
	}

	public Score getFirstPlace() {
		return firstPlace;
	}

	public void setFirstPlace(Score firstPlace) {
		this.firstPlace = firstPlace;
	}

	public Score getSecondPlace() {
		return secondPlace;
	}

	public void setSecondPlace(Score secondPlace) {
		this.secondPlace = secondPlace;
	}

	public Score getThirPlace() {
		return thirPlace;
	}

	public void setThirPlace(Score thirPlace) {
		this.thirPlace = thirPlace;
	}
	
	
}
