package aufgabe6T2;

public class Buch {
    public Buch(String n){
        name = n;
    }
    private String name;
    private Person entleiher = null;

    public Person getEntleiher() {
        return entleiher;
    }

    public void setEntleiher(Person entleiher) {
        this.entleiher = entleiher;
    }

    public boolean wirdAusgeliehen(Person p){
        if(entleiher != null)
            return false;

       p.leihtAus(this);
        return true;
    }

    public  boolean wirdZurueckGegeben(){
        if(entleiher != null) {
            this.entleiher.gibtZurueck(this);
            entleiher = null;
            return true;
        }
        return false;

    }
    public void print(){
        System.out.print(getName()+ " wurde ausgeliehen von : ");
        if(entleiher != null)
        System.out.print(getEntleiher().getName()+" \n");
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
