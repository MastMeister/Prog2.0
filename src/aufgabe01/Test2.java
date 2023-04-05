package aufgabe01;

public class Test2 {
    public static void main(String[] args) {
        LinkedArrayFreqTable tab1 = new LinkedArrayFreqTable();

        tab1.add("g");
        tab1.add("a");
        tab1.add("hallo",3);
        tab1.add("hey",4);
        tab1.add("f",2);
        tab1.add("jo",5);
        tab1.add("jo",3);
        tab1.add("jes",2);
        tab1.add("Es klappt",2);
        tab1.add("fünf");
        tab1.add("fünf",5);
       // tab1.clear();
        System.out.println(tab1);

      //  tab1.add("HeyHo",5);
      //  tab1.add("asdasd");
      //  tab1.add("hey",2);
      //  tab1.add("test2",4);

        System.out.println(tab1);
       // System.out.println(tab1.get("hallo"));
        System.out.println(tab1.size());
       // System.out.println(tab1);
    }
}
