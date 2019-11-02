package home;

import static java.lang.Math.sqrt;

public class GoldenSection {

    double findMin(double a, double b, double epsilon) {
        double x1, x2;
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения
        while (true) {
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


    // вариант по заданию
    double findMin2(double a, double b, double epsilon) {
        double x1, x2;
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения
        int n = (int) Math.round(Math.log((b - a) / (epsilon)) / (Math.log(1.618)));
        for (int i = 0; i < n; i++) {
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
        }
        return (a + b) / 2;
    }
}
