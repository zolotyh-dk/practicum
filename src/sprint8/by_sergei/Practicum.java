package sprint8.by_sergei;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Practicum {
    static class Order {
        Set<Package> packages;
    }
    
    static class Package {
        Set<Item> items;
    }
    
    static class Item {
       Double weight;
       Double x; 
       Double y; 
       Double z;
       Integer amount;
    }
    
    private static Integer getItemsSumByCycles(Order order) {
        int itemsSum = 0;
        if (order == null || order.packages == null) {
            return itemsSum;
        }
        for (Package pack : order.packages) {
            if (pack != null && pack.items != null) {
                for (Item item : pack.items) {
                    if (item.amount != null) {
                        itemsSum += item.amount;
                    }
                }
            }
        }
        return itemsSum;
    }

    private static Integer getItemSumByStreams(Order order) {
        if (order == null || order.packages == null) {
            return 0;
        }
        return order.packages.stream()
                .filter(pack -> pack != null && pack.items != null)
                .flatMap(pack -> pack.items.stream())
                .filter(Objects::nonNull)
                .mapToInt(item -> item.amount != null ? item.amount : 0)
                .sum();
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.amount = 30;

        Item item2 = new Item();
        item2.amount = 15;

        Item item3 = new Item();
        item3.amount = 5;

        Item item4 = new Item();
        item4.amount = 20;

        Package pack1 = new Package();
        pack1.items = new HashSet<>();
        pack1.items.add(item1);
        pack1.items.add(item2);

        Package pack2 = new Package();
        pack2.items = new HashSet<>();
        pack2.items.add(item3);
        pack2.items.add(item4);

        Order order = new Order();
        order.packages = new HashSet<>();
        order.packages.add(pack1);
        order.packages.add(pack2);

        // Вызываем оба метода и выводим результаты
        System.out.println("Total item sum using getItemsSum method: " + getItemsSumByCycles(order));
        System.out.println("Total item sum using getItemSum method: " + getItemSumByStreams(order));
    }
}
