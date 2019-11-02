package home;

import static java.lang.Math.sqrt;

public class GoldenSection {

    double findMin(double a, double b, double epsilon){
        double x1, x2;
        double PHI = (1 + sqrt(5))/2; //пропорция золотого сечения
        while (true){
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
            //if (Math.log((b-a)/(Main.epsilon))/(Math.log(1.618))) break;

            if (Math.abs(b - a) < epsilon) break;
        }
        return (a + b) / 2;
    }



}
