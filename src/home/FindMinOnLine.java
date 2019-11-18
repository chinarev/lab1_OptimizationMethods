package home;

import home.tables.Table;

public class FindMinOnLine {
    private double start = 0, end = 0;//концы отрезка, содержащего точку минимума
    private int counter = 1; //счётчик итераций (первый шаг выполняется всегда)

    private Table table = new Table();

    public void findMin(double x0, double delta) {
        double h = 0,//величина шага
                xPrev = x0,//Xk-1
                xCurr = x0,//Xk
                xNext = x0;//Xk+1

        //определение направления убывания функции - к искомому минимуму
        double fCurr = Main.f(xCurr);

        if (fCurr > Main.f(xCurr + delta)) { //движение в положительном направлении (h = +delta)
            xNext = x0 + delta;
            h = delta;

        } else if (fCurr > Main.f(xCurr - delta)) { //движение в отрицательном направлении (h = -delta)
            xNext = x0 - delta;
            h = -delta;
        }

        double fNext = Main.f(xNext);

        defineStartAndEnd(xPrev, xNext);
        table.putData(counter, start, end, getLength(), xCurr, xNext, fCurr, fNext);

        while (fCurr > fNext) {
            h *= 2;//увеличение шага
            //k=k+1
            xPrev = xCurr;
            xCurr = xNext;
            xNext = xNext + h;
            counter++;

            defineStartAndEnd(xPrev, xNext);
            table.putData(counter, start, end, getLength(), xCurr, xNext, fCurr, fNext);

            fCurr = fNext;
            fNext = Main.f(xNext);
        }


        table.createTable("Поиск минимума функции на прямой");

    }

    private void defineStartAndEnd(double xPrev, double xNext){
        if (xPrev < xNext) {
            start = xPrev;
            end = xNext;
        } else {
            start = xNext;
            end = xPrev;
        }
    }

    public int getCounter() {
        return counter;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public double getLength() {
        return end - start;
    }

}
