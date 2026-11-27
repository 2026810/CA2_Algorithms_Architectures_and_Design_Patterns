package model;

/**
 * Domain entity representing a school staff member within the MVC model layer.
 * Encapsulates the employee's full name, validated ManagerType role, and assigned Department.
 *
 * @author Gabriel Cinzas Longo (2026810)
 */
public class StaffMember {
    private String name;
    private ManagerType managerType;
    private Department department;

    /**
     * Constructs a new StaffMember with validated role and department enums.
     *
     * @param name        the full name of the staff member
     * @param managerType the validated ManagerType role
     * @param department  the validated Department assignment
     */
    public StaffMember(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    /**
     * Returns the staff member's full name.
     *
     * @return the employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the staff member's full name.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the staff member's management role.
     *
     * @return the ManagerType enum value
     */
    public ManagerType getManagerType() {
        return managerType;
    }

    /**
     * Updates the staff member's management role.
     *
     * @param managerType the new ManagerType enum value
     */
    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    /**
     * Returns the department to which the staff member belongs.
     *
     * @return the Department enum value
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Updates the staff member's assigned department.
     *
     * @param department the new Department enum value
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Formats the staff member's details into an aligned single-line summary
     * for console output and binary tree traversal display.
     *
     * @return formatted string containing name, manager title, and department name
     */
    @Override
    public String toString() {
        return String.format("Name: %-20s | Manager Type: %-22s | Department: %s",
                name, managerType.getTitle(), department.getDeptName());
    }
}
