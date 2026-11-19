package model;

public enum MenuOption {
    SORT(1, "SORT"),
    SEARCH(2, "SEARCH"),
    ADD_RECORDS(3, "ADD RECORDS"),
    CREATE_BINARY_TREE(4, "Create a binary tree"),
    EXIT(5, "EXIT");

    private final int optionNumber;
    private final String label;

    MenuOption(int optionNumber, String label) {
        this.optionNumber = optionNumber;
        this.label = label;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getLabel() {
        return label;
    }

    public static MenuOption fromNumber(int number) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getOptionNumber() == number) {
                return option;
            }
        }
        return null;
    }
}