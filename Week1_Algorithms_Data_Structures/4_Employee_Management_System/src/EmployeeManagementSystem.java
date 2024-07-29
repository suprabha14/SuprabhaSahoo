public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            System.out.println("Array is full, cannot add more employees.");
            return;
        }
        employees[size] = employee;
        size++;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; 
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        int deleteIndex = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = deleteIndex; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null;
        size--;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("E003", "Charlie", "Analyst", 50000));

        System.out.println("Employees:");
        ems.traverseEmployees();

        String searchId = "E002";
        Employee employee = ems.searchEmployee(searchId);
        System.out.println("Search result for " + searchId + ": " + (employee != null ? employee : "Not Found"));

        String deleteId = "E002";
        ems.deleteEmployee(deleteId);
        System.out.println("After deleting " + deleteId + ":");
        ems.traverseEmployees();
    }
}
