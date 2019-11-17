package home;


public class Dichotomy {
    private double a = Main.a;
    private double b = Main.b;
    private double epsilon = Main.epsilon;
    private double delta = Main.delta;
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
        double x1, x2;
        while (Math.abs(b - a) > epsilon) {
            counter++;
            x1 = (a + b) / 2 - delta;
            x2 = (a + b) / 2 + delta;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;

            length = Math.abs(b - a);

            table.putData(counter, a, b, length, x1, x2, Main.f(x1), Main.f(x2));
        }

        table.createTable("Метод дихотомии");

        return Main.f((a + b) / 2);
    }
}