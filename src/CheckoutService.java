import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("your cart is empty -_-");
        }

        List<CartItem> items = cart.getItems();
        for (CartItem item : items) {
            Product product = item.getProduct();
            int needed = item.getQuantity();
            int available = product.getQuantity();

            if (product.isExpired()) {
                System.out.println( product.getName() + " is expired and was removed from the order.");
                continue;
            }

            if (needed > available) {
                throw new Exception(product.getName() + " is out of stock.");
            }
        }

        double subtotal = cart.getSubtotal();
        double shipping = ShippingService.ship(cart.getShippableItems());
        double total = subtotal + shipping;

        if (!customer.enoughmoney(total)) {
            throw new Exception("your balance not enough -_-");
        }


        for (CartItem item : cart.getItems()) {
            item.getProduct().updatequantityaftersale(item.getQuantity());
        }

        customer.pay(total);


        System.out.println("** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            int qty = item.getQuantity();
            String name = item.getProduct().getName();
            double price = item.getProduct().getPrice();

            System.out.printf("%d x %s %.0f\n", qty, name, price);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal       : " + (int)subtotal);
        System.out.println("Shipping Fee   : " + (int)shipping);
        System.out.println("Total Amount   : " + (int)total);
        System.out.println("Balance Left   : " + (int)customer.getBalance());

    }
}