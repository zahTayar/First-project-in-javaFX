package Program;

import javafx.application.Application;
import javafx.stage.Stage;
public class Program extends Application{

	public static void main(String[] args) {
		launch(args);
		

	}

	@Override
	public void start(Stage stage) throws Exception {
		View.View view=new View.View(stage);
		Model.Model model=new Model.Model();
		Controller.Controller controller=new Controller.Controller(model,view);
		
		
	}

}
