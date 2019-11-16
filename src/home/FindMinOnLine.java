package home;

public class FindMinOnLine {

    private double ak = 0, bk = 0;//концы отрезка, содержащего точку минимума

    public void findMin(double x0, double delta) {
        double h = 0,//величина шага
                xPrev = x0,//Xk-1
                xCurr = x0,//Xk
                xNext = x0;//Xk+1

        //определение направления убывания функции - к искомому минимуму
        if (Main.f(xCurr) > Main.f(xCurr + delta)) { //движение в положительном направлении (h = +delta)
            xNext = x0 + delta;
            h = delta;
        }
        else if (Main.f(xCurr) > Main.f(xCurr - delta)) { //движение в отрицательном направлении (h = -delta)
            xNext = x0 - delta;
            h = -delta;
        }


        while (Main.f(xCurr)>Main.f(xNext)) {
            h *= 2;//увеличение шага
            //k=k+1
            xPrev = xCurr;
            xCurr = xNext;
            xNext = xNext + h;
        }
        ak = xPrev;
        bk = xNext;
    }

    public double getA() {
        return ak;
    }

    public double getB() {
        return bk;
    }
}
