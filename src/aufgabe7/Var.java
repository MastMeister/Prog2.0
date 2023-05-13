package aufgabe7;

import java.util.Map;
import java.util.Set;

public class Var implements Expression{

    private String var ;

    public Var(String s){

        var = s;

    }

    @Override
    public double eval(Map<Var, Double> map) {
        return 0;
    }

    @Override
    public Set getVars() {
        return null;
    }
}
