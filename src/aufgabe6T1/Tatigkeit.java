package aufgabe6T1;

public interface Tatigkeit {

    double getTime();

    void add(Tatigkeit t);

    void remove(Tatigkeit t);

    int getAnzahl();
}
