package sprint5.new_year;

// Дополните объявление класса Contact
public abstract class Contact {
    // Класс должен содержать одно полe - имя пользователя name
    String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // И два метода - sendMessage() для отправки сообщения и print() для печати информации о контакте
    abstract void sendMessage();

    abstract void print();
}