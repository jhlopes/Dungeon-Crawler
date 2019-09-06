package rooms;

import util.Direction;

public class RoomManager {

	private final static int SIZE = 15;
	private static RoomManager instance;
	private Room[][] rooms;

	public int size() {
		return RoomManager.SIZE;
	}
	
	public boolean OOB(int row, int column) {
		return isOutOfBounds(row, column);
	}
	
	private RoomManager() {
		this.rooms = new Room[SIZE][SIZE];
	}

	public static synchronized RoomManager getInstance() {
		if (instance == null) {
			instance = new RoomManager();
		}
		return instance;
	}

	private boolean isNotEmpty(int row, int column) {
		return this.rooms[row][column] != null;
	}
	
	public boolean isEmpty(int row, int column, Direction direction) {
		if (isOutOfBounds(direction.getNextPositionRow(row), direction.getNextPositionColumn(column))) {
			return false;
		}
		return rooms[direction.getNextPositionRow(row)][direction.getNextPositionColumn(column)] == null 
				&& !isOutOfBounds(direction.getNextPositionRow(row), direction.getNextPositionColumn(column));
	}

	public void addRoom(int row, int column) {
		if (!isNotEmpty(row, column)) {
			this.rooms[row][column] = new Room();
		}
	}

	public void addAdjacentRoom(int row, int column, Direction direction) {
		if (isOutOfBounds(row, column)
				|| isOutOfBounds(direction.getNextPositionRow(row), direction.getNextPositionColumn(column))) {
			return;
		}
		if (isNotEmpty(row, column)) {
			rooms[row][column].addRoom(direction);
			int newRow = direction.getNextPositionRow(row);
			int newColumn = direction.getNextPositionColumn(column);
			rooms[newRow][newColumn] = rooms[row][column].getAdjacent(direction);

		}
	}

	private boolean isOutOfBounds(int row, int column) {
		return row < 0 || row >= SIZE || column < 0 || column >= SIZE;
	}

	public void addEntrance(int row, int column, Direction direction) {
		if (isNotEmpty(row, column)
				&& isNotEmpty(direction.getNextPositionRow(row), direction.getNextPositionColumn(column))) {
			if (!isOutOfBounds(row, column)
					&& !isOutOfBounds(direction.getNextPositionRow(row), direction.getNextPositionColumn(column))) {
				this.rooms[row][column].addEntranceBoth(direction,
						rooms[direction.getNextPositionRow(row)][direction.getNextPositionColumn(column)]);
			}
		}
	}

	public void addAdjacentRoomByID(int id, Direction direction) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (isNotEmpty(i, j)) {
					if (rooms[i][j].getID() == id) {
						addAdjacentRoom(i, j, direction);
					}
				}
			}
		}
	}

	public void addAdjacentRoomByID(char id, Direction direction) {
		id -= 65;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (isNotEmpty(i, j)) {
					if (rooms[i][j].getID() == id) {
						addAdjacentRoom(i, j, direction);
					}
				}
			}
		}
	}

	public void addEntranceByID(int id, Direction direction) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (isNotEmpty(i, j)) {
					if (rooms[i][j].getID() == id) {
						addEntrance(i, j, direction);
					}
				}
			}
		}
	}

	public void addEntranceByID(char id, Direction direction) {
		id -= 65;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (isNotEmpty(i, j)) {
					if (rooms[i][j].getID() == id) {
						addEntrance(i, j, direction);
					}
				}
			}
		}
	}

	public Room[][] getRooms(){
		return this.rooms;
	}
	
	public void print() {
		for (int i = 0; i < SIZE; i++) {
			boolean[] entVert = new boolean[SIZE];
			for (int j = 0; j < SIZE; j++) {
				if (isNotEmpty(i, j)) {
					if (rooms[i][j].hasEntrance(Direction.DOWN)) {
						entVert[j] = true;
					}
					if (rooms[i][j].hasEntrance(Direction.LEFT)) {
						System.out.print("-");
					}
					System.out.print(rooms[i][j]);
					if (rooms[i][j].hasEntrance(Direction.RIGHT)) {
						System.out.print("-");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print("   ");
				}

			}
			System.out.println("");
			for (int k = 0; k < entVert.length; k++) {
				if (entVert[k]) {
					System.out.print("|  ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("");

		}

	}

	public void finishAllAdjacents() {
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (!isOutOfBounds(row, column) && isNotEmpty(row, column)) {
					if (!isOutOfBounds(row, column - 1) && isNotEmpty(row, column - 1)) { // LEFT
						if (rooms[row][column].getEntrances()[2]) {
							rooms[row][column - 1].addEntranceBoth(Direction.RIGHT, rooms[row][column]);
						}
					}
					if (!isOutOfBounds(row, column + 1) && isNotEmpty(row, column + 1)) { // RIGHT
						if (rooms[row][column].getEntrances()[0]) {
							rooms[row][column + 1].addEntranceBoth(Direction.LEFT, rooms[row][column]);
						}
					}
					if (!isOutOfBounds(row - 1, column) && isNotEmpty(row - 1, column)) { // UP
						if (rooms[row][column].getEntrances()[1]) {
							rooms[row - 1][column].addEntranceBoth(Direction.DOWN, rooms[row][column]);
						}
					}
					if (!isOutOfBounds(row + 1, column) && isNotEmpty(row + 1, column)) { // DOWN
						if (rooms[row][column].getEntrances()[3]) {
							rooms[row + 1][column].addEntranceBoth(Direction.UP, rooms[row][column]);
						}
					}
				}
			}
		}
	}

}
