package home.tables;

import home.Dichotomy;

public class DTable extends GraphTable {

    public void getData(double startEpsilon){
        for (double currEpsilon = startEpsilon; currEpsilon <= 0.05; currEpsilon += 0.001){
            Dichotomy dichotomy = new Dichotomy();
            dichotomy.findMin(currEpsilon);
            putData(dichotomy.getCounter()* 2, currEpsilon);
        }
        createTable("Данные для графика. Метод дихотомии");
    }
}
