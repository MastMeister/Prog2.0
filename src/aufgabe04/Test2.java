package aufgabe04;

public class Test2 {
    public static void main(String[] args) {
       /* LinkedArrayFreqTable tab1 = new LinkedArrayFreqTable();
        LinkedArrayFreqTable tab2 = new LinkedArrayFreqTable();

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
        tab1.addAll(tab2);
        tab2.collectMostFrequent(tab1);
        System.out.println(tab2);
        tab1.collectMostFrequent(tab2);*/

        LinkedArrayFreqTable Card1 = new LinkedArrayFreqTable();
        LinkedArrayFreqTable frq = new LinkedArrayFreqTable();
        RedCard a = new RedCard();
        for(int i = 0; i<99 ; i++) {
            BlackCard b = new BlackCard();
            System.out.println(b);
        }

        Card1.collectMostFrequent(frq);
        System.out.println(frq);
    }

}
