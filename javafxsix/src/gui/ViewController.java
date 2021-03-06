package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Person> comboBoxPerson; // caixa com op??es para serem selecionadas pelo usu?rio
	
	@FXML
	private Button btAll;

	private ObservableList<Person> obsList;
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem(); //pega o item selecionado no Combo Box
		System.out.println(person);
	}
	
	@FXML
	public void onBtAllAction(){
		for(Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> personsList = new ArrayList<Person>();
		personsList.add(new Person(1, "Maria", "gmail"));
		personsList.add(new Person(2, "Alex", "gmail"));
		personsList.add(new Person(3, "Joao", "gmail"));

		obsList = FXCollections.observableList(personsList);
		comboBoxPerson.setItems(obsList);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));
	}

}
