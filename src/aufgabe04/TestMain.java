package aufgabe04;

public class TestMain {
    public static void main(String[] args) {




        FrequencyTable f1 = new ArrayFrequencyTable();
        FrequencyTable f2 = new ArrayFrequencyTable();
        FrequencyTable f3 = new ArrayFrequencyTable();
        f1.add("Das");
        f1.add("Test");
        f1.add("die");
        f1.add("Test",2);
        f1.add("Buch",3);
        f1.add("zettel",2);
        f1.add("eifnach");
        f1.add("Test");
        f1.add("Test",8);
        f1.add("letzter");
        f1.add("erster",14);
        f1.add("zweiter",14);
        f1.add("Dritter",13);
        f1.collectMostFrequent(f2);
        f1.collectLeastFrequent(f3);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(System.getProperty("user.dir"));
      /*  for (int i = 0;i<f1.size();i++) {
            System.out.print(f1.get(i)+"\n");
        }
      */

       /* FrequencyTable tab1 = new ArrayFrequencyTable();
        tab1.add("das");
        tab1.add("ist");
        tab1.add("ein",2);
        tab1.add("test");
        tab1.add("test",3);
        tab1.add("O");
        tab1.add("O",2);
        tab1.add("Adasdasdasd" ,2);
        tab1.add("asdadasda");
        System.out.println(tab1.toString());

        */
/*
        System.out.println("Soll: Test:3");
        System.out.println("Ist:  " + tab1.get(0) + "\n");

        System.out.println("Soll: ein:2");
        System.out.println("Ist:  " + tab1.get(1) + "\n");

        System.out.println("Soll: 2");
        System.out.println("Ist:  " + tab1.get("ein") +  "\n");

        System.out.println("Soll: 1");
        System.out.println("Ist:  " + tab1.get("ist") +  "\n");

        System.out.println("Soll: 3");
        System.out.println("Ist:  " + tab1.get("Test") +  "\n");

        System.out.println("Soll: {Test:3, ein:2, das:1, ist:1, } size = 4");
        System.out.println("Ist:  " + tab1 +  "\n");

        System.out.println("Soll: 0");
        System.out.println("Ist:  " + tab1.get("abc") +  "\n");

*/

       /* for (int x: b) {
            System.out.println("werte b :" +x);
        }

        */

     /*   Word test = new Word("Test",2);
        d[2] = test;
        System.out.println("länge f1 : " + f1.size());
        System.out.println("länge f1 : ");
        System.out.println(b.length);

      */
       /* System.out.println("size : " + f1.size());
        f1.add("Test");
        System.out.println("f1[0] : " + f1.get(0));
        for (int i = 0;i<f1.size();i++) {
            System.out.println(f1.get(i));
        }

        */
       // System.out.println(f1.size());
        //f1.add("hallo");
        //System.out.println(f1.size());
       // System.out.println(f1.get(0).getWord());


    }
}
