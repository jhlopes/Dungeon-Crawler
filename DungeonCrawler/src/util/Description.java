package util;

import java.util.Random;

public class Description {
	public Description(String type) {
		if (type.equals("entrance")) {
			this.name = "Door";
			Random r = new Random();
			String[] adjective = { "old", "new", "antique", "fine", "heavy", "modern", "little", "only", "wooden",
					"upholstered", "beautiful", "rich", "comfortable", "expensive", "simple", "costly", "dark",
					"broken", "cheap", "elegant", "solid", "nice", "rustic", "massive", "traditional", "polished",
					"ancient", "used", "functional", "shabby", "ornamental", "lovely", "handmade", "broken", "broken",
					"broken", "broken", "broken" };
			this.text = "It is a " + adjective[r.nextInt(adjective.length)] + " door.";
		}
	}
	
	public Description(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public String name;
	public String text;
}
