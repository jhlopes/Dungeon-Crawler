package util;

import text_util.Option;

import java.util.List;

public class Printer {

    public static void printOptionsWithBack(List<Option> optionList) {
        System.out.println("1 - Back");
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 2) + " - " + optionList.get(i).getOptionText());
            optionList.get(i).setOptionId(i + 2);
        }
    }

    public static void printOptions(List<Option> optionList) {
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 1) + " - " + optionList.get(i).getOptionText());
            optionList.get(i).setOptionId(i + 1);
        }
    }

    public static void printList(List<String> stringList) {
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    public static void printBreak() {
        System.out.println("");
    }

}
