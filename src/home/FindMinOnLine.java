package home;

public class FindMinOnLine {
    private double start = 0, end = 0;//концы отрезка, содержащего точку минимума
    private int counter = 1; //т.к. шаг 1 выполняется всегда
    private double length = 0;

    private Table table = new Table();

    public void findMin(double x0) {
        double delta = Main.delta;
        double h = 0,//величина шага
                xPrev = x0,//Xk-1
                xCurr = x0,//Xk
                xNext = x0;//Xk+1

        //определение направления убывания функции - к искомому минимуму
        if (Main.f(xCurr) > Main.f(xCurr + delta)) { //движение в положительном направлении (h = +delta)
            xNext = x0 + delta;
            h = delta;

        } else if (Main.f(xCurr) > Main.f(xCurr - delta)) { //движение в отрицательном направлении (h = -delta)
            xNext = x0 - delta;
            h = -delta;
        }

        defineStartAndEnd(xPrev, xNext);
        length =  getLength();
        table.putData(counter, start, end, length, xCurr, xNext, Main.f(xCurr), Main.f(xNext));

        while (Main.f(xCurr) > Main.f(xNext)) {
            h *= 2;//увеличение шага
            //k=k+1
            xPrev = xCurr;
            xCurr = xNext;
            xNext = xNext + h;
            counter++;

            defineStartAndEnd(xPrev, xNext);
            length =  getLength();
            table.putData(counter, start, end, length, xCurr, xNext, Main.f(xCurr), Main.f(xNext));
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
