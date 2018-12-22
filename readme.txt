ISCS 215 Final Project: Slideshow Image Viewer

The purpose of this application is to take a number of slides and turn them into a slideshow
that changes image every two seconds, while allowing the user to pause and resume the
slideshow by simply clicking on the screen. 

This application implements JavaFX. To begin, it creates an Arraylist of scenes. These
scenes will be used later in the program to switch the image. The program then uses a
Timeline method in Java to implement KeyFrames with a duration of 2 seconds, allowing
the scene to change every 2 seconds. This Timeline is set to continue indefinitely, with
an EventHandler that will restart it from the beginning if all images have been displayed. 
A StackPane is implemented in order to register mouse clicks, which will pause or play
the slide show depending on the curent status of the slideshow. For all of these methods,
written descriptions are printed in the console for ease of use and debugging. The algorithm
is as optimized as possible.

Development problems included difficulties with using the most efficient methods in order to
play a slideshow. One of our scrapped methods made use of multiple arrays and ArrayLists in 
order to simply play the slideshow. There were also problems with images. Since the images
come from a folder on the users directory, we had to be careful to make sure that the
program referenced an ArrayList so that changing the directory would not require altering
the entire program. User input was also a challenge. In order to play and pause the 
slideshow, we had to make the program consistently accept input accross the entire arrayList.
This was solved by using the aforementioned StackPane.


The Program implements the concepts of APIE in the following ways:

Abstraction: As mentioned before, in order to make the program easier work with, we had to
provide an absract reference to the files. Having a direct filepath to the images would have
made the code only usable on our machines, so we had to implement an ArrayList that would
allow us to reference the images later in the program without worrying about it referencing
the exact file path. The implementation of a GUI also shows a level of abstraction, as the 
user interacts with a much simpler interface as opposed to the console and direct code. 

Polymorphism: To implement Polymorphism, we wanted to make the program usable for more than
our set of images. This means that the program is compatible with any set of images, of any
name, length, file type, duration, and size. To do this, we made the file path non-specific,
and made the ArrayList dynamic so it would work with any number of files. As long as the file path
is defined to begin with, a user can create virtually any slideshow they want. 

Inheritance: The application makes use of various JavaFX classes for efficiency and 
simplicity. More specifically, it imports the Timeline class, the Keyframes class, the 
ImageView class, and the Duration class in order to create the slideshow. If we had created
these functions within the program, the program would be very unoptimized and inefficient, 
so we made use of classes that come with JavaFX in order to run our program

Encapsulation: All good programs need to have some level of security. In our case, we made
any variables we would have to use private to prevent tampering. Also, by using an ArrayList,
the slideshow will continue to work even if the files change while it is running. This makes
the program tamper-proof to a certain degree. 