package model;

public enum Department {
    ADMINISTRATION("Administration"),
    SCIENCE("Science"),
    MATHEMATICS("Mathematics"),
    HUMANITIES("Humanities"),
    IT_SUPPORT("IT Support"),
    FINANCE("Finance"),
    ARTS_AND_SPORTS("Arts & Sports"),
    LIBRARY("Library");

    private final String deptName;

    Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public static Department fromString(String text) {
        for (Department dept : Department.values()) {
            if (dept.deptName.equalsIgnoreCase(text.trim())) {
                return dept;
            }
        }
        return null;
    }
}
