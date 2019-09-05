package rooms;

import java.util.Random;

import util.Direction;

public class Generator {
	
	private static Generator instance;
	private static Random r = new Random(); 
	static Controller ctr = Controller.getInstance();
	private static int[] starters;
	
	private Generator() {
		
	}
	
	public static synchronized Generator getInstance() {
		if (instance == null) {
			instance = new Generator();
			
		}
		return instance;
	}
	
	public Room[][] generateRandomMap(boolean print) {
		starters = generateMap();
		if (print) ctr.print();
		return ctr.getRooms();
	}
	
	public int[] getStarters(){
		return starters;
	}
	
	private static boolean coinFlip() {
		int x = r.nextInt(10);
		if (x <= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	private int[] generateMap() {
	 	int startingRow = r.nextInt(ctr.size());
	 	int startingColumn = r.nextInt(ctr.size());
	 	if (ctr.OOB(startingRow, startingColumn)) return null;
	 	ctr.addRoom(startingRow, startingColumn);
		addRandomRoom(startingRow, startingColumn);
		ctr.finishAllAdjacents();
		return new int[] {startingRow,startingColumn};
	}
	
	private void addRandomRoom(int row, int column) {
		if (ctr.OOB(row, column)) return;
	 	ctr.addRoom(row, column);
	 	boolean[] freeSpaces = new boolean[4];
	 	
	 	if (ctr.isEmpty(row, column, Direction.RIGHT) && coinFlip()) {
	 		freeSpaces[0] = true;
	 	}
	 	if (ctr.isEmpty(row, column, Direction.UP) && coinFlip()) {
	 		freeSpaces[1] = true;
	 	}
	 	if (ctr.isEmpty(row, column, Direction.LEFT) && coinFlip()) {
	 		freeSpaces[2] = true;
	 	}
		if (ctr.isEmpty(row, column, Direction.DOWN) && coinFlip()) {
			freeSpaces[3] = true;
		}
		
		for (int i = 0; i < freeSpaces.length; i++) {
			if (freeSpaces[i]) {
				ctr.addAdjacentRoom(row, column, Direction.intDirection(i));
				ctr.addEntrance(row, column, Direction.intDirection(i));
				addRandomRoom(Direction.intDirection(i).getNextPositionRow(row), Direction.intDirection(i).getNextPositionColumn(column));
			}
		}
	}
	
	
}
