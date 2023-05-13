package aufgabe6T1;

public class TestMain {
    public static void main(String[] args) {
//        Tatigkeit tk3 = new ParalleleTatigkeit();
//        tk3.add(new ElementareTatigkeit("Test",4.0));
        Tatigkeit tk1 = new ParalleleTatigkeit();
        tk1.add(new ElementareTatigkeit("Linke Seitenwand montieren", 5.0));
        tk1.add(new ElementareTatigkeit("Rechte Seitenwand montieren", 5.0));
        Tatigkeit tk2 = new ParalleleTatigkeit();
        tk2.add(new ElementareTatigkeit("Linke Türe montieren", 7.0));
        tk2.add(new ElementareTatigkeit("Rechte Türe mit Griff montieren", 9.0));
        Tatigkeit schrankMontage = new SerielleTatigkeit();
        schrankMontage.add(new ElementareTatigkeit("Füße an Boden montieren", 6.0));
        schrankMontage.add(tk1);
        schrankMontage.add(new ElementareTatigkeit("Decke montieren", 8.0));
        schrankMontage.add(tk2);
        System.out.println(schrankMontage.getTime() + " min"); // 28.0 min
        System.out.println(schrankMontage.getAnzahl()); // 6


    }
}


