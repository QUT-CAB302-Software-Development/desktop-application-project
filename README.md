# Desktop Application with JavaFX

This is a sample application that demonstrates how to build a client-side desktop application with JavaFX. This application allows you to sign up for an account, log in, and view a list of users.

It is not required of you to use this application as a starting point for your project. You may choose to start from scratch, or use another sample application as a starting point. This application is provided as a reference for you to use if you find it helpful.

To create a JavaFX project in IntelliJ IDEA, follow the instructions in the [Creating a JavaFX Project](https://www.jetbrains.com/help/idea/javafx.html#create-javafx-project) tutorial.

## Dependencies

This project uses the following dependencies:

- Amazon Corretto 18
- JavaFX 11
- ControlsFX 11
- Spring Boot

***Note:** Other dependencies may be added to the project as needed.*

## Software Requirements

This project requires the following software:

- IntelliJ IDEA Community Edition
  - Download: https://www.jetbrains.com/idea/download/

Additionally, the following software is recommended:

- `Scene Builder`: Allows you to visually design JavaFX applications.
  - Download: https://gluonhq.com/products/scene-builder/#download
  - Configure with IntelliJ IDEA: https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html

## Getting Started

To get started, clone this repository and open the project in IntelliJ IDEA. 

### 1. Configure the Project SDK

To configure the project SDK, goto `File > Project Structure...` and select the `Project` tab. In the `SDK` dropdown, select `corretto-18`. 

If the `corretto-18` SDK is not available, you will need to download and install it. This can be done by clicking the `Add SDK > Download JDK...` button and select `Version: 18`, `Vendor: Amazon Corretto 18.0.2`.

### 2. Adding `client` as a Maven Project

In the project view, find the `pom.xml` file in the `client` directory. Right-click on the `pom.xml` file and select `Add as Maven Project` (at the bottom). This will add the `client` directory as a Maven project.

Maven will download the required dependencies defined in the `pom.xml` file.

If this is not done automatically, you may need to `Reload All Maven Projects` in IntelliJ IDEA if the project does not build successfully. This can be done by searching for `Reload All Maven Projects` in the `Search Everywhere` dialog (Ctrl + Shift + A).

### 3. Running the Application

To run the application, run the `main` method in the `example.client.HelloApplication` class, found in `client/src/main/java/example.client/HelloApplication.java`.

### Project Structure

The Java code for this project is located in the `client/src/main/java` directory. The `resources` directory contains the FXML files and the CSS files for the user interface.

Tests are located in the `client/src/test/java` directory.

## Recommended Tutorials

Please note that this is not an exhaustive list of tutorials. These are just some tutorials that I found helpful when I was learning JavaFX. You may find other tutorials more useful to you, depending on your learning style and your project requirements.

- Videos:
  - [(LinkedIn Learning) Create a User Interface - by Todd Perkins](https://www.linkedin.com/learning/learning-java-applications-14700256/creating-a-javafx-application?autoplay=true&resume=false&u=57080313) - This is a collection of short videos to get you started with JavaFX. It covers the following topics:
    - How to create a JavaFX application.
    - How to customise the application's user interface using FXML.
    - How to handle user input.
  - [(YouTube) JavaFX GUI Full Course - by Bro Code](https://www.youtube.com/watch?v=QqXQXo9oY6E) - This is rather long, but it covers a lot of ground.

- Articles / Guides:
  - [JavaFX - CSS](https://www.tutorialspoint.com/javafx/javafx_css.htm) - How to use CSS to style JavaFX applications.
  - [JavaFX Tutorial - by Jenkov](https://jenkov.com/tutorials/javafx/index.html) - There are a lot of tutorials here, please feel free to browse through them to find the ones that are most relevant to you.
  - [Official JavaFX Documentation](https://openjfx.io/javadoc/11/) - The official JavaFX documentation. This is a good place to look for information on specific JavaFX classes and methods.
  - [Connecting to a Database with JavaFX](https://edencoding.com/connect-javafx-with-sqlite/) - How to connect to a SQLite database from a JavaFX application.
