package util;

import text_util.Option;

import java.util.List;

public class Printer {

	public static int lastMaxOptions;
	
    public static void printOptionsWithBack(List<Option> optionList) {
        System.out.println("1 - Back");
        lastMaxOptions = 1;
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 2) + " - " + optionList.get(i).getOptionText());
            optionList.get(i).setOptionId(i + 2);
            lastMaxOptions++;
        }
    }

    public static void printOptions(List<Option> optionList) {
    	lastMaxOptions = 1;
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 1) + " - " + optionList.get(i).getOptionText());
            optionList.get(i).setOptionId(i + 1);
            lastMaxOptions++;
        }
    }

    public static void printList(List<String> stringList) {
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    public static void printInputPrompt() {
    	System.out.print("> ");
    }
    
    public static void printBreak() {
        System.out.println("");
    }

	public static void printCurrentRoomGeneralDescription(List<Description> roomDescriptions) {
		if (roomDescriptions.size() > 0 && roomDescriptions != null) {
			for (int i = 0; i < roomDescriptions.size(); i++) {
				System.out.println(roomDescriptions.get(i).text);
			}
		}
	}

	public static void printInvalidInput() {
		System.out.println("Invalid Input");
		
	}

}
