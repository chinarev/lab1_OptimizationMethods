package home;

import static java.lang.Math.sqrt;

public class GoldenRatio {
    private int counter;//счётчик количества вычислений функции
    private double length;

    public GoldenRatio() {
        counter = 0;
        length = 0;
    }

    public int getCounter() {
        return counter;
    }

    public double getLength() {
        return length;
    }

    double findMin() {
        double epsilon = Main.epsilon;
        double a = Main.a;
        double b = Main.b;
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
        length = Math.abs(b-a);
        return Main.f((a + b) / 2);
    }
}
