package items;

import java.util.Random;

import util.Description;

public class Furniture {

	private Description description;

	public Furniture() {
		Random r = new Random();
		String[] adjective = { "old", "new", "antique", "fine", "heavy", "modern", "little", "only", "wooden",
				"upholstered", "beautiful", "rich", "comfortable", "expensive", "simple", "costly", "dark", "broken",
				"cheap", "elegant", "solid", "nice", "rustic", "massive", "traditional", "polished", "ancient", "used",
				"functional", "shabby", "ornamental", "lovely", "handmade", "broken", "broken", "broken", "broken",
				"broken" };
		String[] furniture = { "Armchair", "Bathtub", "Bed", "Chair", "Coffee table", "Dishwasher", "Dresser", "Lamp",
				"Microwave oven", "Refrigerator", "Rug", "Table", "Lamp", "Chair", "Table", "Wardrobe", "Chest",
				"Chest", "Chest", "Cupboard" };
		this.description = new Description("furniture");
		this.description.name = furniture[r.nextInt(furniture.length)];
		this.description.text = "It is a " + adjective[r.nextInt(adjective.length)] + " " + this.description.name;

	}

	public Description getDescription() {
		return this.description;
	}

}
