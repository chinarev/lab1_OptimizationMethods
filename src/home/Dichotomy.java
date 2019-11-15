package home;


public class Dichotomy {
    private int counter;//счётчик количества вычислений функции

    public Dichotomy(){
        counter = 0;
    }

    public int getCounter(){
        return counter;
    }


    double findMin(double a, double b, double epsilon, double delta) {
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
        return Main.f((a + b) / 2);
    }
}