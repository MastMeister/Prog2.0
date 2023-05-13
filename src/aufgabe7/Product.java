package aufgabe7;

import java.util.Map;

public class Product extends CompoundExpression{

    public Product(Expression sum1, Expression sum2){
        a = sum1;
        b = sum2;

    }
    @Override
    public double eval(Map<String,Double> map){
        opera1 = a.eval(map);
        opera2 = b.eval(map);

        return opera1 * opera2;
    }
    @Override
    public String toString(){
        String s = "(" +
                a.toString() +
                "*" +
                b.toString() +
                ")";

        return s;
    }
}
