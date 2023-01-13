package dad.calendario.component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MonthCalendar extends GridPane implements Initializable {
	
	// model
	
	private static ListProperty<String> meses = new SimpleListProperty<>(FXCollections.observableArrayList("enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"));
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();
	
	// view
	
	@FXML
    private Label nombreMesLabel;

    @FXML
    private GridPane view;
    
    public MonthCalendar() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MonthCalendar.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// listeners
		
		yearProperty.addListener(this::onYearChanged);
		monthProperty.addListener(this::onMonthChanged);
		
	}

	private void onYearChanged(ObservableValue<? extends Number> o, Number ov, Number nv) {
		
		if(nv != null) {
			changeMonth(nv.intValue(), monthProperty.get());
		}
		
	}
	

	private void onMonthChanged(ObservableValue<? extends Number> o, Number ov, Number nv) {
		
		if(nv != null) {
			nombreMesLabel.setText(meses.get(nv.intValue()));
			changeMonth(yearProperty.get(), nv.intValue());
		}
		
	}
	
	
	private void changeMonth(int year, int month) {
		
		LocalDate initial = LocalDate.of(year, month + 1, 13);
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.getMonth().length(initial.isLeapYear()));
		
		int dia = 1;
		for(int i = 8; i <= (view.getColumnCount() * view.getColumnCount()); i++) {
			
			if(i >= start.getDayOfWeek().getValue() + 7 && dia <= end.getDayOfMonth())
				((Label) view.getChildren().get(i)).setText(dia++ + "");
			else
				((Label) view.getChildren().get(i)).setText("");
		}
		
	}

	public final IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}

	public final int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}

	public final void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
	}

	public final IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}

	public final int getYearProperty() {
		return this.yearPropertyProperty().get();
	}

	public final void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}
	
}
