package home;


import static java.lang.Math.log;

public class Dichotomy {

    /* не работающее ass
    double findMin2(double a, double b, double epsilon, double delta) {
        int n = (int) Math.round(log((b - a) * epsilon) / log(2));
        double x1, x2;
        for (int i = 0; i < n; i++) {
            x1 = (a + b) / 2 - delta;
            x2 = (a + b) / 2 + delta;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
        }
        return (a + b) / 2;
    }
*/

    double findMin(double a, double b, double epsilon, double delta) {
        double x1, x2;
        int n = 0;
        while (true) {
            n++;
            x1 = (a + b) / 2 - delta;
            x2 = (a + b) / 2 + delta;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < epsilon) break;
        }
        return (a + b) / 2;
    }
}
