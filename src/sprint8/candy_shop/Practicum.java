package sprint8.candy_shop;

import java.util.Optional;

public class Practicum {
    public static void main(String[] args) {
        // Доработайте данный метод, чтобы на экран выводилось 
        // сообщение в соответствии с заданием

        SearchService searchService = new SearchService();

        Optional<Candy> optionalCandy = searchService.search("Африка");
        if (optionalCandy.isPresent()) {
            Candy candy = optionalCandy.get();
            System.out.println("Товар " + candy.name + " доступен в количестве " + candy.amount + " кг по цене " +
                    candy.price + " руб за кг");
        } else {
            System.out.println("Данный товар не найден");
        }
    }
}