package home;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Table {
    private Vector<String> columnNames;
    private Vector<Vector<Double>> data;
    private JTable table;


    public Table() {
        columnNames = new Vector<>();
        columnNames.add("Номер итерации");
        columnNames.add("Начало отрезка");
        columnNames.add("Конец отрезка");
        columnNames.add("Длина отрезка");
        columnNames.add("x1");
        columnNames.add("x2");
        columnNames.add("f(x1)");
        columnNames.add("f(x2)");

        data = new Vector<>();
    }

    public void putDataInRow(int currCounter, double start, double end, double length, double x1, double x2, double fx1, double fx2) {
        Vector<Double> oneRow = new Vector<>();
        oneRow.add((double) currCounter);
        oneRow.add(start);
        oneRow.add(end);
        oneRow.add(length);
        oneRow.add(x1);
        oneRow.add(x2);
        oneRow.add(fx1);
        oneRow.add(fx2);
        data.add(oneRow);
    }


    public void createTable(String tableName) {
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame(tableName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
