package model;

import java.io.Serializable;
import java.util.*;
import customExceptions.AlreadyHaveCharacter;
import graphs.*;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_OF_CHARACTERS = 10;
	private int firstPlace;
	private int secondPlace;
	private int thirdPlace;
	private int totalEnergy;
	private IGraph<Character> characters;
	private HashMap<String, Player> players;

	public Game() throws AlreadyHaveCharacter {
		players = new HashMap<>();
		characters = new AdjMatrixGraph<Character>(true, true);
		Character one = new Character("/resources/cards/Flash.jpg", 80);
		Character two = new Character("/resources/cards/CAPTAIN-AMERICA.jpg", 35);
		Character three = new Character("/resources/cards/DOCTOR-STRANGE.jpg", 83);
		Character four = new Character("/resources/cards/IRONMAN.jpg", 58);
		Character five = new Character("/resources/cards/THOR.jpg", 70);
		Character six = new Character("/resources/cards/SPIDERMAN.jpg", 45);
		Character seven = new Character("/resources/cards/Black-Widow.jpg", 13);
		Character eight = new Character("/resources/cards/THANOS.jpg", 90);
		Character nine = new Character("/resources/cards/Scarlet-Witch.jpg", 85);
		Character ten = new Character("/resources/cards/HULK.jpg", 79);
		Player p = new Player("DavidFiat24");
		players.put(p.getNickname(), p);
		p.assignCharacter(one);
		p.assignCharacter(two);
		p.assignCharacter(three);
		p.assignCharacter(four);
		p.assignCharacter(five);
		p.assignCharacter(six);
		p.assignCharacter(seven);
		p.assignCharacter(eight);
		p.assignCharacter(nine);
		p.assignCharacter(ten);
		characters.addVertex(one);
		characters.addVertex(two);
		characters.addVertex(three);
		characters.addVertex(four);
		characters.addVertex(five);
		characters.addVertex(six);
		characters.addVertex(seven);
		characters.addVertex(eight);
		characters.addVertex(nine);
		characters.addVertex(ten);
		characters.addEdge(one, two, one.getPower() - two.getPower());
		characters.addEdge(two, one, two.getPower() - one.getPower());

		characters.addEdge(two, three, two.getPower() - three.getPower());
		characters.addEdge(three, two, three.getPower() - two.getPower());

		characters.addEdge(four, three, four.getPower() - three.getPower());
		characters.addEdge(three, four, three.getPower() - four.getPower());

		characters.addEdge(four, five, four.getPower() - five.getPower());
		characters.addEdge(five, four, five.getPower() - four.getPower());

		characters.addEdge(five, six, five.getPower() - six.getPower());
		characters.addEdge(six, five, six.getPower() - five.getPower());

		characters.addEdge(six, seven, six.getPower() - seven.getPower());
		characters.addEdge(seven, six, seven.getPower() - six.getPower());

		characters.addEdge(seven, eight, seven.getPower() - eight.getPower());
		characters.addEdge(eight, seven, eight.getPower() - seven.getPower());

		characters.addEdge(eight, nine, eight.getPower() - nine.getPower());
		characters.addEdge(nine, eight, nine.getPower() - eight.getPower());

		characters.addEdge(nine, ten, nine.getPower() - ten.getPower());
		characters.addEdge(ten, nine, ten.getPower() - nine.getPower());

		characters.addEdge(ten, one, ten.getPower() - one.getPower());
		characters.addEdge(one, ten, one.getPower() - ten.getPower());
	}

	public void addPlayer(String nickname) {
		Player p = new Player(nickname);
		players.put(p.getNickname(), p);
	}

	public Player searchPlayer(String nickname) {
		return players.get(nickname);
	}

	private List<Character> getPlayerCharacters(Player p) {
		return p.getCharacters().returnHash();
	}

	public List<Vertex<Character>> getPlayerCharactersVertex(Player p) {
		List<Vertex<Character>> c = new ArrayList<Vertex<Character>>(10);
		List<Character> l = getPlayerCharacters(p);
		for (int i = 0; i < l.size(); i++) {
			c.add(characters.searchVertex(l.get(i)));
		}
		return c;
	}

	public List<Vertex<Character>> getEnemyCharactersVertex() {
		return characters.getVertices();
	}

	public int energyWasted(Vertex<Character> x, Vertex<Character> y) {
		return (int) characters.getEdgeWeight(x, y);
	}

	public boolean battleTime(Vertex<Character> x, Vertex<Character> y) {
		return energyWasted(x, y) != Integer.MAX_VALUE;
	}
	
	public boolean fight(Vertex<Character> x, Vertex<Character> y) {
		boolean won = false;
		int eneryWasted = energyWasted(x, y);
		totalEnergy = totalEnergy - eneryWasted;
		if (eneryWasted > 0) won = true;
		return won;
	}

	public void createBattle(Vertex<Character> x, Vertex<Character> y) {
		characters.addEdge(x.getValue(), y.getValue(), x.getValue().getPower() - y.getValue().getPower());
		characters.addEdge(y.getValue(), x.getValue(), y.getValue().getPower() - x.getValue().getPower());	
	}
	
	public String tellStory(Vertex<Character> x, Vertex<Character> y) {
		String story = "Before " + x.getValue().getName() + " could fight " + y.getValue().getName() +
				", " + x.getValue().getName() + " had to face ";
		for (Character character : characters.getShortestPath(x, y)) {
			story += character.getName()+", ";
		}
		story += " in combat. " + x.getValue().getName() + " was victorious and now is ready for this new challenge.";
		createBattle(x, y);
		return story;
	}
	
	public double getBestPossibleScore(Vertex<Character> x) {
		characters.prim(x);
		double bestScore = 0;
		for (Vertex<Character> u: characters.getVertices()) {
			bestScore += u.getInitialTimeStamp();
		}
		return bestScore;
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, Player> players) {
		this.players = players;
	}

	public int getFirstPlace() {
		return firstPlace;
	}

	public int getSecondPlace() {
		return secondPlace;
	}

	public int getThirdPlace() {
		return thirdPlace;
	}
}
