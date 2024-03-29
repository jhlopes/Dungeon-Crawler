package rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import player.RoomObjects;
import util.Description;
import util.Direction;

public class Room {

	private static int globalID;
	private char name;
	private int id;
	private Room[] adjacentRooms;
	private boolean[] entrances;
	private RoomObjects roomObjects;

	public Room() {
		this.id = globalID++;
		this.adjacentRooms = new Room[4];
		this.entrances = new boolean[4];
		if (this.id == 0) {
			this.roomObjects = new RoomObjects(false);
		} else {
			this.roomObjects = new RoomObjects(true);
		}
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Random r = new Random();
		char randomChar = alphabet[r.nextInt(alphabet.length)];
		if (r.nextInt(2) == 0) {
			randomChar = Character.toUpperCase(randomChar);
		}
		this.name = randomChar;
	}

	public RoomObjects getObjects() {
		return this.roomObjects;
	}

	public void addAdjacentRoomBoth(Direction direction, Room room) {
		this.adjacentRooms[direction.value()] = room;
		room.adjacentRooms[direction.opposite().value()] = this;
	}

	public void addEntranceBoth(Direction direction, Room room) {
		this.addAdjacentRoomBoth(direction, room);
		this.entrances[direction.value()] = true;
		room.entrances[direction.opposite().value()] = true;
	}

	private void addRoomDefinitive(Direction direction, Room room) {
		this.adjacentRooms[direction.value()] = room;
	}

	public Room getAdjacent(Direction direction) {
		return adjacentRooms[direction.value()];
	}

	public boolean[] getEntrances() {
		return entrances;
	}

	public boolean addRoom(Direction direction) {
		if (!hasAdjacentRoom(direction)) {
			adjacentRooms[direction.value()] = new Room();
			adjacentRooms[direction.value()].addRoomDefinitive(direction.opposite(), this);
			if (this.hasEntrance(direction) && !adjacentRooms[direction.value()].hasEntrance(direction.opposite())) {
				adjacentRooms[direction.value()].addEntrance(direction.opposite());
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return Character.toString(this.name);
	}

	public int getID() {
		return this.id;
	}

	private boolean hasAdjacentRoom(Direction direction) {
		return adjacentRooms[direction.value()] != null;
	}

	public boolean addEntrance(Direction direction) {
		if (!hasEntrance(direction)) {
			if (hasAdjacentRoom(direction)) {
				entrances[direction.value()] = true;
				if (!adjacentRooms[direction.value()].hasEntrance(direction.opposite())) {
					adjacentRooms[direction.value()].addEntrance(direction.opposite());
				}
			}
			return true;
		} else {
			return false;
		}

	}

	public boolean hasEntrance(Direction direction) {
		return entrances[direction.value()];
	}

	public List<Description> getAllDescriptions() {
		List<Description> listDescription = new ArrayList<Description>();

		for (int i = 0; i < 4; i++) {
			if (entrances[i]) {
				listDescription.add(new Description("entrance"));
			}
		}
		for (int i = 0, x = roomObjects.numberOfFurniture(); i < x; i++) {
			listDescription.add(roomObjects.getFurniture(i).getDescription());
		}
		if (roomObjects.hasEnemies()) {
			for (int i = 0, x = roomObjects.numberOfEnemies(); i < x; i++) {
				listDescription.add(roomObjects.getEnemy(i).getDescriptionText());
			}
		}
		return listDescription;

	}
	
}
