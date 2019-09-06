package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.MenuController;
import controller.RoundCounter;
import exception.BackException;
import player.Player;
import rooms.Room;
import types.MenuType;

public class Input {

	private static Input instance;
	private static String currentInputString;
	private static int currentInputInteger;
	Scanner sc = new Scanner(System.in);

	public static Input getInstance() {
		if (instance == null) {
			instance = new Input();

		}
		return instance;
	}

	private Input() {

	}

	public void setPlayerInput() {
		getInputFromPlayer();
	}

	private void getInputFromPlayer() {
		MenuController.getInstance().print("> ");
		currentInputString = sc.next();
		try {
			currentInputInteger = Integer.parseInt(currentInputString);
		} catch (Exception e) {
			currentInputInteger = -1;
		}

	}

	public MenuType getMainMenuInput() {
		if (currentInputInteger < 0) {
			List<String> listMenus = MenuController.getInstance().getMenuList();
			for (int i = 0; i < listMenus.size(); i++) {
				if (currentInputString.equalsIgnoreCase(listMenus.get(i)))
					currentInputInteger = (i + 1);
			}
		}
		switch (currentInputInteger) {
		case 1:
			return MenuType.MOVE;
		case 2:
			return MenuType.FIGHT;
		case 3:
			return MenuType.INVENTORY;
		case 4:
			return MenuType.SEARCH;
		case 5:
			return MenuType.LOOK;
		default:
			return null;
		}

	}

	public Direction getMoveInput() {
		if (currentInputInteger < 0) {
			if (currentInputString.equalsIgnoreCase("north"))
				return Direction.UP;
			if (currentInputString.equalsIgnoreCase("south"))
				return Direction.DOWN;
			if (currentInputString.equalsIgnoreCase("west"))
				return Direction.LEFT;
			if (currentInputString.equalsIgnoreCase("east"))
				return Direction.RIGHT;
		}
		List<Integer> directions = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			if (MenuController.getInstance().getCurrentRoom().hasEntrance(Direction.intDirection(i))) {
				directions.add(i);
			}
		}
		return Direction.intDirection(directions.get(currentInputInteger - 1));

	}

	public Direction getMoveInput(List<MenuOption> moveOptions) {
		if (currentInputInteger < 0) {
			for (int i = 0; i < moveOptions.size(); i++) {
				if (currentInputString.equalsIgnoreCase(moveOptions.get(i).text)) {
					if (currentInputString.equalsIgnoreCase("north"))
						return Direction.UP;
					if (currentInputString.equalsIgnoreCase("south"))
						return Direction.DOWN;
					if (currentInputString.equalsIgnoreCase("west"))
						return Direction.LEFT;
					if (currentInputString.equalsIgnoreCase("east"))
						return Direction.RIGHT;
				}
			}
		} else {
			for (int i = 0; i < moveOptions.size(); i++) {
				if (currentInputInteger == moveOptions.get(i).id) {
					switch (moveOptions.get(i).text) {
					case "north":
						return Direction.UP;
					case "south":
						return Direction.DOWN;
					case "east":
						return Direction.RIGHT;
					case "west":
						return Direction.LEFT;
					default:
						return null;
					}
				}
			}
		}
		return null;

	}

}
