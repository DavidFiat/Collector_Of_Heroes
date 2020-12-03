package customExceptions;

public class AlreadyHaveCharacter extends Exception {

	public AlreadyHaveCharacter(String playerName, String name) {
		super(playerName + " has already collected " + name);
	}
}
