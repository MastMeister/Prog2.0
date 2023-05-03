package aufgabe05;

public class PythagoBaum2 {
    //private static double g = 45; // Der Winkel der Abzweigung Winkel bis 90 grad möglich theorethisch
    // Skaliert die länge der Äste in abhängigkeit der dicke/breite
    public static final double skalierung = 3.0;
    public static final double anfangsBreite = 100;
    public static final double anfangshoehe = 150;


    public static void main(String[] args) {
        StdDraw.setCanvasSize(1920,1080); // Fenstergröße einstellen
        StdDraw.setXscale(0 ,1920);
        StdDraw.setYscale(0,1080);
        StdDraw.setPenRadius(.005);
        // rotiert mit winkel 30°
        StdDraw.show(0);

        test(0,anfangsBreite,anfangshoehe,960,50);  // Startkoordinaten des Baumes und die Länge der Quadrate
        StdDraw.show(0);
//        test(0,100);
//        StdDraw.show(0);


    }
    private static void test(double w, double laenge,double he,double ax,double ay){
        double g = (int) ((Math.random() *76)+10);
        System.out.println("Winkel :" + w+"\n Länge :" + laenge);
        if(laenge< 2 ) {
            return;
        }
        if(laenge < 5 )
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(.005);
        double winkel = Math.toRadians(w);
        double omega = Math.toRadians(g);
        double c = laenge * Math.cos(winkel);
        double s = laenge * Math.sin(winkel);
        double ch = he * Math.cos(winkel);
        double sh = he * Math.sin(winkel);
        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - sh;
        double CY = ay + s + ch;
        double DX = ax - sh;
        double DY = ay + ch;
        double u = laenge *Math.cos(omega );
        double v = laenge *Math.sin(omega );
        double EX = DX + u*(Math.cos(winkel + omega));
        double EY = DY + u*Math.sin(winkel + omega);

       // StdDraw.line(AX, AY, BX, BY); // Ausgabe nicht erwwünscht
        StdDraw.line(ax, ay, DX, DY);
       // StdDraw.line(CX, CY, DX, DY); // Ausgabe nicht erwünscht
        StdDraw.line(CX, CY, BX, BY);

//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(AX,AY);
//        StdDraw.point(BX,BY);
//        StdDraw.setPenRadius(.009);
//        StdDraw.setPenColor(StdDraw.BOOK_RED);
//        StdDraw.point(EX,EY);
        double h = (int) (Math.random() *(skalierung*laenge)+1);
        test(w+g ,u ,h,DX,DY);
        test(w-(90 - g),v,h,EX,EY);

    }
//    private static void test2(double w, double l,double ax,double ay){
//        test(w-90,l,ax,ay);
//    }


}
