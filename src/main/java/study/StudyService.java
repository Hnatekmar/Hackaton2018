package study;

import jidlo.JidloItem;

import java.util.ArrayList;
import java.util.List;

public class StudyService {




    public static StudyItem getStudijni(){

       return new StudyItem("Oteviraci doba studijniho oddelni","Pondeli 11:00 - 12:00");

    }

    public static StudyItem getIsic(){

        return new StudyItem("Platnost ISIC","20.1.2019");

    }

    public static List<StudyItem> getOdevzdavarny(){
        ArrayList<StudyItem> array = new ArrayList<>();

        array.add(new StudyItem("PUR semestrálka","17.1.2015"));
        array.add(new StudyItem("PUR ukol","17.6.2015"));
        array.add(new StudyItem("PTN test","11.6.2020"));
        return array;

    }


}
