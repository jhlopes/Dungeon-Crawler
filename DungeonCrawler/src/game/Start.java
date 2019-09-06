package game;

import controller.MenuController;
import controller.MovementController;
import controller.RoundCounter;
import types.MenuType;
import util.Direction;
import util.Input;

public class Start {

	public static void main(String[] args) {
		MenuController menuController =  MenuController.getInstance();
		MovementController movementController = MovementController.getInstance();
//		FightController fightController = FightController.getInstance();
//		InventoryController inventoryController = InventoryController.getInstance();
		Input input = Input.getInstance();
		
		while(true) {
		
			menuController.printRoomDescriptionPreview();
			menuController.printMainMenuOptions();

			input.setPlayerInput();
			switch (input.getMainMenuInput()) {
			case MOVE: //move
				menuController.setMoveMenuOptions();
				menuController.printCurrentMenuOptions();
				input.setPlayerInput();
				movementController.executePlayerInput(input.getMoveInput(menuController.getCurrentOptions()));
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
			default:
				break;
			}
			
			System.out.println("CurrentRound: " + RoundCounter.round());
			
		}
		
	}
}
