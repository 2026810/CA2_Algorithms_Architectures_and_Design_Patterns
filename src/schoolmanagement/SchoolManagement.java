package schoolmanagement;

import controller.SchoolController;
import view.ConsoleView;

public class SchoolManagement {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        SchoolController controller = new SchoolController(view);
        controller.start();
    }
}