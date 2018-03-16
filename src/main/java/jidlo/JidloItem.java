package jidlo;

public class JidloItem {

    String name;

    String cena;

    public JidloItem(String name, String cena) {
        this.name = name;
        this.cena = cena;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
