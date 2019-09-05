package traveller;

import player.Player;
import rooms.Generator;
import rooms.Room;
import util.Direction;

public class MovementController {

	private static int currentRow;
	private static int currentColumn;
	private static Room[][] rooms;
	private static MovementController instance;
	private static Player player;

	public static synchronized MovementController getInstance() {
		if (instance == null) {
			instance = new MovementController();

		}
		return instance;
	}

	private Room currentRoom() {
		return rooms[currentRow][currentColumn];
	}

	private MovementController() {
		Generator gen = Generator.getInstance();
		rooms = gen.generateRandomMap(true); /*boolean print or not*/
		currentRow = gen.getStarters()[0];
		currentColumn = gen.getStarters()[1];
		currentRoom().getObjects().setPlayer(true);
	}

	public void printRoomDescription() {
		System.out.println("---/---/---/---");
		System.out.println("Current room: " + currentRoom() + "#" + currentRoom().getID());
		for (int i = 0; i < 4; i++) {
			if (currentRoom().hasEntrance(Direction.intDirection(i))) {
				System.out.println("There is a door " + Direction.intDirection(i).toString());
			}
			
		}
		if (currentRoom().getObjects().hasEnemies()) {
			int x = currentRoom().getObjects().numberOfEnemies();
			for (int i = 0; i < x; i++) {
				System.out.println("There is a " + currentRoom().getObjects().getEnemyDescription(i));
			}
		}
	}

	public Room getRoomOptions() {
		return currentRoom();
	}

	public void movePlayer(Direction directionInput) {
		if (directionInput == null)
			return;
		if (currentRoom().hasEntrance(directionInput)) {
			currentRoom().getObjects().setPlayer(false);
			currentRow = directionInput.getNextPositionRow(currentRow);
			currentColumn = directionInput.getNextPositionColumn(currentColumn);
			currentRoom().getObjects().setPlayer(true);
			RoundCounter.nextRound();
		}

	}

	public Player getPlayerOptions() {
		return Player.getInstance();
	}

	public void inventoryAction(int desiredAction) {
		// TODO Auto-generated method stub
		
	}

}
