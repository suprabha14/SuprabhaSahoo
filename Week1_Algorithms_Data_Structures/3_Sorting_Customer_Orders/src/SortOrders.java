import java.util.Arrays;

public class SortOrders {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                  
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        
        Order[] orders = {
            new Order("001", "Alice", 250.0),
            new Order("002", "Bob", 150.0),
            new Order("003", "Charlie", 350.0),
            new Order("004", "David", 200.0),
            new Order("005", "Eve", 300.0)
        };

        System.out.println("Before Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
        
        bubbleSort(orders);
        
        System.out.println("After Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("Before Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        quickSort(orders, 0, orders.length - 1);

        System.out.println("After Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
