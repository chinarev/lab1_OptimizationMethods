package home;


public class Dichotomy {
    private int counter;//счётчик количества вычислений функции
    private double length;

    public Dichotomy() {
        counter = 0;
        length = 0;
    }

    public int getCounter() {
        return counter;
    }

    public double getLength(){
        return length;
    }

    double findMin() {
        double delta = Main.delta;
        double epsilon = Main.epsilon;
        double a = Main.a;
        double b = Main.b;
        double x1, x2;
        while (Math.abs(b - a) > epsilon) {
            counter++;
            x1 = (a + b) / 2 - delta;
            x2 = (a + b) / 2 + delta;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
        }
        length = Math.abs(b-a);
        return Main.f((a + b) / 2);
    }
}