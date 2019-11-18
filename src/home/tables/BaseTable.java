package home.tables;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public abstract class BaseTable {
    protected Vector<String> columnNames  = new Vector<>();
    protected Vector<Vector<Double>> data  = new Vector<>();
    protected JTable table;

    public BaseTable(){
        setColumnNames();
    }


    public abstract void setColumnNames();
    protected abstract void putDataInRow(Vector<Double> rowData);



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
