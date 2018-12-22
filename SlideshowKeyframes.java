//import nesssesary classes
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.io.File;
import javafx.util.Duration;



public class SlideshowKeyframes extends Application{
	int currentImage = 0;
	public void start(Stage primaryStage) throws InterruptedException{
		StackPane pane = new StackPane(); //create pane
		File imageDirectory = new File("image"); //create a File object of the image Directory
		Scene title = new Scene(new StackPane(new Label("Slideshow of ./image")));
		ArrayList<Scene> scenes = new ArrayList<Scene>(0); //create an arraylist of strings for the filenames
		for (String image : imageDirectory.list()){
			//images.add("image/" + image); //add the name of each file in the image directory to the arraylist, after appending "/image" to the beginning, so that the path is correct
			scenes.add(new Scene(new StackPane(new ImageView("image/" + image)), 968, 648));
		}

		primaryStage.setTitle("Slideshow"); //set the title
		primaryStage.setScene(title);
		primaryStage.show(); //show the stage
		

		EventHandler<ActionEvent> eventHandler = e -> {
			if (currentImage >= scenes.size()){
				currentImage = 0;
				System.out.println("looping back to the beginning");
			}
			primaryStage.setScene(scenes.get(currentImage++));
			System.out.println("Displaying image no. " + currentImage);
		};

		Timeline slideshow = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));
		slideshow.setCycleCount(Timeline.INDEFINITE);
		slideshow.play();
		//primaryStage.show();

		/*for (Scene scene : scenes){
			//Thread.sleep(5000);
			System.out.println("Slept for five seconds");
			primaryStage.setScene(scene);
			System.out.println("displaying image " + scene);
	    }*/

	   
	    pane.setOnMouseClicked(e -> {
	    	System.out.println("Mouse Clicked");
	    	if (slideshow.getStatus() == Animation.Status.PAUSED){
	    		slideshow.play();
	    		System.out.println("Pausing slideshow");
	    	}
	    	else{
	    		slideshow.pause();
	    		System.out.println("Playing slideshow");
	    	}
	    });
	}


	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
	
}