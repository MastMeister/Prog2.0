package aufgabe7;

import java.util.Map;

public class Difference extends CompoundExpression{
    public Difference(Expression at , Expression av){;
        this.a = at;
        this.b = av;
    }

    @Override
    public double eval(Map<String,Double> map){
        opera1 = a.eval(map);
        opera2 = b.eval(map);

        return opera1 - opera2;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append(a.toString());
        s.append("-");
        s.append(b.toString());
        s.append(")");

        return s.toString();
    }
}
