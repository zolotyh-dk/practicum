package sprint6.random_coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    // Random — класс в Java, отвечающий за генерацию случайных элементов.
    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */

    // Укажите правильный тип, возвращаемый этой функцией. Вам нужно преобразовать список незнакомцев в 
    // набор пар, т.е. в список, состоящий из других списков.
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        // Укажите тип ещё раз.
        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {
            List<Stranger> pair = getRandomPair(strangers);
            // Добавьте новый элемент в набор пар.
            pairs.add(pair);
        }

        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        // Генерируем два случайных индекса в пределах списка
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        // Получаем элементы по сгенерированным индексам
        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);
        List<Stranger> pair = List.of(strangerOne, strangerTwo);
        /* Осталось только удалить двух найденных незнакомцев из списка strangers, 
           а затем вернуть их в качестве результата! */
        strangers.removeAll(pair);
        return pair;
    }
}