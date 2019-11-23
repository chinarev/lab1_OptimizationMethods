package linearRegression;

import java.util.Vector;

public class GradientDescent {

    double lyambda;
    double epsilonF = 0.001;
    int counter = 0;
    Vector<Double> xCurr = new Vector<>();
    Vector<Double> xNext = new Vector<>();

    public static double f(Vector<Double> x) {
        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);

        return 100 * Math.pow((x2 - Math.pow(x1, 3)), 2) + Math.pow((1 - x1), 2);
    }

    public Vector<Double> grad(Vector<Double> x){
        Vector<Double> g = new Vector();

        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);
        double dx1 = -600 * x1*x1 * (-1*Math.pow(x1, 3) + x2) + 2*x1 - 2; //Частная производная для x1
        double dx2 = -200 * Math.pow(x1, 3) + 200 * x2; //Частная производная для x2

        g.add(dx1);
        g.add(dx2);
        return g;
    }

    public void gradientDescent(Vector<Double> xCurr, double lyambda)  {
        do {
            xCurr = xNext;
            xNext.insertElementAt(xCurr.elementAt(0) - lyambda * grad(xCurr).elementAt(0), 0);
            xNext.insertElementAt(xCurr.elementAt(1) - lyambda * grad(xCurr).elementAt(1), 1);
            counter++;
            } while (Math.abs(f(xNext) - f(xCurr)) < epsilonF);
    }
}
