package rozvrh;

import java.util.ArrayList;
import java.util.List;

public class RozvrhService {


    RozvrhItem getNextCourse(){

        return new RozvrhItem(
                "PUR",
                "14:00-15:00",
                "David Prochazka",
                "PEF",
                "Q15");

    }

    List<RozvrhItem> getWeekCourses(){


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





}
