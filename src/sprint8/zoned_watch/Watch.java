package sprint8.zoned_watch;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

class Watch {
    private ZonedDateTime currentTime;
    private int numOfZone;
    private final List<String> zones = Arrays.asList("America/New_York", "Asia/Vladivostok", "Europe/Moscow");

    public Watch() {
        numOfZone = 0;
        ZoneId zone = ZoneId.of(zones.get(numOfZone));
        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 0, 0);
        currentTime = ZonedDateTime.of(dateTime, zone);
    }

    public void changeTimeZone() {
        numOfZone = (numOfZone == zones.size() - 1) ? 0 : numOfZone + 1;
        ZoneId newZone = ZoneId.of(zones.get(numOfZone));
        // смените временную зону (время должно остаться прежним)
        currentTime = currentTime.withZoneSameLocal(newZone);
    }

    public void addTenHours() {
        // увеличьте текущее время на 10 часов
        currentTime = currentTime.plusHours(10);
    }

    public void addHour() {
        // увеличьте текущее время на 1 час
        currentTime = currentTime.plusHours(1);
    }

    public void addTenMinutes() {
        // увеличьте текущее время на 10 минут
        currentTime = currentTime.plusMinutes(10);
    }

    public void addMinute() {
        // увеличьте текущее время на 1 минуту
        currentTime = currentTime.plusMinutes(1);
    }

    public ZonedDateTime getCurrentTime() {
        // верните текущее время
        return currentTime;
    }
}

class Practicum {
    public static void main(String[] args) {
        Watch watch = new Watch();

        // настройка часов
        while (!watch.getCurrentTime().getZone().equals(ZoneId.of("Europe/Moscow"))) {
            watch.changeTimeZone();
        }

        while (watch.getCurrentTime().getHour() != 18) {
            watch.addHour();
        }

        while (watch.getCurrentTime().getMinute() != 26) {
            watch.addMinute();
        }

        System.out.println(watch.getCurrentTime());
    }
}