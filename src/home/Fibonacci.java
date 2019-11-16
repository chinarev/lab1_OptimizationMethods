package home;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Fibonacci {
    private double a0;
    private double b0;
    private double epsilon;
    private int counter;//счётчик количества вычислений функции
    private double length;

    public Fibonacci(){
        a0 = Main.a;
        b0 = Main.b;
        epsilon = Main.epsilon;
        counter = 0;
        length = 0;
    }

    double fibonacciNum(int n) {
        return 1 / sqrt(5) * (pow((1 + sqrt(5)) / 2, n) - pow((1 - sqrt(5)) / 2, n));
    }

    private int getN(){
        int n = 1;
        while(true){
            if ((b0 - a0)/epsilon < fibonacciNum(n+2)){
                counter = n;
                return n;
            } else {
                n++;
            }
        }
    }


    public int getCounter(){
        return counter;
    }

    public double getLength(){return length;}


    public double findMin() {
        double x1, x2;
        int n = getN();
        for (int k = 1; k <= n; k++){
            x1 = a0 + fibonacciNum(n) / fibonacciNum(n + 2) * (b0 - a0);
            x2 = a0 + fibonacciNum(n + 1) / fibonacciNum(n + 2) * (b0 - a0);
            if (Main.f(x1) >= Main.f(x2))
                a0 = x1;
            else
                b0 = x2;
        }
        length = Math.abs(b0 - a0);
        return Main.f((a0 + b0) / 2);
    }
}
