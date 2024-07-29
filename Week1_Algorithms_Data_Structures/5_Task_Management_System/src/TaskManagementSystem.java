class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; 
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && !current.task.getTaskId().equals(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
            return;
        }

        previous.next = current.next;
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task("T001", "Design System Architecture", "In Progress"));
        tms.addTask(new Task("T002", "Develop Login Module", "Not Started"));
        tms.addTask(new Task("T003", "Write Unit Tests", "Completed"));

        System.out.println("Tasks:");
        tms.traverseTasks();

        String searchId = "T002";
        Task task = tms.searchTask(searchId);
        System.out.println("Search result for " + searchId + ": " + (task != null ? task : "Not Found"));

        String deleteId = "T002";
        tms.deleteTask(deleteId);
        System.out.println("After deleting " + deleteId + ":");
        tms.traverseTasks();
    }
}
