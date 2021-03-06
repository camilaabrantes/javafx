package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{

	@FXML
	private TextField txtField1;

	@FXML
	private TextField txtField2;

	@FXML
	private Label label;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumClick() {
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtField1.getText());
			double number2 = Double.parseDouble(txtField2.getText());
			double sum = number1 + number2;
			label.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtField1);
		Constraints.setTextFieldDouble(txtField2);
		Constraints.setTextFieldMaxLength(txtField1, 12);
		Constraints.setTextFieldMaxLength(txtField2, 12);
	}

}
