package home;

import static java.lang.Math.sqrt;

public class GoldenRatio {
    private int counter;//счётчик количества вычислений функции

    public GoldenRatio(){
        counter = 0;
    }

    public int getCounter(){
        return counter;
    }

    double findMin(double a, double b, double epsilon) {
        double x1, x2;
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения
        while (Math.abs(b - a) > epsilon) {
            counter++;
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
        }
        return Main.f((a + b) / 2);
    }
}
