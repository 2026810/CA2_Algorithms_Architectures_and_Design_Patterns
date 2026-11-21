package view;

import java.util.List;
import java.util.Scanner;
import model.Department;
import model.ManagerType;
import model.MenuOption;
import model.StaffMember;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String promptFilename() {
        System.out.print("Please enter the filename to read: ");
        return scanner.nextLine().trim();
    }

    public void displayMenu() {
        System.out.println("\nDo You wish to SORT or SEARCH:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getOptionNumber() + ". " + option.getLabel());
        }
        System.out.print("Select an option: ");
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    public void displaySortedTop20(List<StaffMember> sortedList) {
        System.out.println("\n--- First 20 Sorted Staff Members (Alphabetical Order) ---");
        int limit = Math.min(20, sortedList.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i).getName());
        }
    }

    public String promptSearchName() {
        System.out.print("Enter the full name to search: ");
        return scanner.nextLine().trim();
    }

    public void displaySearchResult(StaffMember member) {
        if (member != null) {
            System.out.println("\n--- Staff Member Found ---");
            System.out.println("Name: " + member.getName());
            System.out.println("Manager Type: " + member.getManagerType().getTitle());
            System.out.println("Department: " + member.getDepartment().getDeptName());
        } else {
            System.out.println("\nStaff member not found in the records.");
        }
    }

    public void displayValidManagerTypes() {
        System.out.println("\nAvailable Manager Types:");
        for (ManagerType type : ManagerType.values()) {
            System.out.println(" - " + type.getTitle());
        }
    }

    public void displayValidDepartments() {
        System.out.println("\nAvailable Departments:");
        for (Department dept : Department.values()) {
            System.out.println(" - " + dept.getDeptName());
        }
    }

    public void displayNewlyAddedRecords(List<StaffMember> newRecords) {
        System.out.println("\n--- All Newly Added Records ---");
        for (StaffMember member : newRecords) {
            System.out.println(member);
        }
    }

    public void displayBinaryTreeHierarchy(List<String> hierarchy, int height, int totalNodes) {
        System.out.println("\n--- School Organizational Hierarchy (Level-Order Traversal) ---");
        for (String line : hierarchy) {
            System.out.println(line);
        }
        System.out.println("\nTree Height: " + height);
        System.out.println("Total Node Count: " + totalNodes);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.out.println("[ERROR] " + error);
    }
}