package home;

public class Main {

    static double a = 2;
    static double b = 200;
    static double h; //величина шага
    static double epsilon = 0.001; //точность
    static double delta = epsilon / 3; //расстояние от середины отрезка


    public static void main(String[] args) {
        System.out.println("Метод золотого сечения:");
        GoldenRatio GR = new GoldenRatio();
        System.out.println(GR.findMin(a, b, epsilon));
        System.out.println("Число вычислений функции для достижения заданной точности:");
        System.out.println(GR.getCounter());


        System.out.println("\nМетод дихотомии:");
        Dichotomy D = new Dichotomy();
        System.out.println(D.findMin(a, b, epsilon, delta));
        System.out.println("Число вычислений функции для достижения заданной точности:");
        System.out.println(D.getCounter());


        System.out.println("\nМетод Фибоначчи:");
        Fibonacci F = new Fibonacci();
        System.out.println(F.findMin());
        System.out.println("Число вычислений функции для достижения заданной точности:");
        System.out.println(F.getCounter());


        System.out.println("MEMESES: ");
        FindMinOnLine Min = new FindMinOnLine();
        Min.findMin(5, delta, h);
        System.out.println(Min.getA());
        System.out.println(Min.getB());
    }


    public static double f(double x) {
        double f = Math.pow((x - 15), 2) + 5;
        return f;
    }


}
