import java.util.*;

public class ShippingService {
    public static double ship(List<ShipItem> items) {
        if (items.isEmpty()) return 0;

        System.out.println("** Shipment notice **");

        Map<String, Integer> itemCounts = new HashMap<>();
        double totalWeight = 0;

        for (ShipItem item : items) {
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
            totalWeight = totalWeight+item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }

        System.out.println("Total package weight: " + String.format("%.1f", totalWeight) + " kg");
        return 30;
    }
}
