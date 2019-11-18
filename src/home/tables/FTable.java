package home.tables;

import home.Fibonacci;

public class FTable extends GraphTable {
    public void getData(double startEpsilon){
        for (double currEpsilon = startEpsilon; currEpsilon <= 0.05; currEpsilon += 0.001){
            Fibonacci fibonacci = new Fibonacci();
            fibonacci.findMin(currEpsilon);
            putData(fibonacci.getTotalN(), currEpsilon);
        }
        createTable("Данные для графика. Метод Фибоначчи");
    }
}
