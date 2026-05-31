package practice3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeekdayGUI extends Application {
    private TextField inputField;
    private TextField outputField;

    private static final String[] WEEKDAYS = {
        "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"
    };

    @Override
    public void start(Stage stage) {
        stage.setTitle("星期查询");

        Label inputLabel = new Label("请输入数字（1-7）：");
        inputField = new TextField();
        inputField.setPrefWidth(100);

        Label outputLabel = new Label("查询结果：");
        outputField = new TextField();

        Button button = new Button("查询");
        outputField.setEditable(false);
        outputField.setPrefWidth(100);

        button.setOnAction(e -> {
            String input = inputField.getText().trim();
            try {
                int day = Integer.parseInt(input);
                if (day < 1 || day > 7) {
                    throw new NumberFormatException("数字 \"" + input + "\" 不在1-7范围内！");
                }
                outputField.setText(WEEKDAYS[day - 1]);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("BadDataException 您输入的数字不是1-7");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
                outputField.setText("");
            }
        });

        HBox inputRow = new HBox(10, inputLabel, inputField);
        inputRow.setAlignment(Pos.CENTER);

        HBox outputRow = new HBox(10, outputLabel, outputField);
        outputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, inputRow, outputRow, button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
