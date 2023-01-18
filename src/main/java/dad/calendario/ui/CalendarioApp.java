package dad.calendario.ui;

import dad.calendario.ui.controllers.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

	private Controller controller = new Controller();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		controller.getView().getStylesheets().add(getClass().getResource("/style/calendario.css").toExternalForm());
		
		primaryStage.setTitle("Calendario");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.getIcons().add(new Image(getClass().getResource("/images/calendar-32x32.png").toString()));
		primaryStage.show();
		
	}

}
