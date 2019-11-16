package home;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Fibonacci {
    private double a = Main.a;
    private double b = Main.b;
    private double epsilon = Main.epsilon;
    private int counter = 0;//счётчик количества вычислений функции
    private double length = 0;

    private Table table = new Table();

    double fibonacciNum(int n) {
        return 1 / sqrt(5) * (pow((1 + sqrt(5)) / 2, n) - pow((1 - sqrt(5)) / 2, n));
    }

    private int getN() {
        int n = 1;
        while (true) {
            if ((b - a) / epsilon < fibonacciNum(n + 2)) {
                counter = n;
                return n;
            } else {
                n++;
            }
        }
    }


    public int getCounter() {
        return counter;
    }

    public double getLength() {
        return length;
    }


    public double findMin() {
        double x1 = 0, x2 = 0;
        int n = getN();
        for (int k = 1; k <= n; k++) {
            counter = k;
            x1 = a + fibonacciNum(n) / fibonacciNum(n + 2) * (b - a);
            x2 = a + fibonacciNum(n + 1) / fibonacciNum(n + 2) * (b - a);
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;

            length = Math.abs(b - a);

            table.putDataInRow(counter, a, b, length, x1, x2, Main.f(x1), Main.f(x2));
        }
        table.createTable("Метод Фибоначчи");

        return Main.f((a + b) / 2);
    }
}
