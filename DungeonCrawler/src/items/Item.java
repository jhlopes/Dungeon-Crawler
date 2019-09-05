package items;

import java.util.Random;

import types.ItemType;
import util.Description;

public class Item {

	private boolean usable;
	private boolean equipable;
	private boolean requiresTarget;
	private String name;
	private ItemType type;
	private Description description;

	public Item(ItemType type) {
		this.type = type;
		description = new Description("item");
		switch (this.type) {
		case ARMOR:
			equipable = true;
			description.name = "Armor";
			break;
		case KEY:
			usable = true;
			requiresTarget = true;
			description.name = "Key";
			break;
		case POTION:
			usable = true;
			description.name = "Potion";
			break;
		case WEAPON:
			equipable = true;
			description.name = "Sword";
			break;
		default:
			break;
		}
		String[] adjective = { "rusty", "great", "broken", "cheap", "small", "powerful", "weak", "dusty", "metalic",
				"big" };
		Random r = new Random();
		description.text = "It is a " + adjective[r.nextInt(adjective.length)] + " " + description.name;

	}

	public Description getDescription() {
		return this.description;
	}

}
