package home;


import home.tables.Table;

public class Dichotomy {
    private double a = Main.a;
    private double b = Main.b;
    private int counter = 0;//счётчик итераций
    private double length = 0;

    private Table table = new Table();


    public int getCounter() {
        return counter;
    }

    public double getLength() {
        return length;
    }

    public void showTable(){
        table.createTable("Метод дихотомии");
    }


    public double findMin(double epsilon) {
        double x1, x2;
        double delta = epsilon / 3; //расстояние от середины отрезка
        while (Math.abs(b - a) > epsilon) {
            counter++;
            x1 = (a + b) / 2 - delta;
            x2 = (a + b) / 2 + delta;
            if (Main.f(x1) >= Main.f(x2))
                a = x1;
            else
                b = x2;

            length = Math.abs(b - a);

            table.putData(counter, a, b, length, x1, x2, Main.f(x1), Main.f(x2));
        }

        return Main.f((a + b) / 2);
    }
}