package aufgabe7;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public abstract class CompoundExpression implements Expression{

    Expression a;
    Expression b;
    protected double opera1;
    protected double opera2;
    @Override
    public double eval(Map<String , Double> map) {
     return 0;
    }

    @Override
    public Set getVars() {
        Set s = new TreeSet();
        s.addAll(a.getVars());
        s.addAll(b.getVars());

        return s ;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append(a.toString());
        s.append(b.toString());
        s.append(")");

        return s.toString();
    }
}
