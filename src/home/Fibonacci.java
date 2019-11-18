package home;

import home.tables.Table;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Fibonacci {
    private double a = Main.a;
    private double b = Main.b;
    private int counter = 1;//счётчик итераций (первый шаг выполняется всегда)
    private int startN; //Полученное вначале количество итераций

    private Table table = new Table();

    double fibonacciNum(int n) {
        return 1 / sqrt(5) * (pow((1 + sqrt(5)) / 2, n) - pow((1 - sqrt(5)) / 2, n));
    }

    private int getN(double epsilon) {
        int n = 1;
        while (true) {
            if ((b - a) / epsilon < fibonacciNum(n + 2)) {
                startN = n;
                return n;//число вычислений функции
            } else {
                n++;
            }
        }
    }

    public int getTotalN(){ //количество вычислений функции
        return startN + 2; //2 вычисления функции до входа в цикл
    }


    public double getLength() {
        return Math.abs(b - a);
    }

    public void showTable(){
        table.createTable("Метод Фибоначчи");
    }


        public double findMin(double epsilon) {
        int n = getN(epsilon);
        double x1 = a + fibonacciNum(n) / fibonacciNum(n + 2) * (b - a);
        double x2 = a + fibonacciNum(n + 1) / fibonacciNum(n + 2) * (b - a);
        double f1 = Main.f(x1);
        double f2 = Main.f(x2);
        table.putData(counter, a, b, getLength(), x1, x2, f1, f2);
        for (int k = 1; k <= n; k++) {
            counter = k+1;
            if (f1 >= f2) {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
                f1 = f2;
                f2 = Main.f(x2);
            } else {
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
                f2 = f1;
                f1 = Main.f(x1);
            }

            table.putData(counter, a, b, getLength(), x1, x2, f1, f2);
        }

        return Main.f((a + b) / 2);
    }

}
