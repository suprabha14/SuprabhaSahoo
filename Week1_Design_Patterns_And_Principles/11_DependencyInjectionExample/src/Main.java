public class Main {
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        String customerDetails = customerService.getCustomer("12345");
        System.out.println(customerDetails);
    }
}
