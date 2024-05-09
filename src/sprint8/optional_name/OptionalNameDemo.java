package sprint8.optional_name;

import java.util.Optional;

public class OptionalNameDemo {

    static Optional<String> requestUserName() {
        //Здесь должен быть запрос к пользователю, но пока его не реализовали
        //Поместите в переменную username имя пользователя или оставьте ее пустой, если имя скрыто
        String username = "";

        if (username.isBlank()) {
            return Optional.empty();
        } else {
            return Optional.of(username);
        }
    }

    public static void main(String[] args) {
        Optional<String> maybeName = requestUserName();
        if (maybeName.isPresent()) {
            String name = maybeName.get();
            System.out.println("Привет, " + name + "!");
        } else {
            System.out.println("Ваше право не называть имя!");
        }
    }
}