package aufgabe6T2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public Person(String n){
        name = n;
    }
    private String name;
    private List<Buch> ausgelieheneBuecher = new ArrayList<>();

    public String getName() {
        return name;
    }

    public boolean leihtAus(Buch b){
       if(b.getEntleiher()== null){
           ausgelieheneBuecher.add(b);
           b.setEntleiher(this);
           return true;
       }
       return false;
    }

    public boolean gibtZurueck(Buch b){
        if(ausgelieheneBuecher.contains(b)) {
            ausgelieheneBuecher.remove(b);
            b.wirdZurueckGegeben();
            return true;
        }
        else return false;
    }

    public void print(){
        System.out.print(getName()+" Hat ausgeliehen : ");
        for (Buch b: ausgelieheneBuecher) {
            System.out.print(b.getName()+", ");
        }
        System.out.println();

    }
}
