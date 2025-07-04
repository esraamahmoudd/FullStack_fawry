public class Main {
    public static void main(String[] args) {
        Valid();
        expired();
        outofstock();
        not_enough_balance();
        empty();
    }

    static void Valid() {
        System.out.println("------------------------------ Valid Checkout -----------------------------------------------");
        try {
            Product cheese = new Product("Cheese 250g", 100, 5, false, true, 0.25);
            Product biscuits = new Product("Biscuits 300g", 150, 2, false, true, 0.3);
            Product scratchCard = new Product("Scratch Card", 15, 10, false, false, 0.01);

            Customer customer = new Customer("Esraa", 3000);
            Cart cart = new Cart();

            cart.add(cheese, 4);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    static void expired() {
        System.out.println("------------Expired Product---------------------------------------");
        try {
            Product cheese = new Product("Cheese 250g", 100, 5, true, true, 0.25);
            Customer customer = new Customer("Esraa", 1000);
            Cart cart = new Cart();

            cart.add(cheese, 2);
            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        System.out.println();
    }

    static void outofstock() {
        System.out.println("---------------Out of Stock ---------------------------------");
        try {
            Product biscuits = new Product("Biscuits 300g", 150, 1, false, true, 0.3);
            Customer customer = new Customer("Esraa", 1000);
            Cart cart = new Cart();

            cart.add(biscuits, 5);
            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    static void not_enough_balance() {
        System.out.println("---------------- Insufficient Balance-------------------------------");
        try {
            Product tv = new Product("TV", 30000, 1, false, true, 15);
            Customer poorCustomer = new Customer("Esraa", 500);
            Cart cart = new Cart();

            cart.add(tv, 1);
            CheckoutService.checkout(poorCustomer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    static void empty() {
        System.out.println("----------------------------Empty Cart-----------------------------");
        try {
            Customer customer = new Customer("Esraa", 1000);
            Cart emptyCart = new Cart();

            CheckoutService.checkout(customer, emptyCart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}
