package home;


public class Main {

    static final double a = 2; //начало заданного отрезка
    static final double b = 200; //конец заданного отрезка
    private static final double epsilon = 0.001; //точность
    private static final double delta = epsilon /3; //начальная величина шага для поиска минимума на прямой
    private static final double x0 = 20; //начальная точка для поиска минимума функции на прямой


    public static void main(String[] args) {


        System.out.println("~~~Метод золотого сечения~~~");
        GoldenRatio GR = new GoldenRatio();
        System.out.println("min = " + GR.findMin(epsilon));
        System.out.println("Длина отрезка: " + GR.getLength());
        System.out.println("Число вычислений функции для достижения заданной точности: " + (2 + GR.getCounter())); //Перед циклом функция вычисляется два раза, а в цикле по одному разу


        System.out.println("\n~~~Метод дихотомии~~~");
        Dichotomy D = new Dichotomy();
        System.out.println("min = " + D.findMin(epsilon));
        System.out.println("Длина отрезка: " + D.getLength());
        System.out.println("Число вычислений функции для достижения заданной точности: " + 2 * D.getCounter()); //На каждой итерации функция вычисляется два раза


        System.out.println("\n~~~Метод Фибоначчи~~~");
        Fibonacci F = new Fibonacci();
        System.out.println("min = " + F.findMin(epsilon));
        System.out.println("Длина отрезка: " + F.getLength());
        System.out.println("Число вычислений функции для достижения заданной точности: " + (2 + F.getCounter())); //Перед циклом функция вычисляется два раза, а в цикле по одному разу


        System.out.println("\n~~~Поиск минимума функции на прямой~~~");
        FindMinOnLine Min = new FindMinOnLine();
        Min.findMin(x0, delta);
        System.out.println("Начальная точка x0 = " + x0);
        System.out.println("Отрезок, содержащий точку минимума функции:");
        System.out.println("Длина отрезка: " + Min.getLength());
        System.out.println("Начало отрезка: " + Min.getStart());
        System.out.println("Конец отрезка: " + Min.getEnd());
        System.out.println("Количество итераций: " + Min.getCounter());
        System.out.println("Количество вычислений функции: " + (3 + Min.getCounter())); //Перед циклом функция вычисляется три раза, а в цикле по одному разу
    }


    public static double f(double x) {
        return Math.pow((x - 15), 2) + 5;
    }
}
