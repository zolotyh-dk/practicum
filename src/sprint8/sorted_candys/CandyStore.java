package sprint8.sorted_candys;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

class Candy {
    final String name;
    final String producer;
    final int price;
    final int amountSold;
    final Set<String> alternateNames;

    public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.amountSold = amountSold;
        this.alternateNames = Set.copyOf(alternateNames);
    }

    public static int compareByName(Candy c1, Candy c2) {
        return c1.name.compareTo(c2.name);
    }

    public static int compareByPrice(Candy c1, Candy c2) {
        return c1.price - c2.price;
    }

    public void printNameWithPrice() {
        System.out.println(name + ": " + price);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amountSold=" + amountSold +
                ", alternateNames=" + alternateNames +
                '}';
    }
}
   
public class CandyStore {
    public static void main(String[] args) {
        Candy candy1 = new Candy("Мишка на севере", "Первая кондитерская фабрика", 28, 4, Set.of("Мишка косолапый", "Мишка"));
        Candy candy2 = new Candy("Мишка в лесу", "Триумф", 32, 2, Set.of("Мишка косолапый"));
        Candy candy3 = new Candy("Трюфель", "Триумф", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный"));
        Candy candy4 = new Candy("Победа", "Первая кондитерская фабрика", 14, 12, Set.of("ПОБЕДА"));

        Candy[] candies = {candy1, candy2, candy3, candy4};

        System.out.println("Сортировка по имени");
        Arrays.sort(candies, Candy::compareByName);
        Arrays.stream(candies).forEach(Candy::printNameWithPrice);

        System.out.println("Сортировка по цене");
        Arrays.sort(candies, Candy::compareByPrice);
        Arrays.stream(candies).forEach(Candy::printNameWithPrice);
    }
}