package zadanie1.git;

import java.util.Optional;
import javafx.event.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class MainController {

	@FXML
	private Label result;
	private boolean start = true;
	private Model model = new Model();
	
	
	/**
	 * 
	 * @param event sprawdza naciśnięcie CE
	 */
	@FXML public void delete(ActionEvent event) {
		
		String value = ((Button)event.getSource()).getText();
		
		if(value.equals("CE")) {
			result.setText("0");
			start = true ;
		}
	}

	/**
	 * 
	 * @param event sprawdza naciśnięcie liczb oraz *,/,+,- oraz .
	 */
	@FXML
	public void processNumber(ActionEvent event) {
		if(start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
	}
	
	/**
	 * 
	 * @param event sprawdza naciśnięcie =, sin, cos oraz √
	 * jezeli w JShell po wyliczeniu wystapil blad, to jest wyswietlany alert
	 */
	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		
		if(value.equals("=")) {
			String operator = (String) result.getText();
			
			
			String str = "Error\n";
			if((model.JShell_calculate(operator)).equals(str)) {
				Alert alertCustomized = new Alert(AlertType.CONFIRMATION);
				alertCustomized.setTitle("Alert");
				alertCustomized.setHeaderText("Error");
				ButtonType btnAbort = new ButtonType("Przerwij");
				ButtonType btnRetry = new ButtonType("Ponów");
				ButtonType btnIgnore = new ButtonType("Ignoruj");
				ButtonType btnTypeCancel = new ButtonType("Anuluj",ButtonData.CANCEL_CLOSE);
				Optional<ButtonType> res = alertCustomized.showAndWait();
				if(res.isPresent())
				new Alert(AlertType.INFORMATION, res.get().getText(),ButtonType.OK).showAndWait();
				alertCustomized.getButtonTypes().setAll(btnAbort, btnRetry,btnIgnore, btnTypeCancel);
				
				start = true;
			}else {
					result.setText(model.JShell_calculate(operator));
				  }
			
		}else {
		
		if(value.equals("sin(x)")) {
			StringBuilder str = new StringBuilder();
			String operator = (String) result.getText();
			str.append("Math.sin(").append(operator).append(")");
			String op = str.toString();
			result.setText(model.JShell_calculate(op));
			start = true;
		}
		if(value.equals("cos(x)")) {
			StringBuilder str = new StringBuilder();
			String operator = (String) result.getText();
			str.append("Math.cos(").append(operator).append(")");
			String op = str.toString();
			result.setText(model.JShell_calculate(op));
			start = true;
		}
		if(value.equals("√")) {
			StringBuilder str = new StringBuilder();
			String operator = (String) result.getText();
			str.append("Math.sqrt(").append(operator).append(")");
			String op = str.toString();
			result.setText(model.JShell_calculate(op));
			start = true;
		}
	}
}
		
		
		
}
	
	
	
 
