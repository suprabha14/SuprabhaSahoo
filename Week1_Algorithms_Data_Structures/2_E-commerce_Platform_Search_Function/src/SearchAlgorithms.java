import java.util.Arrays;

public class SearchAlgorithms {

    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(targetName)) {
                return i; 
            }
        }
        return -1; 
    }

    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareTo(targetName);
            
            if (comparison == 0) {
                return mid; 
            } else if (comparison < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics"),
            new Product("003", "Tablet", "Electronics"),
            new Product("004", "Headphones", "Accessories"),
            new Product("005", "Monitor", "Electronics")
        };

        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        String searchName = "Smartphone";
        int resultLinear = linearSearch(products, searchName);
        System.out.println("Linear Search: " + (resultLinear != -1 ? "Found " + products[resultLinear] : "Not Found"));

        int resultBinary = binarySearch(products, searchName);
        System.out.println("Binary Search: " + (resultBinary != -1 ? "Found " + products[resultBinary] : "Not Found"));
    }
}
