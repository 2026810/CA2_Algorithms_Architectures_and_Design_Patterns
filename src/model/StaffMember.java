package model;

public class StaffMember {
    private String name;
    private ManagerType managerType;
    private Department department;

    public StaffMember(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Name: %-20s | Manager Type: %-22s | Department: %s",
                name, managerType.getTitle(), department.getDeptName());
    }
}