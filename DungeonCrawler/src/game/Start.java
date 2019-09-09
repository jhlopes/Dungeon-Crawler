package game;

import controller.FightController;
import controller.MenuController;
import controller.MovementController;
import controller.RoundCounter;
import text_util.MenuOptionText;
import types.MenuType;
import util.Direction;
import util.Input;
import util.Printer;

public class Start {

	public static void main(String[] args) {

		MenuController menuController = MenuController.getInstance();
		MovementController movementController = MovementController.getInstance();
		FightController fightController = FightController.getInstance();
		// InventoryController inventoryController = InventoryController.getInstance();
		Input input = Input.getInstance();

		while (true) {

			Printer.printCurrentRoomGeneralDescription(
					MenuOptionText.getRoomGeneralDescription(movementController.getCurrentRoom()));
			Printer.printOptions(MenuOptionText.getMainMenuOptionsText());
			input.setPlayerInput(Printer.lastMaxOptions);
			switch (input.getInput(MenuOptionText.getMainMenuOptionsText())) {
			case "Move": // move
				Printer.printOptions(MenuOptionText
						.addBackAndId(MenuOptionText.getMoveOptionsText(movementController.getCurrentRoom())));
				input.setPlayerInput(Printer.lastMaxOptions);
				movementController.executeMove(input.getMoveOutput(MenuOptionText
						.addBackAndId(MenuOptionText.getMoveOptionsText(movementController.getCurrentRoom()))));
				break;
//			case FIGHT: //fight
//				menuController.printFightMenuOptions();
//				input.setPlayerInput(MenuType.FIGHT);
//				fightController.executePlayerInput(input.getFightInput);
//				//input.getInputFight(movementController.getRoomOptions());
//				break;
//			case INVENTORY: //inventory
//				menuController.printInventoryMenuOptions();
//				input.setPlayerInput(MenuType.INVENTORY);
//				inventoryController.executePlayerInput(input.getFightInput);
//				//input.getInputInventory(movementController.getPlayerOptions());
//				//movementController.inventoryAction(input.getDesiredAction());
//				break;
//			case SEARCH:
//				
//				break;
//			case LOOK: //look
//				input.getInputLook(movementController.getRoomOptions());
//				break;
//			case NULL:
//				break;
//			default:
//				break;
			}
//
//			System.out.println("CurrentRound: " + RoundCounter.round());
//
		}
	}
}
