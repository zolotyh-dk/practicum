package sprint9.hello_api;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response;

        // извлеките метод из запроса
        String method = httpExchange.getRequestMethod();

        switch(method) {
            case "GET":
                response = handlePostRequest(httpExchange);
                break;
            case "POST":
                response = handleGetRequest(httpExchange);
                break;
            // не забудьте про ответ для остальных методов
            default:
                response = "Некорректный метод!";
        }

        httpExchange.sendResponseHeaders(200, 0);
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private static String handleGetRequest(HttpExchange httpExchange) {
        // обработайте GET-запрос в соответствии с условиями задания
        return "Здравствуйте!";
    }

    private static String handlePostRequest(HttpExchange httpExchange) throws IOException {
        // обработайте POST-запрос в соответствии с условиями задания

        // извлеките path из запроса
        String path = httpExchange.getRequestURI().getPath();
        // а из path — профессию и имя
        String profession = path.split("/")[1];
        String name = path.split("/")[2];

        // извлеките тело запроса 
        InputStream inputStream = httpExchange.getRequestBody();
        String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        // объедините полученные данные из тела и пути запроса
        String response = body + ", " + profession + " " + name + "!";

        // извлеките заголовок и в зависимости от условий дополните ответ
        List<String> wishGoodDay = httpExchange.getRequestHeaders().get("X-Wish-Good-Day");
        // верните полученную строку ответа
        if ((wishGoodDay != null) && (wishGoodDay.contains("true"))) {
            response = response + " Хорошего дня!";
        }
        return response;
    }
}

public class Practicum {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        httpServer.stop(2);
    }
}