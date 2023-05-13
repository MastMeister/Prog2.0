package aufgabe7;

import java.util.Map;
import java.util.Set;

public class Constant implements Expression{
    private double aDouble;

    public Constant(double d){

        aDouble = d;
    }
    @Override
    public double eval(Map<String,Double> map) {
        return 0;
    }

    @Override
    public Set getVars() {
        return null;
    }
}
