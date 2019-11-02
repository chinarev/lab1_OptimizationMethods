package home;

public class Main {

    static double a = 2;
    static double b = 200;
    static double epsilon = 0.001; //точность
    static int max_step = 10000;
    static double delta = epsilon / 3; //расстояние от середины отрезка
    static double x;
    static int k;


    public static void main(String[] args) {
        GoldenSection GS = new GoldenSection();
        System.out.println(GS.findMin(a, b, epsilon));
        Dichotomy D = new Dichotomy();
        System.out.println(D.findMin(a, b, epsilon, delta));
    }


    public static double f(double x) {
        double f = Math.pow((x - 15), 2) + 5;
        return f;
    }


}
