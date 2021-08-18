import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text; 
import java.util.ArrayList;
import javafx.scene.text.Font; 
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.scene.control.TextField;


public class App extends Application {

    private ArrayList<Button> buttons = new ArrayList<>();
    int AppWidth = 1200;
    int AppHeight = 600;
    BackEnd backEnd = new BackEnd();
    Stage stage;
    Scene mainScene;

    @Override
    public void start(final Stage stage) {
        this.stage = stage;

        this.stage.setTitle("Visual Database: Artist's Top Songs");
    
        Pane p1 = new Pane();

        Text title = new Text();
        title.setText("Welcome to Visual Database! \n\nThis database contains a list of singers," + 
            "and thier top three songs. \n\nTo get started, click on the buttons below.");
        title.setFont(new Font(30));
        title.setFill(Color.STEELBLUE);
        title.relocate(100,100);
        p1.getChildren().add(title);


        if (!createButtons()) {
            System.out.println("Failed to create buttons. Exiting application.");
            System.exit(-1);
        };

        if (!setUpButtonActions()) {
            System.out.println("Failed to setup button actions. Exiting application.");
            System.exit(-1);
        }

        for (Button b : buttons) {
            p1.getChildren().add(b);
        }
    
        Scene scene = new Scene(p1, AppWidth, AppHeight);
        this.mainScene = scene;
        this.stage.setScene(scene);
        this.stage.show();
    }

    private boolean createButtons() {

        int btnWidth = 150;
        int btnHeight = 50;

        Button b1 = new Button("List Artists");
        this.buttons.add(b1);

        Button b2 = new Button("View Artist");
        this.buttons.add(b2);

        Button b3 = new Button("Add Artist");
        this.buttons.add(b3);

        Button b4 = new Button("Remove Artist");
        this.buttons.add(b4);

        int spacing = (AppWidth - (buttons.size()*btnWidth))/5;
        int spacingCounter = 0;

        for (Button b : buttons) {
            b.setPrefHeight(btnHeight);
            b.setPrefWidth(btnWidth);
            b.relocate(spacingCounter + spacing, (2.0/3.0)*AppHeight);
            spacingCounter = spacingCounter + spacing + 150;
        }

        return true;

    }

    public boolean setUpButtonActions() {

        buttons.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!displayAllArtists()) {
                    System.out.println("Failed to display all artists.");
                    // Display Error to user.
                };
            }
        });

        buttons.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!viewArtist()) {
                    System.out.println("Failed to view artist.");
                    // Display Error to user.
                };
            }
        });

        buttons.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!addArtist()) {
                    System.out.println("Failed to add artist.");
                    // Display Error to user.
                };
            }
        });

        buttons.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!removeArtist()) {
                    System.out.println("Failed to remove artist.");
                    // Display Error to user.
                };
            }
        });

        return true;
    }



    public boolean displayAllArtists() {

        return false;
    }

    public boolean viewArtist() {

        return false;
    }

    public boolean addArtist() {

        Pane addArtistPane = new Pane();
        Text addArtistDirection = new Text();
        ArrayList<TextField> songBoxes = new ArrayList<>();

        addArtistDirection.setText("Enter the artist name, and top three songs.");
        addArtistDirection.setFont(new Font(30));
        addArtistDirection.setFill(Color.STEELBLUE);
        addArtistDirection.relocate(100,100);

        TextField artistNameInput = new TextField("Artist Name");
        artistNameInput.setPrefWidth(300);

        TextField song1 = new TextField("Name of Song 1");
        song1.setPrefWidth(300);
        songBoxes.add(song1);

        TextField song2 = new TextField("Name of Song 2");
        song2.setPrefWidth(300);
        songBoxes.add(song2);
        
        TextField song3 = new TextField("Name of Song 3");
        song3.setPrefWidth(300);
        songBoxes.add(song3);

        double spacing = (AppWidth - (3*300))/4;
        double counter = 0;

        for (TextField f : songBoxes) {
            f.relocate(counter + spacing, 400);
            counter = counter + spacing + 300;
        }  

        artistNameInput.relocate(spacing*2 + 300, 300);      

        Button confirmAddArtist = new Button("Confirm");
        confirmAddArtist.relocate((AppWidth-150)/2, 500);

        int btnWidth = 150;
        int btnHeight = 50;
        confirmAddArtist.setPrefHeight(btnHeight);
        confirmAddArtist.setPrefWidth(btnWidth);

        confirmAddArtist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = artistNameInput.getText();
                String song11 = song1.getText();
                String song22 = song2.getText();
                String song33 = song3.getText();
                backEnd.addSinger(name, new Song(name, song11, song22, song33));
                stage.setScene(mainScene);
            }
        });
                
        addArtistPane.getChildren().add(addArtistDirection);
        addArtistPane.getChildren().add(artistNameInput);
        addArtistPane.getChildren().add(song1);
        addArtistPane.getChildren().add(song2);
        addArtistPane.getChildren().add(song3);
        addArtistPane.getChildren().add(confirmAddArtist);

        Scene addArtistScene = new Scene(addArtistPane, AppWidth, AppHeight);

        this.stage.setScene(addArtistScene);
        this.stage.show();

        return true;
    }

    public boolean removeArtist() {

        return false;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
