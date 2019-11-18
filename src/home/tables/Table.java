package home.tables;



import java.util.Vector;

public class Table extends BaseTable {
    private double startLength;

    @Override
    public void setColumnNames(){
        columnNames.add("Номер итерации");
        columnNames.add("Начало отрезка");
        columnNames.add("Конец отрезка");
        columnNames.add("Длина отрезка");
        columnNames.add("length(i)/length(0)"); //соотношение длин текущего и начального отрезков
        columnNames.add("x1");
        columnNames.add("x2");
        columnNames.add("f(x1)");
        columnNames.add("f(x2)");
    }

    public void putData(int currCounter, double start, double end, double length, double x1, double x2, double fx1, double fx2){
        if (currCounter == 1){
            startLength = length;
        }
        Vector<Double> oneRow = new Vector<>();
        oneRow.add((double) currCounter);
        oneRow.add(start);
        oneRow.add(end);
        oneRow.add(length);
        oneRow.add(length / startLength); //соотношение длин текущего и начального отрезков
        oneRow.add(x1);
        oneRow.add(x2);
        oneRow.add(fx1);
        oneRow.add(fx2);
        putDataInRow(oneRow);
    }

    @Override
    protected void putDataInRow(Vector<Double> oneRow) {
        data.add(oneRow);
    }
}
