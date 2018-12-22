/*
Team: Ashlinn Barber-Woeltjen, Josh Aispuro, John Dofflemeyer
Date: 12/6/18
Assignment: Final Exam Project
Purpose: The purpose of this program is to show our understanding of some of the fundamental
programming concepts Abstraction, Polymorphism, Inheritance, and Encapsulaion (APIE)
and to show that we can build a functional program that uses a Graphical User Input (GUI).  
         
Time Spent on Project: 13hrs. 
"We Pledge that this program represents our own program code, We recieved help from 
the java Docs, our book, and class in designing and debugging our program."
*/

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.io.File;
import javafx.util.Duration;
//Abstraction: represents essential features of the java application without 
//including everything that the java appliction includes.
//Inheritance: extends the java application. Superclass: Application
public class SlideShow extends Application {
    //Current image counter
    //Encapsulation: private variable
    private int currentImage = 1;
    //Initialize an array list to store scenes
    ArrayList<Scene> scenes = new ArrayList<Scene>(0);
    
    
     
    //main field that houses the JavaFX information
    public void start(Stage primaryStage) throws InterruptedException{
      
        //creates an event handler that enables the slide show to restart once it has 
        //gone through the images
        EventHandler<ActionEvent> eventHandler = e -> {
        if (currentImage >= scenes.size()){
            currentImage = 0;
            System.out.println("looping back to the beginning");//for debugging purposes
        }
    	primaryStage.setScene(scenes.get(currentImage++));//chooses the next image based upon the counter
    	System.out.println("Displaying image no. " + currentImage);
        };
    
        //creates a timeline object slideShow 
        Timeline slideShow = new Timeline(new KeyFrame(Duration.seconds(2), eventHandler));

        File imageDirectory = new File("src/image/"); //create a File object of the image Directory
        
        //create an arraylist of strings for the filenames
        
        //Abstraction: We implemented an ArrayList that allows us to reference 
        //the images later in the program without worrying about it referencing
        //the exact file path everytime the for loop ran.
        //Polymorphism: We allow the program to be compatable with  any set of images no matter the size
        for (String image : imageDirectory.list()){
        
            //Creates new Stackpane for use in displaying images.       
            StackPane tempStack = new StackPane(new ImageView("image/"+image));
            Scene tempScene = new Scene(tempStack);//allows width and 
            tempScene.setOnMouseClicked(e -> {//plays and pauses the slideshow
    	    	System.out.println("Mouse Clicked");
    	    	if (slideShow.getStatus() == Animation.Status.PAUSED){
    	    		slideShow.play();
    	    		System.out.println("Playing slideshow");
    	    	}
    	    	else{
    	    		slideShow.pause();
    	    		System.out.println("Pausing slideshow");
    	    	}
            });
            //adds the recently created scene to the scenes array list.
            scenes.add(tempScene);           
        }  
    
        
        //sets an indefinite time limit to how long the slideshow can run
        slideShow.setCycleCount(Timeline.INDEFINITE);
        slideShow.play(); //causes the slideshow to play as soon as the program runs

        //Abstraction: implementation of a GUI also shows abstraction, user 
        //deals only with the GUI instead of the code.
        primaryStage.setTitle("Flag Slide Show"); //set the title
        primaryStage.setScene(scenes.get(0));//starts scenes with 0th index of scenes array list
        primaryStage.show(); //show the stage
    }
 
    
    public static void main(String[] args) {
		launch(args);
	}
    
    
}
