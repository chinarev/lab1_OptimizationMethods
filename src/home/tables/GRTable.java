package home.tables;

import home.GoldenRatio;

public class GRTable extends GraphTable {

    public void getData(double startEpsilon){
        for (double currEpsilon = startEpsilon; currEpsilon <= 0.05; currEpsilon += 0.001){
            GoldenRatio goldenRatio = new GoldenRatio();
            goldenRatio.findMin(currEpsilon);
            putData(goldenRatio.getCounter() + 1, currEpsilon);
        }
        createTable("Данные для графика. Метод золотого сечения");
    }
}
