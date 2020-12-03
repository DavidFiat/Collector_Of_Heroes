package model;

import java.io.Serializable;
import java.util.*;

import customExceptions.AlreadyHaveCharacter;
import graphs.*;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;
	private Score firstPlace;
	private Score secondPlace;
	private Score thirPlace;
	private IGraph<Character> characters;
	private HashMap<String, Player> players;
	public static final int NUMBER_OF_CHARACTERS = 10;

	public Game() throws AlreadyHaveCharacter {
		players = new HashMap<>();
		characters = new AdjMatrixGraph<Character>(true, true);
//		Character one = new Character("Flash", 80);
//		Character two = new Character("Captain America", 35);
//		Character three = new Character("Doctor Strange", 83);
//		Character four = new Character("Iron Man", 58);
//		Character five = new Character("Thor", 70);
//		Character six = new Character("Spiderman", 45);
//		Character seven = new Character("Black Widow", 13);
//		Character eight = new Character("Thanos", 90);
//		Character nine = new Character("Scarlet Witch", 85);
//		Character ten = new Character("Hulk", 79);
//		Player p = new Player("DavidFiat24");
//		players.put(p.getNickname(), p);
//		p.assignCharacter(one);
//		p.assignCharacter(two);
//		p.assignCharacter(three);
//		p.assignCharacter(four);
//		p.assignCharacter(five);
//		p.assignCharacter(six);
//		p.assignCharacter(seven);
//		p.assignCharacter(eight);
//		p.assignCharacter(nine);
//		p.assignCharacter(ten);
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
//		characters.addEdge(one, two, one.getPower() - two.getPower());
//		characters.addEdge(two, one, two.getPower() - one.getPower());
//		characters.addEdge(one, three, one.getPower() - three.getPower());
//		characters.addEdge(three, one, three.getPower() - one.getPower());
//		characters.addEdge(one, four, one.getPower() - four.getPower());
//		characters.addEdge(four, one, four.getPower() - one.getPower());
//		characters.addEdge(one, five, one.getPower() - five.getPower());
//		characters.addEdge(five, one, five.getPower() - one.getPower());
//		characters.addEdge(two, two, two.getPower() - two.getPower());
//		characters.addEdge(two, two, two.getPower() - two.getPower());
//		characters.addEdge(two, three, two.getPower() - three.getPower());
//		characters.addEdge(three, two, three.getPower() - two.getPower());
//		characters.addEdge(two, four, two.getPower() - four.getPower());
//		characters.addEdge(four, two, four.getPower() - two.getPower());
//		characters.addEdge(two, five, two.getPower() - five.getPower());
//		characters.addEdge(five, two, five.getPower() - two.getPower());
//		characters.addEdge(seven, two, seven.getPower() - two.getPower());
//		characters.addEdge(two, seven, two.getPower() - seven.getPower());
//		characters.addEdge(seven, three, seven.getPower() - three.getPower());
//		characters.addEdge(three, seven, three.getPower() - seven.getPower());
//		characters.addEdge(seven, four, seven.getPower() - four.getPower());
//		characters.addEdge(four, seven, four.getPower() - seven.getPower());
//		characters.addEdge(seven, five, seven.getPower() - five.getPower());
//		characters.addEdge(five, seven, five.getPower() - seven.getPower());

	}

	public void addPlayer(String nickname) {
		Player p = new Player(nickname);
		players.put(p.getNickname(), p);

	}

	public Player searchPlayer(String nickname) {
		return players.get(nickname);
	}

	private List<Character> battle(Player p) {
		return p.getCharacters().returnHash();

	}

	public List<Vertex<Character>> battleTimePlayerCharacters(Player p) {
		List<Vertex<Character>> c = new ArrayList<Vertex<Character>>(10);
		List<Character> l = battle(p);
		for (int i = 0; i < l.size(); i++) {
			c.add(characters.searchVertex(l.get(i)));
		}
		return c;

	}

	public List<Vertex<Character>> enemyCharacters() {
		return characters.getVertices();
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
