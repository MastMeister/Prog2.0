package aufgabe6T1;

public class ParalleleTatigkeit extends ZusammengesetzteTatigkeit{
    public ParalleleTatigkeit(){

    }
    @Override
    public double getTime() {
        double tMax = 0;
        for (Tatigkeit t:meineTatigkeiten) {
            if(t.getTime()> tMax)
                tMax = t.getTime();
        }
        return tMax;
    }
}
