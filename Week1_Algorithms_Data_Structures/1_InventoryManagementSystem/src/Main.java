public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P001", "Laptop", 10, 1200.00));
        manager.addProduct(new Product("P002", "Smartphone", 50, 800.00));
        manager.addProduct(new Product("P003", "Tablet", 30, 600.00));

        System.out.println("Initial Inventory:");
        manager.displayInventory();

        manager.updateProduct("P002", new Product("P002", "Smartphone", 45, 750.00));
        
        manager.deleteProduct("P003");

        System.out.println("Updated Inventory:");
        manager.displayInventory();
    }
}
