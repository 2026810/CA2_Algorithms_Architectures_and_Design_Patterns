# School Management System (CA2 - Algorithms & Architecture)

A terminal-based Java application structured using the **Model-View-Controller (MVC)** architectural pattern to manage school staff records, recursive sorting/searching, input validation, and hierarchical binary tree organization.

## Architecture (MVC)
- **`model`**: Contains domain entities (`StaffMember`), Enums (`MenuOption`, `ManagerType`, `Department`), recursive algorithms (`RecursiveAlgorithms`), and the binary tree structure (`TreeNode`, `SchoolBinaryTree`).
- **`view`**: Handles all terminal input/output formatting (`ConsoleView`).
- **`controller`**: Manages application flow, file parsing, menu routing, and user input validation (`SchoolController`).
- **`schoolmanagement`**: Application entry point (`SchoolManagement.java`).

## Key Features
1. **File Loading & Error Handling**: Reads and parses staff records from `Applicants_Form.txt` with validation against missing or invalid filenames.
2. **Enum-Driven Menu**: Interactive console menu backed by `MenuOption`.
3. **Recursive Merge Sort (`SORT`)**: Recursively sorts all staff members alphabetically by name and displays the top 20 records.
4. **Recursive Binary Search (`SEARCH`)**: Sorts the list and performs a recursive binary search to retrieve a staff member's role and department.
5. **Validated Record Insertion (`ADD RECORDS`)**: Enforces valid `ManagerType` and `Department` values before adding new staff members.
6. **Binary Tree Hierarchy (`Create a binary tree`)**: Inserts records using level-order (breadth-first) insertion (left-to-right), displays the level-by-level hierarchy, and calculates tree height and total node count.

## How to Run
1. Open the project in **Apache NetBeans** (or compile via `javac` from `src/`).
2. Ensure `Applicants_Form.txt` is located in the project root directory.
3. Run `schoolmanagement.SchoolManagement` and enter `Applicants_Form.txt` when prompted.
