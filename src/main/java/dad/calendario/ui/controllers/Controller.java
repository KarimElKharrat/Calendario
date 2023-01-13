package dad.calendario.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

import dad.calendario.component.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	// model
	
	private IntegerProperty yearProperty = new SimpleIntegerProperty();
	
	// view
	
	@FXML
	private Label yearLabel;

    @FXML
    private MonthCalendar eneroCalendar;
    @FXML
    private MonthCalendar febreroCalendar;
    @FXML
    private MonthCalendar marzoCalendar;
    @FXML
    private MonthCalendar abrilCalendar;
    @FXML
    private MonthCalendar mayoCalendar;
    @FXML
    private MonthCalendar junioCalendar;
    @FXML
    private MonthCalendar julioCalendar;
    @FXML
    private MonthCalendar agostoCalendar;
    @FXML
    private MonthCalendar septiembreCalendar;
    @FXML
    private MonthCalendar octubreCalendar;
    @FXML
    private MonthCalendar noviembreCalendar;
    @FXML
    private MonthCalendar diciembreCalendar;

    @FXML
    private GridPane view;
	
	public Controller() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// bindings
		
		yearLabel.textProperty().bind(yearProperty.asString());
		
		eneroCalendar.yearPropertyProperty().bind(yearProperty);
		febreroCalendar.yearPropertyProperty().bind(yearProperty);
		marzoCalendar.yearPropertyProperty().bind(yearProperty);
		abrilCalendar.yearPropertyProperty().bind(yearProperty);
		mayoCalendar.yearPropertyProperty().bind(yearProperty);
		junioCalendar.yearPropertyProperty().bind(yearProperty);
		julioCalendar.yearPropertyProperty().bind(yearProperty);
		agostoCalendar.yearPropertyProperty().bind(yearProperty);
		septiembreCalendar.yearPropertyProperty().bind(yearProperty);
		octubreCalendar.yearPropertyProperty().bind(yearProperty);
		noviembreCalendar.yearPropertyProperty().bind(yearProperty);
		diciembreCalendar.yearPropertyProperty().bind(yearProperty);
		
		// load data
		
		eneroCalendar.setMonthProperty(0);
		febreroCalendar.setMonthProperty(1);
		marzoCalendar.setMonthProperty(2);
		abrilCalendar.setMonthProperty(3);
		mayoCalendar.setMonthProperty(4);
		junioCalendar.setMonthProperty(5);
		julioCalendar.setMonthProperty(6);
		agostoCalendar.setMonthProperty(7);
		septiembreCalendar.setMonthProperty(8);
		octubreCalendar.setMonthProperty(9);
		noviembreCalendar.setMonthProperty(10);
		diciembreCalendar.setMonthProperty(11);
		
		yearProperty.set(Year.now().getValue());
		
	}
	
	@FXML
	void onPrevioAction(ActionEvent event) {
		yearProperty.set(yearProperty.get() - 1);
	}
	
	@FXML
	void onSiguienteAction(ActionEvent event) {
		yearProperty.set(yearProperty.get() + 1);
	}
	
	public GridPane getView() {
		return view;
	}

}
