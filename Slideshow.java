//import nesssesary classes
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.io.File;

public class Slideshow extends Application{
	public void start(Stage primaryStage) throws InterruptedException{
		//StackPane pane = new StackPane(); //create pane
		File imageDirectory = new File("image"); //create a File object of the image Directory
		ArrayList<Scene> scenes = new ArrayList<Scene>(0); //create an arraylist of strings for the filenames
		for (String image : imageDirectory.list()){
			//images.add("image/" + image); //add the name of each file in the image directory to the arraylist, after appending "/image" to the beginning, so that the path is correct
			scenes.add(new Scene(new StackPane(new ImageView("image/" + image)), 968, 648));
		}

		Scene title = new Scene(new StackPane(new Label("Slideshow")), 968, 648);
		primaryStage.setTitle("Slideshow"); //set the title
		primaryStage.setScene(title); //set the scene
		primaryStage.show(); //show the stage
		System.out.println("Displaying title scene");
		//Thread.sleep(5000);
		//primaryStage.setScene(scenes.get(0));

		for (Scene scene : scenes){
			//Thread.sleep(5000);
			System.out.println("Slept for five seconds");
			primaryStage.setScene(scene);
			System.out.println("displaying image " + scene);
	    }

	   
	    System.out.println("All images displayed");
	}


	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
	
}