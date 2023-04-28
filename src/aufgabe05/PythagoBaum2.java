package aufgabe05;
import java.util.Random;

public class PythagoBaum2 {
    //private static double g = 45; // Der Winkel der Abzweigung Winkel bis 90 grad möglich theorethisch
    public static final double SkalierungDickeLaenge = 3.0;

    public static void main(String[] args) {
        double omega = 30;
        StdDraw.setCanvasSize(1920,1080);
        StdDraw.setXscale(0 ,1920);
        StdDraw.setYscale(0,1080);
        StdDraw.setPenRadius(.005);
        // rotiert mit winkel 30°
        StdDraw.show(0);

        test(0,100,150,960,50);  // Startkoordinaten des Baumes und die Länge der Quadrate
        StdDraw.show(0);
//        test(0,100);
//        StdDraw.show(0);


    }
    private static void test(double w, double l,double he,double ax,double ay){
        double g = (int) ((Math.random() *76)+10);
        System.out.println("Winkel :" + w+"\n Länge :" + l);
        if(l< 2 ) {
            return;
        }
        if(l < 5 )
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(.005);
        double winkel = Math.toRadians(w);
        double omega = Math.toRadians(g);
        double lange = l;
        double hoehe = he;
        double AX = ax;
        double AY = ay;
        double c = lange * Math.cos(winkel);
        double s = lange * Math.sin(winkel);
        double ch = hoehe* Math.cos(winkel);
        double sh = hoehe* Math.sin(winkel);
        double BX = AX + c;
        double BY = AY + s;
        double CX = AX + c - sh;
        double CY = AY + s + ch;
        double DX = AX - sh;
        double DY = AY + ch;
        double u = lange*Math.cos(omega );
        double v = lange*Math.sin(omega );
        double EX = DX + u*(Math.cos(winkel + omega));
        double EY = DY + u*Math.sin(winkel + omega);

       // StdDraw.line(AX, AY, BX, BY);
        StdDraw.line(AX, AY, DX, DY);
       // StdDraw.line(CX, CY, DX, DY);
        StdDraw.line(CX, CY, BX, BY);

//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(AX,AY);
//        StdDraw.point(BX,BY);
//        StdDraw.setPenRadius(.009);
//        StdDraw.setPenColor(StdDraw.BOOK_RED);
//        StdDraw.point(EX,EY);
        double h = (int) (Math.random() *(SkalierungDickeLaenge*l)+1);
        test(w+g ,u ,h,DX,DY);
        test(w-(90 - g),v,h,EX,EY);

    }
//    private static void test2(double w, double l,double ax,double ay){
//        test(w-90,l,ax,ay);
//    }


}
