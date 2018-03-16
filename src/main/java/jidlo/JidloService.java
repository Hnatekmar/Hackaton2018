package jidlo;

import java.util.ArrayList;
import java.util.List;

public class JidloService {


    public static List<JidloItem> getJidlo(){


        ArrayList<JidloItem> array = new ArrayList<>();

        array.add(new JidloItem("Pizza","22 Kc"));
        array.add(new JidloItem("Mrkev","20 Kc"));

        return array;

    }





}
