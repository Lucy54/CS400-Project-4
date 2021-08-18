// --== CS400 File Header Information ==--
// Name: <Jacob Donovan>
// Email: <jdonovan3@wisc.edu>
// Team: <GD>
// Role: <Front End 2>
// TA: <Dan Kiel>
// Lecturer: <Dahl>
// Notes to Grader: <optional extra notes>

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import javafx.event.*;

/**
 * Class that creates the JavaFX singer database application and the methods for it
 * 
 * @author Jacob
 *
 */
public class FrontEnd extends Application {

  // private static BackEnd backEnd = new BackEnd(); // creates a new back end object
  private static Loader loader = new Loader();
  /**
   * This method creates the JavaFX application display and the
   * functionality of the buttons, text input, and output
   * 
   * @param the stage that the program is built on
   */
  @Override
  public void start(Stage stage) throws Exception {
    // sets the title of the application stage
    stage.setTitle("Singer Database");

    // the output text of the program
    Text output = new Text();

    // creating and designing the welcome message
    Text textFieldInput = new Text("Welcome to the singer database!\nPlease enter a singer's name");
    textFieldInput.setFill(Color.WHITE);
    textFieldInput.setTextAlignment(TextAlignment.CENTER);
    textFieldInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));;

    // creates an image object to be used as the background
    InputStream stream = new FileInputStream("micCrC.jpg");
    Image image = new Image(stream);
    ImagePattern pattern = new ImagePattern(image);
    BackgroundImage bgImg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
      BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
      new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(bgImg);

    // pane to hold the welcome message text and to add a background to
    StackPane pane = new StackPane();
    pane.getChildren().addAll(textFieldInput);
    StackPane.setAlignment(textFieldInput, Pos.CENTER);
    pane.setBackground(background);

    // text input bar
    TextField singerInput = new TextField();

    // creates the search button
    Button searchButton = new Button("Search");
    searchButton.setMinWidth(75);
    searchButton.setOnAction(e -> {
      String input = singerInput.getText();
      if (singerInput.getText().equals("")) {
        errorMessage("No singer entered");
      } else if (getSinger(singerInput.getText()) == null) {
        errorMessage("Entered singer does not exist in the database");
      }
      else {
        output.setText(getSinger(input));
      }
      singerInput.setText("");
    });

    // creates pop up box for adding new singers
    TextField textInputSong1 = new TextField();
    TextField textInputSong2 = new TextField();
    TextField textInputSong3 = new TextField();

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));
    grid.add(new Label("Song 1:"), 0, 0);
    grid.add(textInputSong1, 1, 0);
    grid.add(new Label("Song 2:"), 0, 1);
    grid.add(textInputSong2, 1, 1);
    grid.add(new Label("Song 3:"), 0, 2);
    grid.add(textInputSong3, 1, 2);
    Button closeBox = new Button("Enter");
    closeBox.setMinWidth(75);
    Button cancel = new Button("Cancel");
    cancel.setMinWidth(75);
    HBox popupButtons = new HBox();
    popupButtons.getChildren().addAll(closeBox, cancel);
    grid.add(popupButtons, 0, 3);

    // creates the add button
    Button addButton = new Button("Add");
    addButton.setMinWidth(75);
    Scene addPopupStage = new Scene(grid, 400, 200);
    addButton.setOnAction(e -> {
      String input = singerInput.getText();
      if (singerInput.getText().equals("")) {
        errorMessage("No singer entered");
      } else if (loader.backEnd.containSinger(input)) {
        errorMessage("The singer entered already exists in the database");
      } else {
        Stage popupStage = new Stage();
        popupStage.setScene(addPopupStage);
        textInputSong1.setText("");
        textInputSong2.setText("");
        textInputSong3.setText("");
        popupStage.show();
        closeBox.setOnAction(a -> {
          addSinger(input, textInputSong1.getText(), textInputSong2.getText(),
            textInputSong3.getText());
          popupStage.close();
          output.setText("Singer " + input + " successfully added!");
        });
      }
      singerInput.setText("");
    });

    // creates the remove button
    Button removeButton = new Button("Remove");
    removeButton.setMinWidth(75);
    removeButton.setOnAction(e -> {
      String input = singerInput.getText();
      if (singerInput.getText().equals("")) {
        errorMessage("No singer entered");
      } else if (!loader.backEnd.containSinger(input)) {
        errorMessage("Singer does not exist or was already removed");
      }
      else {
        removeSinger(input);
        output.setText("Singer " + input + " successfully removed");
      }
      singerInput.setText("");
    });

    // creates the display all singer button
    Button displayButton = new Button("Display");
    displayButton.setMinWidth(75);
    displayButton.setOnAction(e -> {
      output.setText(displayAllSingers());
    });

    // creates the button to explain button options
    Button helpButton = new Button("Help");
    helpButton.setMinWidth(75);
    helpButton.setStyle("-fx-background-color: Crimson;");
    helpButton.setOnAction(e -> {
      output.setText(
        "Search: retrieve the singer's stored songs\nAdd: add a new singer and three\nRemove: remove a singer and their song's from the database\nDisplay: print a list of all singers in the database");
    });

    // horizontal alignment for the buttons
    HBox buttonHbox = new HBox(5);
    buttonHbox.getChildren().addAll(searchButton, addButton, removeButton, displayButton,
      helpButton);
    buttonHbox.setAlignment(Pos.TOP_CENTER);

    // page layout
    GridPane pageLayout = new GridPane();
    pageLayout.setPadding(new Insets(0, 10, 0, 10));
    pageLayout.setMinSize(425, 375);
    pageLayout.setAlignment(Pos.CENTER);

    // setting row height
    RowConstraints row1 = new RowConstraints();
    row1.setMinHeight(150);
    RowConstraints row2 = new RowConstraints();
    row2.setMinHeight(50);
    RowConstraints row3 = new RowConstraints();
    row3.setMinHeight(50);
    RowConstraints row4 = new RowConstraints();
    row4.setMinHeight(100);

    // adding the groups to the row
    pageLayout.getRowConstraints().addAll(row1, row2, row3, row4);
    pageLayout.add(pane, 0, 0);
    pageLayout.add(singerInput, 0, 1);
    pageLayout.add(buttonHbox, 0, 2);

    // creating scrolling window for when the output reaches a maximum size
    ScrollPane sp = new ScrollPane();
    sp.setVmax(400);
    sp.setPrefSize(400, 100);
    sp.setContent(output);
    pageLayout.add(sp, 0, 3);

    // pageLayout.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
    pageLayout.setStyle("-fx-background-color: black");
    sp.setStyle("-fx-background:LightGray");

    // setting and showing the page
    Group root = new Group(pageLayout);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
  }

  /**
   * Helper method that display the error message used by each button in the application
   */
  private void errorMessage(String string) {
    Alert error = new Alert(AlertType.ERROR);
    error.setHeaderText("Invalid input");
    error.setContentText("" + string);
    error.show();
  }

  /**
   * Retrieves a singer's name and songs and returns them in a string to be printed to
   * the application's output display
   * 
   * @param a string containing the name of the singer which acts as the key
   * @return a formatted string containing the singer and their songs and false if it is not found
   */
  public String getSinger(String singer) {
    if (loader.backEnd.containSinger(singer)) {
      Song song = loader.backEnd.getSinger(singer);
      return "" + song.getSingerName() + "\n" + song.getFirstSong() + "\n" + song.getSecondSong()
        + "\n" + song.getThirdSong();
    }
    return null;
  }

  /**
   * Adds a new singer to the database based on the singer and songs specified by the user
   * 
   * @param the singer's name which also acts as the key
   * @param the first song to be added
   * @param the second song to be added
   * @param the third song to be added
   * @return true if the singer is added and false if the singer already exists in the database
   */
  public boolean addSinger(String singer, String song1, String song2, String song3) {
    if (loader.backEnd.containSinger(singer)) {
      return false;
    }
    Song newSong = new Song(singer, song1, song2, song3);
    loader.backEnd.addSinger(singer, newSong);
    return true;
  }

  /**
   * Removes a specified singer from the database
   * 
   * @param the singer's name which acts as the key
   * @return true if the singer is removed and false if the singer does not exist in the database
   */
  public boolean removeSinger(String singer) {
    if (!loader.backEnd.containSinger(singer)) {
      return false;
    }
    loader.backEnd.removeSinger(singer);
    return true;
  }

  /**
   * Method that displays a list of all singers in the database printed to the screen
   * 
   * @return a string containing a formatted list of all the names of the singers in the database
   */
  public String displayAllSingers() {
    String string = "";
    for (int i = 0; i < BackEnd.allSingers.size(); i++) {
      string += (i + 1) + ". " + BackEnd.allSingers.get(i).getSingerName() + "\n";
    }
    return string;
  }

  /**
   * Main method that launches the application
   */
  public static void main(String[] args) {
    Application.launch();
  }

}
