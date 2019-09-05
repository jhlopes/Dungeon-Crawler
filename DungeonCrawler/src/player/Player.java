package player;

import java.util.ArrayList;
import java.util.List;

import items.Item;
import types.ItemType;
import util.Description;

public class Player {

	private static List<Item> listItems;
	private static Player instance;

	public static synchronized Player getInstance() {
		if (instance == null) {
			instance = new Player();
		}
		return instance;
	}
	
	private Player() {
		listItems = new ArrayList<Item>();
		listItems.add(new Item(ItemType.WEAPON));
	}

	public boolean inventoryIsEmpty() {
		return listItems.size() < 1;
	}

	public List<Description> getInventoryDescriptors() {
		
		if (!inventoryIsEmpty()) {
			List<Description> listOfDescriptions = new ArrayList<Description>();
			for (int i = 0; i < listItems.size(); i++) {
				listOfDescriptions.add(listItems.get(i).getDescription());
			}
			return listOfDescriptions;
		}
		return null;
	}

}
