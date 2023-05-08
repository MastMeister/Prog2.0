package aufgabe6T1;

public class SerielleTatigkeit extends ZusammengesetzteTatigkeit{

   @Override
    public double getTime() {
        double tGes = 0;
        for (Tatigkeit t: meineTatigkeiten) {
            tGes += t.getTime();
        }

        return tGes;
    }

}
