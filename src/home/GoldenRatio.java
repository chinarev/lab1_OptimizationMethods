package home;

import static java.lang.Math.sqrt;

public class GoldenRatio {
    private double epsilon = Main.epsilon;
    private double a = Main.a;
    private double b = Main.b;
    private int counter = 0;//счётчик количества вычислений функции
    private double length = 0;

    private Table table = new Table();

    public int getCounter() {
        return counter;
    }

    public double getLength() {
        return length;
    }


    double findMin() {
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения

        double x1 = b - (b - a) / PHI;
        double x2 = a + (b - a) / PHI;
        double f1 = Main.f(x1);
        double f2 = Main.f(x2);
        while (Math.abs(b - a) > epsilon) {
            counter++;
            if (f1 >= f2) {
                a = x1;
                x1 = x2;
                f1 = f2;
                x2 = a + (b - a) / PHI;
                f2 = Main.f(x2);
            }
            else {
                b = x2;
                x2 = x1;
                f2 = f1;
                x1 = b - (b - a) / PHI;
                f1 = Main.f(x1);
            }

            length = Math.abs(b - a);

            table.putData(counter, a, b, length, x1, x2, Main.f(x1), Main.f(x2));
        }
        table.createTable("Метод золотого сечения");

        return Main.f((a + b) / 2);
    }
}
