package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.MenuController;
import controller.RoundCounter;
import exception.BackException;
import player.Descriptable;
import player.Enemy;
import player.Player;
import rooms.Room;
import text_util.Option;
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

	public void setPlayerInput(int maxInputs) {
		getInputFromPlayer(maxInputs);
	}

	private void getInputFromPlayer(int maxInputs) {
		Printer.printInputPrompt();
		currentInputString = sc.next();
		try {
			currentInputInteger = Integer.parseInt(currentInputString);
			if (currentInputInteger > maxInputs) {
				throw new Exception();
			}
		} catch (Exception e) {
			currentInputInteger = -1;
		}

	}

	public String getInput(List<Option> listOptions) {
		for (int i = 0; i < listOptions.size(); i++) {
			if (currentInputInteger == listOptions.get(i).getOptionId()) {
				return listOptions.get(i).getOptionText();
			}
		}
		return null;
	}

	public Direction getMoveOutput(List<Option> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOptionId() == currentInputInteger) {
				return Direction.parseDirection(list.get(i).getOptionText());
			}
		}
		return null;
	}

}
