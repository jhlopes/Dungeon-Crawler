package traveller;

public class RoundCounter {

	private static RoundCounter instance;
	private static int currentRound;
	
	public static synchronized RoundCounter getInstance() {
		if (instance == null) {
			instance = new RoundCounter();	
		}
		return instance;
	}
	
	public static int round() {
		return currentRound;
	}
	
	public static void nextRound() {
		currentRound++;
	}
	
}
