package util;

import java.util.List;
import java.util.Scanner;

import exception.BackException;
import player.Player;
import rooms.Room;
import traveller.RoundCounter;

public class Input {

	private static Input instance;
	private static String currentInput;
	private static int currentAction;
	Scanner sc = new Scanner(System.in);

	public static Input getInstance() {
		if (instance == null) {
			instance = new Input();

		}
		return instance;
	}

	private Input() {

	}

	public void getInputChooseAction() {
		System.out.println("---/---/---/---");
		System.out.println("1 - Move");
		System.out.println("2 - Fight");
		System.out.println("3 - Inventory");
		System.out.println("4 - Search");
		System.out.println("5 - Look");
		System.out.print("> ");
		currentInput = sc.next();
		try {
			currentAction = Integer.parseInt(currentInput);
			if (currentAction >= 6) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		System.out.println("");
	}

	public int getDesiredAction() {
		return currentAction;
	}

	public void getInputMove(Room room) {
		boolean hasDoors = false;
		for (int i = 0; i < 4; i++) {
			if (room.getEntrances()[i]) {
				System.out.println(Direction.intDirection(i).toString());
				hasDoors = true;
			}
		}
		System.out.print("> ");
		currentInput = sc.next();
		if (hasDoors) {
			System.out.println("");
		} else {
			System.out.println("No doors available.");
		}
	}

	public void endInput() {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public Direction getMoveInput() {
		if (currentInput.equalsIgnoreCase("north"))
			currentInput = "north";
		if (currentInput.equalsIgnoreCase("south"))
			currentInput = "south";
		if (currentInput.equalsIgnoreCase("west"))
			currentInput = "west";
		if (currentInput.equalsIgnoreCase("east"))
			currentInput = "east";
		switch (currentInput) {
		case "north":
			return Direction.UP;
		case "south":
			return Direction.DOWN;
		case "west":
			return Direction.LEFT;
		case "east":
			return Direction.RIGHT;
		default:
			System.out.println("Invalid Input\n");
			return null;
		}
	}

	public void getInputLook(Room room) {
		List<Description> listDescription = room.getAllDescriptions();
		System.out.println("1 - Back");
		for (int i = 0; i < listDescription.size(); i++) {
			System.out.println((i + 2) + " - " + listDescription.get(i).name);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("> ");
		currentInput = sc.next();
		try {
			currentAction = Integer.parseInt(currentInput);
			if (currentAction != 1) {
				RoundCounter.nextRound();
			} else {
				throw new BackException();
			}
			if (currentAction >= (listDescription.size() + 2)) {
				throw new Exception();
			}
			System.out.println("\n" + listDescription.get(currentAction - 2).text + "\n");

		} catch (BackException e) {

		} catch (Exception e) {
			System.out.println("\nInvalid Input\n");
		}

	}

	public void getInputInventory(Player player) {
		if (player.inventoryIsEmpty()) {
			System.out.println("You have no items in your inventory");
			return;
		}
		List<Description> listInventory = player.getInventoryDescriptors();
		if (listInventory == null) {
			System.out.println("INVENTORY NULL ERROR");
			return;
		}
		System.out.println("1 - Back");
		for (int i = 0; i < listInventory.size(); i++) {
			System.out.println((i + 2) + " - " + listInventory.get(i).name);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("> ");
		currentInput = sc.next();
		try {
			currentAction = Integer.parseInt(currentInput);
			if (currentAction != 1) {
				RoundCounter.nextRound();
			} else {
				throw new BackException();
			}
			if (currentAction >= (listInventory.size() + 2)) {
				throw new Exception();
			}
			System.out.println("\n" + listInventory.get(currentAction - 2).text + "\n");

		} catch (BackException e) {

		} catch (Exception e) {
			System.out.println("\nInvalid Input\n");
		}
		
	}

}
