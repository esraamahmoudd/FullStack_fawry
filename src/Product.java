public class Product implements ShipItem {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpired;
    private boolean requiresShipping;
    private double weight;

    public Product(String Name, double Price, int Quantity, boolean isExpired,
                   boolean requiresShipping, double weight) {
        this.name = Name;
        this.price = Price;
        this.quantity = Quantity;
        this.isExpired = isExpired;
        this.requiresShipping = requiresShipping;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updatequantityaftersale(int qty) {
        this.quantity -= qty;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public boolean requiresShipping() {
        return requiresShipping;
    }

    public double getWeight() {
        if (requiresShipping) {
            return weight;
        } else {
            return 0;
        }
    }

}
