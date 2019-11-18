package home;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graph extends Application {


    @Override public void start(Stage stage) {
        stage.setTitle("График");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("log(epsilon)");
        yAxis.setLabel("Количество вычислений функции");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("График зависимости количества вычислений минимизируемой функции от логарифма задаваемой точности");
        //defining a series
        XYChart.Series dSeries = new XYChart.Series();
        dSeries.setName("Метод дихотомии");
        XYChart.Series grSeries = new XYChart.Series();
        grSeries.setName("Метод золотого сечения");
        XYChart.Series fSeries = new XYChart.Series();
        fSeries.setName("Метод Фибоначчи");


        //populating the series with data
        for (double currEpsilon = 0.001; currEpsilon <= 0.9; currEpsilon += 0.001){
            Dichotomy dichotomy = new Dichotomy();
            dichotomy.findMin(currEpsilon);
            dSeries.getData().add(new XYChart.Data((double)Math.round(Math.log(currEpsilon) * 100000d)/100000d, (int)dichotomy.getCounter()* 2));

            GoldenRatio goldenRatio = new GoldenRatio();
            goldenRatio.findMin(currEpsilon);
            grSeries.getData().add(new XYChart.Data((double)Math.round(Math.log(currEpsilon) * 100000d)/100000d, (int)goldenRatio.getCounter() + 1));

            Fibonacci fibonacci = new Fibonacci();
            fibonacci.findMin(currEpsilon);
            fSeries.getData().add(new XYChart.Data((double)Math.round(Math.log(currEpsilon) * 100000d)/100000d, (int)fibonacci.getTotalN()));
        }



        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(dSeries);
        lineChart.getData().add(grSeries);
        lineChart.getData().add(fSeries);

        stage.setScene(scene);
        stage.show();

    }

    public void showGraph(String[] args){
        launch(args);
    }
}
