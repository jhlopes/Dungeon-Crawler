package controller;

import player.Enemy;
import util.Input;

import java.util.Collections;
import java.util.List;

public class FightController extends Controller {

	private static FightController instance;
	private static int roundCount;

	public static FightController getInstance() {
		if (instance == null) {
			instance = new FightController();
		}
		return instance;
	}

	public void startFight(List<Enemy> listEnemy) {
		roundCount = 0;
		boolean fighting = true;
		while (fighting) {
			// show initial enemy list
			if (Input.getInstance().showInputOptions(Collections.singletonList(listEnemy))) {
				//
				// show target option
				// choose action (attack, flee, use item)
				// attack or use action
				// calculate
				// enemies choose
				// calculate
				// end of turn
			}
			roundCount++;
		}

	}

}
