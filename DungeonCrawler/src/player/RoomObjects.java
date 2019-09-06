package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import items.Furniture;
import items.Item;
import util.Description;

public class RoomObjects {

	private static Random r = new Random();
	private boolean hasPlayer;
	private List<Enemy> listEnemies;
	private List<Furniture> listFurniture;
	private List<Item> itemsInFloor;

	public RoomObjects(boolean hasEnemies) {
		listEnemies = new ArrayList<Enemy>();
		listFurniture = new ArrayList<Furniture>();
		for (int i = 0, x = r.nextInt(10) + 1; i < x; i++) {
			listFurniture.add(new Furniture());
		}
		if (hasEnemies) {
			if (r.nextInt(10) < 4) {
				int x = r.nextInt(5) + 1;
				for (int i = 0; i < x; i++) {
					listEnemies.add(new Enemy(r.nextInt(10) + 1, r.nextInt(3) + 1));
				}
			}
		}
	}

	public void setPlayer(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}

	public boolean hasPlayer() {
		return hasPlayer;
	}

	public boolean hasEnemies() {
		return !this.listEnemies.isEmpty();
	}

	public int numberOfEnemies() {
		return this.listEnemies.size();
	}

	public String getEnemyDescription(int pos) {
		return this.listEnemies.get(pos).getDescription();
	}

	public List<Description> getAllEnemyDescriptions() {
		if (this.hasEnemies()) {
			List<Description> listEnemyDescription = new ArrayList<Description>();
			for (int i = 0; i < this.listEnemies.size(); i++) {
				listEnemyDescription.add(new Description(this.listEnemies.get(i).getDescription()));
			}
			return listEnemyDescription;
		} else {
			return null;
		}
	}

	public int numberOfFurniture() {
		return this.listFurniture.size();
	}

	public Furniture getFurniture(int i) {
		return this.listFurniture.get(i);
	}

	public Enemy getEnemy(int i) {
		return this.listEnemies.get(i);
	}

}
