package game;

import traveller.MovementController;
import traveller.RoundCounter;
import util.Direction;
import util.Input;

public class Start {

	public static void main(String[] args) {
		
		MovementController mvCtr = MovementController.getInstance();
		Input input = Input.getInstance();
		
		while(true) {
			
			mvCtr.printRoomDescription();
			input.getInputChooseAction();
			switch (input.getDesiredAction()) {
			case 1: //move
				input.getInputMove(mvCtr.getRoomOptions());
				mvCtr.movePlayer(input.getMoveInput());
				break;
			case 3:
				input.getInputInventory(mvCtr.getPlayerOptions());
				mvCtr.inventoryAction(input.getDesiredAction());
				break;
			case 5: //look
				input.getInputLook(mvCtr.getRoomOptions());
				break;
			default:
				break;
			}
			
			System.out.println("::>> " + RoundCounter.round());
			
		}
		
	}
}
