package sprint9.http_server_1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

class PostsHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // получите информацию об эндпоинте, к которому был запрос
        String requestMethod = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        Endpoint endpoint = getEndpoint(path, requestMethod);


        switch (endpoint) {
            case GET_POSTS: {
                writeResponse(exchange, "Получен запрос на получение постов", 200);
                break;
            }
            case GET_COMMENTS: {
                writeResponse(exchange, "Получен запрос на получение комментариев", 200);
                break;
            }
            case POST_COMMENT: {
                writeResponse(exchange, "Получен запрос на добавление комментария", 200);
                break;
            }
            default:
                writeResponse(exchange, "Такого эндпоинта не существует", 404);
        }
    }

    private Endpoint getEndpoint(String requestPath, String requestMethod) {
        Map<String, Endpoint> endpointMap = new HashMap<>();

        endpointMap.put("POST/posts/comments", Endpoint.POST_COMMENT);
        endpointMap.put("GET/posts", Endpoint.GET_POSTS);
        endpointMap.put("GET/posts/comments", Endpoint.GET_COMMENTS);

        String key = requestMethod + "/" + requestPath;
        return endpointMap.getOrDefault(key, Endpoint.UNKNOWN);
    }

    private void writeResponse(HttpExchange exchange,
                               String responseString,
                               int responseCode) throws IOException {
            /*
             Реализуйте отправку ответа, который содержит responseString в качестве тела ответа
             и responseCode в качестве кода ответа.
             Учтите, что если responseString — пустая строка, то её не нужно передавать в ответе.
             В этом случае ответ отправляется без тела.
             */
        exchange.sendResponseHeaders(responseCode, 0);
        if (!responseString.isEmpty()) {
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseString.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    enum Endpoint {GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN}
}

public class Practicum {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        // добавьте код для конфигурирования и запуска сервера
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/posts", new PostsHandler());
        httpServer.start();

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
        // завершаем работу сервера для корректной работы тренажёра
        httpServer.stop(1);
    }
}