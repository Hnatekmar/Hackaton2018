package jidlo;

import java.util.List;

public class JidloDay {

    String dayName;

    List<JidloItem> food;


    public JidloDay(String dayName, List<JidloItem> food) {
        this.dayName = dayName;
        this.food = food;
    }


    public String getDayName() {
        return dayName;
    }

    public List<JidloItem> getFood() {
        return food;
    }
}
