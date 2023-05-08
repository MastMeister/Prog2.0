package aufgabe05;

public class PythagoBaum1 {
    private static final double g = 30; // Der Winkel der Abzweigung Winkel bis 90 grad möglich theorethisch
    private static final double grueneBlaetter = 3; // Ab welcher Pixellänge der Quadrate die Blaetter gruen werden
    private static final double Anfangslaenge = 150; // Anfangslänge der Quadrate

    public static void main(String[] args) {
        //double omega = 30;
        StdDraw.setCanvasSize(1920, 1080);
        StdDraw.setXscale(0, 1920);
        StdDraw.setYscale(0, 1080);
        StdDraw.setPenRadius(.005);
        // rotiert mit winkel 30°
        StdDraw.show(0);
        PythagoB(0, Anfangslaenge, 960, 150);  // Startkoordinaten des Baumes und die Länge der Quadrate
        StdDraw.show(0);
//        test(0,100);
//        StdDraw.show(0);


    }

    private static void PythagoB(double w, double l, double ax, double ay) {
        System.out.println("Winkel :" + w + "\n Länge :" + l);
        if (l < 1)
            return;
        if (l < grueneBlaetter)
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(.005);
        double winkel = Math.toRadians(w);
        double omega = Math.toRadians(g);
        double c = l * Math.cos(winkel);
        double s = l * Math.sin(winkel);
        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - s;
        double CY = ay + s + c;
        double DX = ax - s;
        double DY = ay + c;
        double u = l * Math.cos(omega);
        double v = l * Math.sin(omega);
        double EX = DX + u * (Math.cos(winkel + omega));
        double EY = DY + u * Math.sin(winkel + omega);

        //StdDraw.line(ax, ay, BX, BY);
        StdDraw.line(ax, ay, DX, DY);
        //StdDraw.line(CX, CY, DX, DY);
        StdDraw.line(CX, CY, BX, BY);
//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(AX,AY);
//        StdDraw.point(BX,BY);
//        StdDraw.setPenRadius(.009);
//        StdDraw.setPenColor(StdDraw.BOOK_RED);
//        StdDraw.point(EX,EY);
        PythagoB(w - (90 - g), v, EX, EY); // Baut die Abzweigung nach rechts
        PythagoB(w + g, u, DX, DY);        // Baut den Ast weiter

    }
//    private static void test2(double w, double l,double ax,double ay){
//        test(w-90,l,ax,ay);
//    }


}
