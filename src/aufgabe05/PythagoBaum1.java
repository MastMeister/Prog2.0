package aufgabe05;

public class PythagoBaum1 {
    public static double g = 10;

    public static void main(String[] args) {
        double omega = 30;
        StdDraw.setCanvasSize(888,500);
        StdDraw.setXscale(0 ,888);
        StdDraw.setYscale(0,500);
        StdDraw.setPenRadius(.005);
        // rotiert mit winkel 30°
       StdDraw.show(0);
       int i = 3;

       test(0,100,500,50);
       StdDraw.show(0);
//        test(0,100);
//        StdDraw.show(0);


    }
    private static void test(double w, double l,double ax,double ay){
        System.out.println("Winkel :" + w+"\n Länge :" + l);
        if(l< 5)
            return;
        if(l < 12 )
            StdDraw.setPenColor(StdDraw.GREEN);
        else
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(.005);
        double winkel = Math.toRadians(w);
        double omega = Math.toRadians(g);
        double lange = l;
        double AX = ax;
        double AY = ay;
        double c = lange * Math.cos(winkel);
        double s = lange * Math.sin(winkel);
        double BX = AX + c;
        double BY = AY + s;
        double CX = AX + c - s;
        double CY = AY + s + c;
        double DX = AX - s;
        double DY = AY + c;
        double u = lange*Math.cos(omega );
        double v = lange*Math.sin(omega );
        double EX = DX + u*(Math.cos(winkel + omega));
        double EY = DY + u*Math.sin(winkel + omega);

        StdDraw.line(AX, AY, BX, BY);
        StdDraw.line(AX, AY, DX, DY);
        StdDraw.line(CX, CY, DX, DY);
        StdDraw.line(CX, CY, BX, BY);
//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(AX,AY);
//        StdDraw.point(BX,BY);
        StdDraw.setPenRadius(.009);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.point(EX,EY);

            test(w+g,u ,DX,DY);
            test(w-(90 - g),v ,EX,EY);
    }
//    private static void test2(double w, double l,double ax,double ay){
//        test(w-90,l,ax,ay);
//    }


}
