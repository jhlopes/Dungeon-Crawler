package types;

import java.util.Random;

public enum EnemyType {

	SKELETON, GOBLIN, CUCKI, BANDIT, GHOUL;

	public static EnemyType randomType() {
		Random r = new Random();
		int t = r.nextInt(5);
		switch (t) {
		case 0:
			return SKELETON;
		case 1:
			return GOBLIN;
		case 2:
			return CUCKI;
		case 3:
			return BANDIT;
		case 4:
			return GHOUL;
		default:
			return null;
		}
	}

	public String toDescription() {
		switch (this) {
		case SKELETON:
			return "Skeleton";
		case GOBLIN:
			return "Goblin";
		case CUCKI:
			return "Cucki";
		case BANDIT:
			return "Bandit";
		case GHOUL:
			return "Ghoul";
		default:
			return "ERROR ENEMY";
		}
	}
	
	
}
