package home;

public class FindMinOnLine {

    private double a = 0, b = 0;

    public void findMin(double x0, double delta, double h) {
        double xPrev, xCurr, xNext;
        xCurr = x0;
        xNext = 0;
        xPrev = 0;
        if (Main.f(xCurr) > Main.f(xCurr - delta)) {
            xNext = xCurr + delta;
            h = delta;
        }
        else if (Main.f(xCurr) > Main.f(xCurr - delta)) {
            xNext = xCurr - delta;
            h = -delta;
        }
        else {
        xPrev = x0 - delta;
        xCurr = x0 + delta;
        }

        while (Main.f(xCurr)>Main.f(xNext)) {
            h *= 2;
            xPrev = xCurr;
            xCurr = xNext;
            xNext = xNext + h;
        }
        a = xPrev;
        b = xNext;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
