package home;

import home.tables.Table;

import static java.lang.Math.sqrt;

public class GoldenRatio {
    private double a = Main.a;
    private double b = Main.b;
    private int counter = 1;//счётчик итераций (первый шаг выполняется всегда)

    private Table table = new Table();

    public int getCounter() {
        return counter;
    }

    public double getLength() {
        return Math.abs(b-a);
    }

    public void showTable(){
        table.createTable("Метод золотого сечения");
    }

    public double findMin(double epsilon) {
        double PHI = (1 + sqrt(5)) / 2; //пропорция золотого сечения

        double x1 = b - (b - a) / PHI;
        double x2 = a + (b - a) / PHI;
        double f1 = Main.f(x1);
        double f2 = Main.f(x2);
        table.putData(counter, a, b, getLength(), x1, x2, f1, f2);

        while (Math.abs(b - a) > epsilon) {
            counter++;
            if (f1 >= f2) {
                a = x1;
                x1 = x2;
                f1 = f2;
                x2 = a + (b - a) / PHI;
                f2 = Main.f(x2);
            } else {
                b = x2;
                x2 = x1;
                f2 = f1;
                x1 = b - (b - a) / PHI;
                f1 = Main.f(x1);
            }

            table.putData(counter, a, b, getLength(), x1, x2, f1, f2);
        }
        return Main.f((a + b) / 2);
    }
}
