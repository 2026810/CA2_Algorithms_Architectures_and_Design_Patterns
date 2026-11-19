package model;

public enum ManagerType {
    PRINCIPAL("Principal"),
    VICE_PRINCIPAL("Vice Principal"),
    HEAD_OF_DEPARTMENT("Head of Department"),
    DEPARTMENT_COORDINATOR("Department Coordinator"),
    DEAN_OF_STUDENTS("Dean of Students"),
    SENIOR_TEACHER("Senior Teacher"),
    TEACHER("Teacher"),
    JUNIOR_TEACHER("Junior Teacher"),
    TEACHING_ASSISTANT("Teaching Assistant"),
    ADMINISTRATIVE_STAFF("Administrative Staff"),
    SENIOR_ADMINISTRATOR("Senior Administrator"),
    STUDENT_COUNSELOR("Student Counselor"),
    LIBRARIAN("Librarian"),
    SENIOR_LIBRARIAN("Senior Librarian"),
    LIBRARY_ASSISTANT("Library Assistant"),
    SUBSTITUTE_TEACHER("Substitute Teacher"),
    IT_TECHNICIAN("IT Technician"),
    ACCOUNTANT("Accountant"),
    HR_COORDINATOR("HR Coordinator"),
    BURSAR_ASSISTANT("Bursar Assistant"),
    LAB_SUPERVISOR("Lab Supervisor"),
    PE_COACH("PE Coach"),
    SYSTEMS_ADMINISTRATOR("Systems Administrator"),
    ADMISSIONS_OFFICER("Admissions Officer"),
    FINANCE_CLERK("Finance Clerk"),
    HR_OFFICER("HR Officer"),
    SUPPORT_TECHNICIAN("Support Technician");

    private final String title;

    ManagerType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ManagerType fromString(String text) {
        for (ManagerType type : ManagerType.values()) {
            if (type.title.equalsIgnoreCase(text.trim())) {
                return type;
            }
        }
        return null;
    }
}