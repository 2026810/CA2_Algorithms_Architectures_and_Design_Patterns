package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.ManagerType;
import model.MenuOption;
import model.RecursiveAlgorithms;
import model.SchoolBinaryTree;
import model.StaffMember;
import view.ConsoleView;

/**
 * Controller class in the MVC architecture that coordinates user interactions,
 * file ingestion, algorithm execution, input validation, and binary tree construction.
 *
 * @author Gabriel Cinzas Longo (2026810)
 */
public class SchoolController {
    private final ConsoleView view;
    private List<StaffMember> staffList;
    private final List<StaffMember> newlyAddedRecords;

    /**
     * Constructs the SchoolController with the specified ConsoleView.
     *
     * @param view the console view responsible for user I/O
     */
    public SchoolController(ConsoleView view) {
        this.view = view;
        this.staffList = new ArrayList<>();
        this.newlyAddedRecords = new ArrayList<>();
    }

    /**
     * Starts the application lifecycle: loads initial staff data from file
     * and runs the main menu loop until the user selects EXIT.
     */
    public void start() {
        loadFile();
        boolean running = true;

        while (running) {
            view.displayMenu();
            String input = view.getUserInput();

            MenuOption selectedOption = parseMenuOption(input);
            if (selectedOption == null) {
                view.displayError("Invalid menu option. Please enter a valid number (1-5) or option name.");
                continue;
            }

            view.displayMessage(selectedOption.getLabel() + " selected");

            switch (selectedOption) {
                case SORT:
                    handleSort();
                    break;
                case SEARCH:
                    handleSearch();
                    break;
                case ADD_RECORDS:
                    handleAddRecord();
                    break;
                case CREATE_BINARY_TREE:
                    handleCreateBinaryTree();
                    break;
                case EXIT:
                    view.displayMessage("Exiting application. Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    /**
     * Prompts for a CSV/TXT filename and loads valid StaffMember records into memory.
     * Handles missing or unreadable files gracefully via IOException recovery.
     */
    private void loadFile() {
        boolean loaded = false;
        while (!loaded) {
            String filename = view.promptFilename();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                boolean isHeader = true;
                while ((line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue; 
                    }
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    String[] parts = line.split(",");
                    if (parts.length >= 8) {
                        String fullName = parts[0].trim() + " " + parts[1].trim();
                        Department dept = Department.fromString(parts[5].trim());
                        ManagerType manager = ManagerType.fromString(parts[7].trim());

                        if (dept != null && manager != null) {
                            staffList.add(new StaffMember(fullName, manager, dept));
                        }
                    }
                }
                view.displayMessage("File read successfully (" + staffList.size() + " records loaded).");
                loaded = true;
            } catch (IOException e) {
                view.displayError("Could not read file '" + filename + "'. Please check the filename and try again.");
            }
        }
    }

    /**
     * Parses raw user menu input into a type-safe MenuOption enum constant,
     * supporting both numeric choices (1-5) and text labels.
     *
     * @param input raw string entered by the user
     * @return matching MenuOption, or null if invalid
     */
    private MenuOption parseMenuOption(String input) {
        try {
            int num = Integer.parseInt(input);
            return MenuOption.fromNumber(num);
        } catch (NumberFormatException e) {
            for (MenuOption opt : MenuOption.values()) {
                if (opt.getLabel().equalsIgnoreCase(input) || opt.name().equalsIgnoreCase(input)) {
                    return opt;
                }
            }
            return null;
        }
    }

    /**
     * Sorts the staff list alphabetically using recursive Merge Sort (O(n log n))
     * and instructs the view to display the top 20 records.
     */
    private void handleSort() {
        staffList = RecursiveAlgorithms.mergeSort(staffList);
        view.displaySortedTop20(staffList);
    }

    /**
     * Ensures the staff list is sorted before executing a recursive Binary Search (O(log n))
     * for a target employee name entered by the user.
     */
    private void handleSearch() {
        staffList = RecursiveAlgorithms.mergeSort(staffList);
        String targetName = view.promptSearchName();
        StaffMember found = RecursiveAlgorithms.recursiveBinarySearch(staffList, targetName, 0, staffList.size() - 1);
        view.displaySearchResult(found);
    }

    /**
     * Prompts for and validates new staff member details against ManagerType and
     * Department enums before appending the record to memory.
     */
    private void handleAddRecord() {
        String name = "";
        while (name.isEmpty()) {
            view.displayMessage("Enter new staff member's full name:");
            name = view.getUserInput();
            if (name.isEmpty()) {
                view.displayError("Name cannot be empty.");
            }
        }

        ManagerType selectedManager = null;
        while (selectedManager == null) {
            view.displayValidManagerTypes();
            view.displayMessage("Enter a valid Manager Type from the list above:");
            String managerInput = view.getUserInput();
            selectedManager = ManagerType.fromString(managerInput);
            if (selectedManager == null) {
                view.displayError("Invalid Manager Type. Please type one of the listed roles exactly.");
            }
        }

        Department selectedDept = null;
        while (selectedDept == null) {
            view.displayValidDepartments();
            view.displayMessage("Enter an existing Department from the list above:");
            String deptInput = view.getUserInput();
            selectedDept = Department.fromString(deptInput);
            if (selectedDept == null) {
                view.displayError("Invalid Department. Please type one of the listed departments exactly.");
            }
        }

        StaffMember newStaff = new StaffMember(name, selectedManager, selectedDept);
        staffList.add(newStaff);
        newlyAddedRecords.add(newStaff);

        view.displayMessage("\nRecord added successfully!");
        view.displayNewlyAddedRecords(newlyAddedRecords);
    }

    /**
     * Builds a complete, level-order Binary Tree from the staff list (minimum 20 records)
     * and displays the level-by-level organizational hierarchy, height, and node count.
     */
    private void handleCreateBinaryTree() {
        if (staffList.size() < 20) {
            view.displayError("Minimum 20 records required to build the binary tree.");
            return;
        }

        SchoolBinaryTree tree = new SchoolBinaryTree();
        for (StaffMember member : staffList) {
            tree.insertLevelOrder(member);
        }

        view.displayBinaryTreeHierarchy(
                tree.getLevelOrderHierarchy(),
                tree.getHeight(),
                tree.getTotalNodeCount()
        );
    }
}
