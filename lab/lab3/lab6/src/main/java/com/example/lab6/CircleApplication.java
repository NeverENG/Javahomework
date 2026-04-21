package com.example.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleApplication extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane(); // 创建一个 pane pane是啥  div

        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        Circle circle2 = new Circle(100, 100, 40);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);
        pane.getChildren().add(circle2);

        Circle circle3 = new Circle(100, 100, 30);
        circle3.setFill(Color.TRANSPARENT);
        circle3.setStroke(Color.BLACK);
        pane.getChildren().add(circle3);

        Circle circle4 = new Circle(100, 100, 20);
        circle4.setFill(Color.TRANSPARENT);
        circle4.setStroke(Color.BLACK);
        pane.getChildren().add(circle4);

        Circle circle5 = new Circle(100, 100, 10);
        circle5.setFill(Color.TRANSPARENT);
        circle5.setStroke(Color.BLACK);
        pane.getChildren().add(circle5);

        Circle circle6 = new Circle(100, 100, 5);
        circle6.setFill(Color.TRANSPARENT);
        circle6.setStroke(Color.BLACK);
        pane.getChildren().add(circle6);

        Circle circle7 = new Circle(100, 100, 1);
        circle7.setFill(Color.TRANSPARENT);
        circle7.setStroke(Color.BLACK);
        pane.getChildren().add(circle7);

        stage.setScene(new Scene(pane, 200, 200));
        stage.show();
        stage.setTitle("Circle");

    }
}
