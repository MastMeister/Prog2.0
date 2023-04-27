package aufgabe05;

public class PythagoBaum1 {
    public static boolean drawRectangle(double w, double t,double g,double f){

        StdDraw.rectangle(w,t,g,f);
        if(w == w+.5)
            return true;
        return drawRectangle(w+.1,t+.1,g+.1,f+.1);
    }
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000,500);


       // drawRectangle(.4,.5,.2,.2);
        StdDraw.show(0);
        StdDraw.square(.25,0.25,.25);
        StdDraw.line(0.25,0.25,.5,.5);
        //StdDraw.
        StdDraw.setPenRadius(0.05);
        StdDraw.show(1000);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.show(1000);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
        StdDraw.show(1000);

    }


}
