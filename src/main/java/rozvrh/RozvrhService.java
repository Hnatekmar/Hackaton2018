package rozvrh;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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



    public static ArrayList<RozvrhItem> getAllCourses(String filePath) {
        ArrayList <RozvrhItem> result = new ArrayList <RozvrhItem> ();
        Scanner scan = null;
        try {
            File f  = new File(filePath);
            scan = new Scanner(new File(filePath), "windows-1252");

          } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            if(lineArray.length > 6 )
                result.add(new RozvrhItem(
                        lineArray[3],
                        lineArray[1] + " - " + lineArray[2],
                        lineArray[6],
                        lineArray[3],
                        lineArray[5]));
        }
        return result;
    }


//    public static void main(String[] args) {
//        System.out.println(filterAllCoursesTeacher("pavel").size());
//
////        for (RozvrhItem rozvrhItem : getAllCourses("data1.csv")) {
//////            System.out.println(rozvrhItem);
////
////        }
//    }

    public static ArrayList<RozvrhItem> filterAllCoursesRoom(String value) {
        ArrayList <RozvrhItem> filtered = new ArrayList <RozvrhItem> ();

        ArrayList <RozvrhItem> data = getAllCourses("data1.csv");

        for (RozvrhItem item : data) {

            if(item.getRoom().toLowerCase().contains(value.toLowerCase()) || value.equalsIgnoreCase(item.getRoom())){
                filtered.add(item);
            }

       }

        System.out.println("resultr size"+filtered.size());

        return filtered;
    }


    public static ArrayList<RozvrhItem> filterAllCoursesTeacher(String value) {
        ArrayList <RozvrhItem> filtered = new ArrayList <RozvrhItem> ();

        ArrayList <RozvrhItem> data = getAllCourses("data1.csv");

        for (RozvrhItem item : data) {

            if(item.getTeacher().toLowerCase().contains(value.toLowerCase())){
                filtered.add(item);
            }

        }

        System.out.println("resultr size"+filtered.size());


        return filtered;
    }




}
