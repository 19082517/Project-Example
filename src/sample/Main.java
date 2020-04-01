package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
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

    private Button btnP = new Button("+");
    private Button btnV = new Button("*");
    private Button btnD = new Button("/");
    private TextField field1 = new TextField("");
    private TextField field2 = new TextField("");
    private Text displayAns = new Text("");

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = createRootPane();
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle(" ");
        primaryStage.show();
    }

    public GridPane createRootPane() {
        GridPane pane = new GridPane();
        pane.setMinSize(350, 150);
        pane.setMaxSize(350, 150);
        pane.setPadding(new Insets(10));

        setButtonSize(btnD);
        setButtonSize(btnP);
        setButtonSize(btnV);

        pane.add(new Text("getal1"), 0,0);
        pane.add(new Text("getal2"), 0,1);
        pane.add(field1, 1,0,3,1);
        pane.add(field2, 1,1,3,2);
        pane.add(btnP, 0, 3);
        pane.add(btnV, 1, 3);
        pane.add(btnD, 2, 3);
        pane.add(displayAns, 0, 5);

        ColumnConstraints col1 = createColumnConstraints();
        ColumnConstraints col2 = createColumnConstraints();
        ColumnConstraints col3 = createColumnConstraints();
        pane.getColumnConstraints().addAll(col1, col2, col3);

        btnP.setOnAction((ActionEvent event) -> produceAnswer("+"));
        btnD.setOnAction((ActionEvent event) -> produceAnswer("/"));
        btnV.setOnAction((ActionEvent event) -> produceAnswer("*"));

        return pane;
    }

    public void produceAnswer(String operation){
        double number1 = getNumberTextfield(field1);
        double number2 = getNumberTextfield(field2);
        Calculator calc = null;

        if(operation.equals("+"))calc = new Calculator(number1, number2);
        else if(operation.equals("/"))calc = new DeelBerekening(number1, number2);
        else if(operation.equals("*"))calc = new MaalBerekening(number1, number2);

        String answer = String.format("%.2f", calc.bereken());
        displayAns.setText(answer);
    }

    public void setButtonSize(Button btn) {btn.setMaxWidth(Double.MAX_VALUE);}
    public int getNumberTextfield(TextField field){return Integer.parseInt(field.getText());}

    public ColumnConstraints createColumnConstraints()
    {
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(33.33);
        return col;
    }

    public static void main(String[] args) {launch(args);}
}

interface Berekening
{
    double bereken();
}

class Calculator implements Berekening
{
    private Double number1;
    private Double number2;

    public Calculator(Double number1, Double number2){this.number1 = number1;this.number2 = number2;}
    public Double getNumber1(){return this.number1;}
    public Double getNumber2(){return this.number2;}

    @Override
    public double bereken() { //standaard wordt er in Calculater een optelling gemaakt in de method 'bereken()'
        return number1 + number2;
    }
}
class MaalBerekening extends Calculator
{
    public MaalBerekening(Double number1, Double number2) {super(number1, number2);}

    @Override
    public double bereken() {
        return super.getNumber1() * super.getNumber2();
    }
}
class DeelBerekening extends Calculator
{
    public DeelBerekening(Double number1, Double number2) {super(number1, number2);}

    @Override
    public double bereken() {
        return super.getNumber1() / super.getNumber2();
    }
}



