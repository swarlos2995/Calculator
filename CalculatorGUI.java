import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class CalculatorGUI extends Application {

	private TextArea displayArea;
	private ArrayList<Button> buttonList;
	//private OperationType currentOp;
	
	private double num = 0.0;
	private double result = 0.0;
	
	private Calculator calc = new Calculator ();


	@Override
	public void start(Stage primaryStage) {
		int sceneWidth = 265, sceneHeight = 500; // Changed from sceneWidth = 260

		int verSpaceBetweenNodes = 8, horSpaceBetweenNodes = 8;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;

		initializeButtons();

		for (Button b : buttonList) {
			b.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
			b.setPrefSize(50, 50);
		}

		FlowPane numbersPane = new FlowPane();
		numbersPane.setHgap(horSpaceBetweenNodes);
		numbersPane.setVgap(verSpaceBetweenNodes);
		numbersPane.setPadding(new Insets(paneBorderTop, paneBorderRight,
				paneBorderBottom, paneBorderLeft));
		for (Button button : buttonList) {
			numbersPane.getChildren().add(button);
		}

		BorderPane back = new BorderPane();
		back.setStyle(("-fx-background-color: #424242;"));
		displayArea = new TextArea();
		displayArea.setEditable(false);
		displayArea.setWrapText(true);

		/* Adding scroll pane to text area */
		ScrollPane scrollPane = new ScrollPane(displayArea);
		scrollPane.setStyle("-fx-background-color: #424242;");

		back.setTop(scrollPane);
		back.setCenter(numbersPane);

		Scene scene = new Scene(back, sceneWidth, sceneHeight);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		//currentOp = OperationType.NONE;
	}

	public double calculate() {
		calc.setNum(parseDisplay());
		calc.calculate();
		return calc.getResult();
	}

	public void addOperation(OperationType o) {
		calc.setOperation(o);
		displayArea.setText("");
	}

	public void clearExpression() {
		displayArea.setText("");
		calc.clearEverything();
	}
	
	public void clear () {
		displayArea.setText("");
		calc.clear();
	}

	public double inverse(double d) {
		return 1 / d;
	}

	public double sqrt(double d) {
		return Math.sqrt(d);
	}

	public double parseDisplay() {
		return Double.parseDouble(displayArea.getText());
	}

	public void initializeButtons() {
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button dot = new Button(".");
		Button clear = new Button("C");
		Button divide = new Button("/");
		Button plus = new Button("+");
		Button multiply = new Button("*");
		Button minus = new Button("-");
		Button equal = new Button("=");

		Button clearExpression = new Button("CE");
		Button sqrt = new Button("√");
		Button inverse = new Button("1/x");

		zero.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "0");
				calc.setNum(0);
				event.consume();
			}
		});

		one.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "1");
				calc.setNum(1);
				event.consume();
			}
		});

		two.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "2");
				calc.setNum(2);
				event.consume();
			}
		});

		three.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "3");
				calc.setNum(3);
				event.consume();
			}
		});

		four.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "4");
				event.consume();
			}
		});

		five.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "5");
				event.consume();
			}
		});

		six.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "6");
				event.consume();
			}
		});

		seven.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "7");
				event.consume();
			}
		});

		eight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "8");
				event.consume();
			}
		});

		nine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(displayArea.getText() + "9");
				event.consume();
			}
		});

		dot.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!displayArea.getText().contains(".")) {
					displayArea.setText(displayArea.getText() + ".");
				}
				event.consume();
			}
		});

		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				calc.clear();
				event.consume();
			}
		});

		clearExpression.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				clearExpression();
				event.consume();
			}
		});

		plus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addOperation(OperationType.ADDITION);
				event.consume();
			}
		});

		minus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addOperation(OperationType.SUBTRACTION);
				event.consume();
			}
		});

		multiply.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addOperation(OperationType.MULTIPLICATION);
				event.consume();
			}
		});

		divide.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addOperation(OperationType.DIVISION);
				event.consume();
			}
		});

		equal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String msg = String.valueOf(calculate());
				displayArea.setText(msg);
				event.consume();
			}
		});

		inverse.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(String.valueOf(inverse(parseDisplay())));
				event.consume();
			}
		});

		sqrt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayArea.setText(String.valueOf(sqrt(parseDisplay())));
				event.consume();
			}
		});

		buttonList = new ArrayList<Button>();

		buttonList.add(clearExpression);
		buttonList.add(inverse);
		buttonList.add(sqrt);
		buttonList.add(divide);
		buttonList.add(seven);
		buttonList.add(eight);
		buttonList.add(nine);
		buttonList.add(plus);
		buttonList.add(four);
		buttonList.add(five);
		buttonList.add(six);
		buttonList.add(multiply);
		buttonList.add(one);
		buttonList.add(two);
		buttonList.add(three);
		buttonList.add(minus);
		buttonList.add(zero);
		buttonList.add(dot);
		buttonList.add(clear);
		buttonList.add(equal);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}