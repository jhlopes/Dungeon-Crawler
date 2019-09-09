package util;

import java.util.Random;

public enum Direction {

	UP, DOWN, LEFT, RIGHT;

	public int value() {
		switch (this) {
		case RIGHT:
			return 0;
		case UP:
			return 1;
		case LEFT:
			return 2;
		case DOWN:
			return 3;
		default:
			return -1;
		}
	}

	public static Direction intDirection(int i) {
		switch (i) {
		case 0:
			return RIGHT;
		case 1:
			return UP;
		case 2:
			return LEFT;
		case 3:
			return DOWN;
		default:
			return null;
		}
	}

	public static Direction randomDirection(Random r) {
		switch (r.nextInt(4)) {
		case 0:
			return RIGHT;
		case 1:
			return UP;
		case 2:
			return LEFT;
		case 3:
			return DOWN;
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		switch (this) {
		case UP:
			return "North";
		case DOWN:
			return "South";
		case LEFT:
			return "West";
		case RIGHT:
			return "East";
		default:
			return "ERROR";
		}
	}

	public Direction opposite() {
		switch (this) {
		case RIGHT:
			return LEFT;
		case UP:
			return DOWN;
		case LEFT:
			return RIGHT;
		case DOWN:
			return UP;
		default:
			return null;
		}

	}

	public int getNextPositionRow(int row) {
		switch (this) {
		case RIGHT:
			return row;
		case UP:
			return row - 1;
		case LEFT:
			return row;
		case DOWN:
			return row + 1;
		default:
			return -1;
		}
	}

	public int getNextPositionColumn(int column) {
		switch (this) {
		case RIGHT:
			return column + 1;
		case UP:
			return column;
		case LEFT:
			return column - 1;
		case DOWN:
			return column;
		default:
			return -1;
		}
	}

	public static Direction parseDirection(String optionText) {
		if (optionText.equalsIgnoreCase("west"))
			return LEFT;
		if (optionText.equalsIgnoreCase("east"))
			return RIGHT;
		if (optionText.equalsIgnoreCase("north"))
			return UP;
		if (optionText.equalsIgnoreCase("south"))
			return DOWN;

		return null;
	}

}
