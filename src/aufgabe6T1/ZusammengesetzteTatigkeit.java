package aufgabe6T1;

import java.util.ArrayList;
import java.util.List;

public abstract class ZusammengesetzteTatigkeit implements Tatigkeit {
    protected List<Tatigkeit> meineTatigkeiten = new ArrayList<>();

    @Override
    public double getTime() {
        return 0;
    }

    @Override
    public void add(Tatigkeit t) {
        meineTatigkeiten.add(t);
    }


    @Override
    public void remove(Tatigkeit t) {
        meineTatigkeiten.remove(t);
    }

    @Override
    public int getAnzahl() {
        int ges = 0;
        for (Tatigkeit t:meineTatigkeiten) {
            ges += t.getAnzahl();
        }
        return ges;
    }


}
