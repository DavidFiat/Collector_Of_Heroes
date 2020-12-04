package customExceptions;

public class AlreadyHaveCharacter extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyHaveCharacter(String playerName, String name) {
		super(playerName + " has already collected " + name);
	}
}
