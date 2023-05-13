package aufgabe7;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Var implements Expression{

    private String var ;

    public Var(String s){

        var = s;

    }

    @Override
    public double eval(Map<String, Double> map) {
        return map.get(var);
    }

    @Override
    public Set getVars() {
        Set s = new TreeSet();
        s.add(var);
        return s;
    }
}
