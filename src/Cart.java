import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.getQuantity()) {
            throw new Exception("quantity not available in stock.");
        }
        items.add(new CartItem(product, quantity));
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getsumofoprice).sum();
    }
    public List<ShipItem> getShippableItems() {
        List<ShipItem> result = new ArrayList<>();

        for (CartItem cartItem : items) {
            Product p = cartItem.getProduct();

            if (p.requiresShipping()) {
                int qty = cartItem.getQuantity();

                for (int i = 0; i < qty; i+=1) {
                    result.add(p);
                }
            }
        }

        return result;
    }
}