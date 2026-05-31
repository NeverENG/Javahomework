package practice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private TextField resultField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("计算器");

        Label label1 = new Label("操作数1：");
        num1Field = new TextField();
        num1Field.setPrefWidth(120);

        Label label2 = new Label("操作数2：");
        num2Field = new TextField();
        num2Field.setPrefWidth(120);

        Button addBtn = new Button("+");
        Button subBtn = new Button("-");
        Button mulBtn = new Button("×");
        Button divBtn = new Button("÷");

        Label resultLabel = new Label("结果：");
        resultField = new TextField();
        resultField.setEditable(false);
        resultField.setPrefWidth(120);

        // Lambda: parse inputs, return null if invalid
        DoubleBinaryOperator parse = () -> {
            try {
                double a = Double.parseDouble(num1Field.getText().trim());
                double b = Double.parseDouble(num2Field.getText().trim());
                return new double[]{a, b};
            } catch (NumberFormatException e) {
                return null;
            }
        };

        addBtn.setOnAction(e -> {
            double[] nums = parse.apply();
            if (nums == null) {
                showError("输入信息有误！");
                return;
            }
            resultField.setText(String.valueOf(nums[0] + nums[1]));
        });

        subBtn.setOnAction(e -> {
            double[] nums = parse.apply();
            if (nums == null) {
                showError("输入信息有误！");
                return;
            }
            resultField.setText(String.valueOf(nums[0] - nums[1]));
        });

        mulBtn.setOnAction(e -> {
            double[] nums = parse.apply();
            if (nums == null) {
                showError("输入信息有误！");
                return;
            }
            resultField.setText(String.valueOf(nums[0] * nums[1]));
        });

        divBtn.setOnAction(e -> {
            double[] nums = parse.apply();
            if (nums == null) {
                showError("输入信息有误！");
                return;
            }
            if (nums[1] == 0) {
                showError("输入的除数为0，无法进行除法运算！");
                return;
            }
            resultField.setText(String.valueOf(nums[0] / nums[1]));
        });

        HBox row1 = new HBox(10, label1, num1Field);
        row1.setAlignment(Pos.CENTER);

        HBox row2 = new HBox(10, label2, num2Field);
        row2.setAlignment(Pos.CENTER);

        HBox buttonRow = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
        buttonRow.setAlignment(Pos.CENTER);

        HBox row3 = new HBox(10, resultLabel, resultField);
        row3.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, row1, row2, buttonRow, row3);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
        resultField.setText("");
    }

    @FunctionalInterface
    interface DoubleBinaryOperator {
        double[] apply();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
