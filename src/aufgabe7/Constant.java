package aufgabe7;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression{
    private double aDouble;

    public Constant(double d){

        aDouble = d;
    }
    @Override
    public double eval(Map<String,Double> map) {
        return aDouble;
    }

    @Override
    public Set getVars() {
        Set s = new TreeSet();
        return s;
    }
    @Override
    public String toString(){

        return String.valueOf(aDouble);
    }
}
