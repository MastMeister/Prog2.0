package aufgabe7;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class CompoundExpression implements Expression{
    @Override
    public double eval(Map<String , Double> map) {

        return 0;
    }

    @Override
    public Set getVars() {
        Set s = new TreeSet<>();

        return null ;
    }
}
