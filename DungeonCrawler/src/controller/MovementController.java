package controller;

import player.Player;
import rooms.Generator;
import rooms.Room;
import util.Direction;
import util.Printer;

public class MovementController extends Controller {

	private static int currentRow;
	private static int currentColumn;
	private static Room currentRoom;
	private static Room[][] rooms;
	private static MovementController instance;


	public static synchronized MovementController getInstance() {
		if (instance == null) {
			instance = new MovementController();
		}
		return instance;
	}

	private MovementController() {
		Generator gen = Generator.getInstance();
		rooms = gen.generateRandomMap(true); /*boolean print or not*/
		currentRow = gen.getStarters()[0];
		currentColumn = gen.getStarters()[1];
		currentRoom = rooms[currentRow][currentColumn];
		currentRoom.getObjects().setPlayer(true);
	}

	public void movePlayer(Direction directionInput) {
		if (directionInput == null)
			return;
		if (currentRoom.hasEntrance(directionInput)) {
			currentRoom.getObjects().setPlayer(false);
			currentRow = directionInput.getNextPositionRow(currentRow);
			currentColumn = directionInput.getNextPositionColumn(currentColumn);
			currentRoom = rooms[currentRow][currentColumn];
			currentRoom.getObjects().setPlayer(true);
			RoundCounter.nextRound();
		}

	}
	

	public void executePlayerInput(Direction moveInput) {
		if (moveInput == null) {
			MenuController.throwInvalidInput();
			return;
		}
		movePlayer(moveInput);
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void executeMove(Direction moveInput) {
		if (moveInput == null) {
			Printer.printBreak();
			return;
		}
		movePlayer(moveInput);
	}

}
