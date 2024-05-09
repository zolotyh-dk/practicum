package sprint5.practicum;

import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {

    public static void main(String[] args) {
        AnswerHolder<Number> elephantAnswer = new AnswerHolder<>("Сколько весит слон в тоннах", 5);
        elephantAnswer.printSmart();

        HashMap<String, Double> bigRussianEncyclopedia = new HashMap<>();
        bigRussianEncyclopedia.put("Сколько часов в сутках", (double) 24);
        bigRussianEncyclopedia.put("Сколько весит слон в тоннах", 4.3);

        elephantAnswer.replaceAnswer(bigRussianEncyclopedia);
        elephantAnswer.printSmart();

        HardQuestion elephantVolumeQuestion = new HardQuestion("Как вычислить объём слона с помощью подручных средств?");
        elephantVolumeQuestion.printSmart();

        ArrayList<SmartPrintable> printables = new ArrayList<>();
        printables.add(elephantAnswer);
        printables.add(elephantVolumeQuestion);
        System.out.println("Всё, что можно распечатать: ");
        print(printables);

        ArrayList<AnswerHolder<Number>> answers = new ArrayList<>();
        answers.add(elephantAnswer);
        System.out.println("Лучшие ответы на вопросы: ");
        print(answers);
    }

    static void print(ArrayList<? extends SmartPrintable> values) {
        for (SmartPrintable value : values) {
            value.printSmart();
        }
    }
}

interface SmartPrintable {
    void printSmart();
}

class AnswerHolder<T extends Number> implements SmartPrintable {
    String question;
    T answer;

    public AnswerHolder(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public void replaceAnswer(HashMap<String, ? extends T> map) {
        //метод должен замещать значение answer значением, полученным из аргумента - хеш-таблицы, для данного вопроса
        answer = map.get(question);
    }

    @Override
    public void printSmart() {
        System.out.println("Ответ на вопрос '" + question + "' равен " + answer.intValue());
    }
}

class HardQuestion implements SmartPrintable {
    String questionText;

    public HardQuestion(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public void printSmart() {
        System.out.println("Текст очень сложного вопроса: " + questionText);
    }
}