package items;

import java.util.Random;

import util.Description;

public class Furniture {

	private Description description;

	public Furniture() {
		this.description = generateDescription();
	}

	private Description generateDescription() {
		String[] adjective = { "old", "new", "antique", "fine", "heavy", "modern", "little", "only", "wooden",
				"upholstered", "beautiful", "rich", "comfortable", "expensive", "simple", "costly", "dark", "broken",
				"cheap", "elegant", "solid", "nice", "rustic", "massive", "traditional", "polished", "ancient", "used",
				"functional", "shabby", "ornamental", "lovely", "handmade", "broken", "broken", "broken", "broken",
				"broken" };
		String[] furniture = { "Armchair", "Bathtub", "Bed", "Chair", "Coffee table", "Dishwasher", "Dresser", "Lamp",
				"Microwave oven", "Refrigerator", "Rug", "Table", "Lamp", "Chair", "Table", "Wardrobe", "Chest",
				"Chest", "Chest", "Cupboard" };
		Random r = new Random();
		Description description = new Description("furniture");
		description.name = furniture[r.nextInt(furniture.length)];
		description.text = "It is a " + adjective[r.nextInt(adjective.length)] + " " + description.name;
		return description;
	}

	public Description getDescription() {
		return this.description;
	}

}
