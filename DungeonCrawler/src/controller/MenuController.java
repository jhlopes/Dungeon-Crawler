package controller;

public class MenuController extends Controller {

    private static MenuController instance;

    public static void throwInvalidInput() {
        System.out.println("Invalid input");
    }

    public static synchronized MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }
}
