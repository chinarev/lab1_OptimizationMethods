package home.tables;


import java.util.Vector;


public class GraphTable extends BaseTable {

    @Override
    public void setColumnNames(){
        columnNames.add("epsilon");
        columnNames.add("log(epsilon)");
        columnNames.add("counter");
    }


    public void putData(int counter, double epsilon) {
        Vector<Double> oneRow = new Vector<>();
        oneRow.add(epsilon);
        oneRow.add(Math.log(epsilon));
        oneRow.add((double)counter);
        putDataInRow(oneRow);
    }


    @Override
    protected void putDataInRow(Vector<Double> oneRow){
        data.add(oneRow);
    }







}
