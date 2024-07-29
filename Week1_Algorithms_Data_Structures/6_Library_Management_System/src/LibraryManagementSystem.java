import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            System.out.println("Array is full, cannot add more books.");
            return;
        }
        books[size] = book;
        size++;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null; 
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle));
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }

    public void traverseBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(5);

        lms.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        lms.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        lms.addBook(new Book("B003", "1984", "George Orwell"));

        System.out.println("Books:");
        lms.traverseBooks();

        String searchTitle = "1984";
        Book book = lms.linearSearchByTitle(searchTitle);
        System.out.println("Linear search result for \"" + searchTitle + "\": " + (book != null ? book : "Not Found"));

        searchTitle = "To Kill a Mockingbird";
        book = lms.binarySearchByTitle(searchTitle);
        System.out.println("Binary search result for \"" + searchTitle + "\": " + (book != null ? book : "Not Found"));
    }
}
