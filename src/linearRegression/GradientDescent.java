package linearRegression;

import java.util.Vector;

public class GradientDescent {

    double lyambda;
    double epsilonF = 0.001;
    int counter = 1; //1 шаг выполняем перед циклом
    Vector<Double> xCurr = new Vector<>(2);
    Vector<Double> xNext = new Vector<>(2);

    public static double f(Vector<Double> x) {
        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);

        return 100 * Math.pow((x2 - Math.pow(x1, 3)), 2) + Math.pow((1 - x1), 2);
    }

    public Vector<Double> grad(Vector<Double> x){
        Vector<Double> g = new Vector<>(2);

        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);
        double dx1 = -600 * x1*x1 * (-1*Math.pow(x1, 3) + x2) + 2*x1 - 2; //Частная производная для x1
        double dx2 = -200 * Math.pow(x1, 3) + 200 * x2; //Частная производная для x2

        g.add(dx1);
        g.add(dx2);
        return g;
    }

    private void printState(){
        System.out.println("\nНомер итерации: " + counter);
        System.out.println("xCurr[x1] = " + xCurr.elementAt(0) + "\nxCurr[x2] = " + xCurr.elementAt(1));
        System.out.println("f(xCurr) = " + f(xCurr));
        System.out.println("\nxNext[x1] = " + xNext.elementAt(0) + "\nxNext[x2] = " + xNext.elementAt(1));
        System.out.println("f(xNext) = " + f(xNext));
    }

    public Vector<Double> gradientDescent(Vector<Double> x0, double lyambda)  {
        xCurr = x0;
        //1 шаг
        xNext.add(0,xCurr.elementAt(0) - lyambda * grad(xCurr).elementAt(0));
        xNext.add(1,xCurr.elementAt(1) - lyambda * grad(xCurr).elementAt(1));
        printState();

        double t = Math.abs(f(xNext) - f(xCurr));
        while (t >= epsilonF){
            //xCurr = xNext;
            xCurr.set(0, xNext.elementAt(0));
            xCurr.set(1, xNext.elementAt(1));

            xNext.set(0,xCurr.elementAt(0) - lyambda * grad(xCurr).elementAt(0));
            xNext.set(1,xCurr.elementAt(1) - lyambda * grad(xCurr).elementAt(1));
            counter++;
            printState();
            t = Math.abs(f(xNext) - f(xCurr));
        }
        return xNext;
    }
}
