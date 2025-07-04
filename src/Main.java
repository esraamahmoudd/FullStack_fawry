public class Main {
    public static void main(String[] args) {
        try {
            Product cheese = new Product("Cheese 250g", 100, 5, false, true, 0.25);
            Product biscuits = new Product("Biscuits 300g", 150, 2, false, true, 0.3);
            Product tv = new Product("TV", 30000, 3, false, true, 15);
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
    }
}
