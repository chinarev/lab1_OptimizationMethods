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
        double x1 = 0, x2 = 0;
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения
        while (Math.abs(b - a) > epsilon) {
            counter++;
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;

            length = Math.abs(b - a);

            table.putDataInRow(counter, a, b, length, x1, x2, Main.f(x1), Main.f(x2));
        }
        table.createTable("Метод золотого сечения");

        return Main.f((a + b) / 2);
    }
}
