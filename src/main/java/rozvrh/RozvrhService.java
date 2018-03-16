package rozvrh;

import java.util.ArrayList;
import java.util.List;

public class RozvrhService {


    public static RozvrhItem getNextCourse(){

        return new RozvrhItem(
                "PUR",
                "14:00-15:00",
                "David Prochazka",
                "PEF",
                "Q15");

    }

    public static List<RozvrhItem> getWeekCourses(){

        List<RozvrhItem> rozvrh = new ArrayList<>();

        rozvrh.add(new RozvrhItem(
                "PUR",
                "14:00-15:00",
                "David Prochazka",
                "PEF",
                "Q15"));


        rozvrh.add(new RozvrhItem(
                "TWA",
                "16:00-18:00",
                "Hala",
                "PEF",
                "Q01"));

        return rozvrh;
    }

    public static String getScreenshot(){
        return "http://18.195.19.118/rozvrh.png";
    }

    public static String getFile(){
        return "http://18.195.19.118/rozvrh.pdf";
    }




}
