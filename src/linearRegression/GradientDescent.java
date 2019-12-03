package linearRegression;

import java.util.Vector;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GradientDescent {

    double lyambda;
    double epsilonF = 0.0001; //точность по функции
    double epsilonI = 0.001; //точность по переменным
    double epsilonGR = 0.001; //точность по градиенту
    int counter = 1; //1 шаг выполняем перед циклом
    int calculationsCounter = 0;
    Vector<Double> xCurr = new Vector<>(2);
    Vector<Double> xNext = new Vector<>(2);

    public static double f(Vector<Double> x) {
        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);

        return 100 * Math.pow((x2 - Math.pow(x1, 3)), 2) + Math.pow((1 - x1), 2);
    }

//    private Vector<Double> grad(Vector<Double> x){ //численный метод вычисления производной
//        Vector<Double> g = new Vector<>(2);
//
//        Vector<Double> xh1 = new Vector<>(2);
////        double h1 = - lyambda * getSk(xCurr).elementAt(0);//delta x1
////        double h2 = - lyambda * getSk(xCurr).elementAt(1);//delta x2
//        double h = -lyambda;
//        xh1.add(0, x.elementAt(0) + h);
//        xh1.add(1, x.elementAt(1));
//
//
//        Vector<Double> xh2 = new Vector<>(2);
//        xh2.add(0, x.elementAt(0));
//        xh2.add(1, x.elementAt(1) + h);
//
//        double dx1 = (f(xh1) - f(x))/h; //Частная производная для x1
//        double dx2 = (f(xh2) - f(x))/h; //Частная производная для x2
//
//        g.add(dx1);
//        g.add(dx2);
//        return g;
//    }


    private Vector<Double> grad(Vector<Double> x) {//аналитический метод вычисления производной
        Vector<Double> g = new Vector<>(2);

        double x1 = x.elementAt(0);
        double x2 = x.elementAt(1);
        double dx1 = -600 * x1 * x1 * (-1 * Math.pow(x1, 3) + x2) + 2 * x1 - 2; //Частная производная для x1
        double dx2 = -200 * Math.pow(x1, 3) + 200 * x2; //Частная производная для x2

        g.add(dx1);
        g.add(dx2);
        return g;
    }


    private double getNorm(Vector<Double> x) { //норма вектора градиента
        return Math.sqrt(Math.pow(grad(x).elementAt(0), 2) + Math.pow(grad(x).elementAt(1), 2));
    }

    private Vector<Double> getSk(Vector<Double> x) {
        Vector<Double> sk = new Vector<>(2);
        sk.add(0, grad(x).elementAt(0) / getNorm(x));
        sk.add(1, grad(x).elementAt(1) / getNorm(x));
        return sk;
    }

    private double fForSearch(Vector<Double> x, double currLyambda) { //функция для определения лямбды (функция, которую нужно минимизировать)
        Vector<Double> newX = new Vector<>(2);
        newX.add(0, x.elementAt(0) - currLyambda * getSk(x).elementAt(0));
        newX.add(1, x.elementAt(1) - currLyambda * getSk(x).elementAt(1));
        calculationsCounter++;
        return f(newX);
    }

    private double getLyambda(Vector<Double> x) {
        double epsilon = 0.001; //точность для метода дихотомии
        double a = 0; //нижняя граница
        double b = 1; //верхняя граница
        double lyambda1, lyambda2;


        double delta = epsilon / 4; //расстояние от середины отрезка
        while (Math.abs(b - a) > epsilon) {
            lyambda1 = (a + b) / 2 - delta;
            lyambda2 = (a + b) / 2 + delta;
            if (fForSearch(x, lyambda1) >= fForSearch(x, lyambda2))
                a = lyambda1;
            else
                b = lyambda2;
        }

        //double min = fForSearch(x, (a + b) / 2); //найденный минимум
        return (a + b) / 2;
    }

    private void printState() {
        System.out.println("\nНомер итерации: " + counter);
        System.out.println("\nКоличество вычислений функции f(x1,x2): " + calculationsCounter);
        System.out.println("xCurr[x1] = " + xCurr.elementAt(0) + "\nxCurr[x2] = " + xCurr.elementAt(1));
        System.out.println("f(xCurr) = " + f(xCurr));
        System.out.println("\nxNext[x1] = " + xNext.elementAt(0) + "\nxNext[x2] = " + xNext.elementAt(1));
        System.out.println("f(xNext) = " + f(xNext));
    }

    private boolean isEpsIReached(Vector<Double> x1, Vector<Double> x2) { //достигнута ли точность по переменным
        double dist = sqrt(pow(x1.elementAt(0) - x2.elementAt(0), 2) + pow(x1.elementAt(1) - x2.elementAt(1), 2));//расстояние между двумя точками
        return dist < epsilonI;
    }


    public Vector<Double> gradientDescent(Vector<Double> x0) {
        xCurr = x0;
        //1 шаг
        //xNext.add(0,xCurr.elementAt(0) - lyambda * grad(xCurr).elementAt(0));
        //xNext.add(1,xCurr.elementAt(1) - lyambda * grad(xCurr).elementAt(1));
        lyambda = getLyambda(xCurr);
        xNext.add(0, xCurr.elementAt(0) - lyambda * getSk(xCurr).elementAt(0)); //????
        xNext.add(1, xCurr.elementAt(1) - lyambda * getSk(xCurr).elementAt(1)); //????
        printState();

        double fCurr = f(xCurr);
        double fNext = f(xNext);
        calculationsCounter += 2;

        while (Math.abs(fNext - fCurr) >= epsilonF) {
            //xCurr = xNext;
            xCurr.set(0, xNext.elementAt(0));
            xCurr.set(1, xNext.elementAt(1));
            fCurr = fNext;

            //xNext.set(0,xCurr.elementAt(0) - lyambda * grad(xCurr).elementAt(0));
            //xNext.set(1,xCurr.elementAt(1) - lyambda * grad(xCurr).elementAt(1));

            lyambda = getLyambda(xCurr);

            xNext.set(0, xCurr.elementAt(0) - lyambda * getSk(xCurr).elementAt(0)); //????
            xNext.set(1, xCurr.elementAt(1) - lyambda * getSk(xCurr).elementAt(1)); //????
            fNext = f(xNext);
            calculationsCounter++;
            counter++;
            printState();
        }
        return xNext;
    }
}
