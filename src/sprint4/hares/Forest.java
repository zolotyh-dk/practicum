package sprint4.hares;

import java.util.ArrayList;

public class Forest {
private ArrayList<MountainHare> hares;
private String season;

    public Forest(ArrayList<MountainHare> hares, String season) {
        this.hares = hares;
        setSeason(season);
    }

    public void setSeason(String newSeason) {
        season = newSeason;
        switch (season) {
            case "зима":
                MountainHare.color = "белый";
                break;
            case "лето":
                MountainHare.color = "серо-рыжий";
        }
    }

    public void printHares() {
        hares.forEach(System.out::println);
    }
}