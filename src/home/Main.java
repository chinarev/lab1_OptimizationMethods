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
        System.out.println("\nМетод золотого сечения:");
        GoldenRatio GR = new GoldenRatio();
        System.out.println(GR.findMin(a, b, epsilon));
        System.out.println("Метод дихотомии:");
        Dichotomy D = new Dichotomy();
        System.out.println(D.findMin(a, b, epsilon, delta));
        System.out.println("\nМетод Фибоначчи:");
        Fibonacci F = new Fibonacci();
        System.out.println(F.findMin());
    }


    public static double f(double x) {
        double f = Math.pow((x - 15), 2) + 5;
        return f;
    }


}
