package aufgabe6T1;

public class ElementareTatigkeit implements Tatigkeit{

    public ElementareTatigkeit(String b, double t){
        time = t;
        beschr = b;
    }

    private double time;

    private String beschr;

    public double getTime() {
        return time;
    }

    @Override
    public void add(Tatigkeit t) {

    }

    @Override
    public void remove(Tatigkeit t) {

    }

    @Override
    public int getAnzahl() {
        return 1;
    }

    public String getBeschr() {
        return beschr;
    }

    private void setBeschr(String beschr) {
        this.beschr = beschr;
    }
}
