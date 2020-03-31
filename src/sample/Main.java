package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle(" ");
        primaryStage.show();


    }

    public Pane createRootPane() {
        GridPane pane = new GridPane();
        pane.setMinSize(350, 150);
        pane.setMaxSize(350, 150);
        pane.setPadding(new Insets(10));

        TextField lbl1 = new TextField("");
        TextField lbl2 = new TextField("");
        Text display1 = new Text("getal1");
        Text display2 = new Text("getal2");
        Text displayAns = new Text("");

        Button btnP = new Button("+");
        Button btnV = new Button("*");
        Button btnD = new Button("/");
        btnP.setMaxWidth(Double.MAX_VALUE);
        btnV.setMaxWidth(Double.MAX_VALUE);
        btnD.setMaxWidth(Double.MAX_VALUE);

        display1.setStyle("-fx-font-weight: bold");
        display2.setStyle("-fx-font-weight: bold");
        //lbl1.alignmentProperty(Pos.CENTER_LEFT);
        GridPane.setMargin(display1, new Insets(0, 150, 0, 0));
        GridPane.setMargin(display2, new Insets(0, 150, 0, 0));

        pane.add(display1, 0,0);
        pane.add(display2, 0,1);
        pane.add(lbl1, 1,0,3,1);
        pane.add(lbl2, 1,1,3,2);
        pane.add(btnP, 0, 3);
        pane.add(btnV, 1, 3);
        pane.add(btnD, 2, 3);
        pane.add(displayAns, 0, 5);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33.33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33.33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33.33);
        pane.getColumnConstraints().addAll(col1, col2, col3);


        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
