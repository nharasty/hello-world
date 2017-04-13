
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
/**
 * Creates a random insult from a text file
 * Insult is outputted when button is clicked
 * 
 * @author (Nicholas Harasty) 
 * @version (04/10/17)
 */
public class InsultGenerator extends Application
{

    private Text outputText;
    ArrayList<String> adjectives1 = new ArrayList<String>();
    ArrayList<String> adjectives2 = new ArrayList<String>();
    ArrayList<String> nouns = new ArrayList<String>();

    /**
     * launches program
     * 
     * @param args does nothing
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    /**
     * stage creates program
     * 
     * @param primaryStage is stage
     * 
     */
    public void start(Stage primaryStage) throws FileNotFoundException
    {

        Scanner inFile = new Scanner(new File("insultData.txt"));

        while (inFile.hasNext())
        {

            adjectives1.add(inFile.next());
            adjectives2.add(inFile.next());
            nouns.add(inFile.next());

        }
        /**
        for (int i = 0; i < adjectives1.size(); i++)
        {
        System.out.println(adjectives1.get(i));
        }
         */

        Button insultButton = new Button("Insult Me!");
        insultButton.setOnAction(this::handleButton);

        outputText = new Text("---");
        outputText.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));

        VBox pane = new VBox(insultButton, outputText);
        pane.setStyle("-fx-background-color: lightgreen");
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(25);

        Scene scene = new Scene(pane, 600, 150);

        primaryStage.setTitle("Button Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> System.exit(0));
    }

    /**
     * if mouse clicks button create random insult
     * 
     * @param event is an Action event
     */
    public void handleButton(ActionEvent event)
    {
        
        
        Random a1 = new Random();
        
        int num1 = (a1.nextInt(adjectives1.size()));
        int num2 = (a1.nextInt(adjectives2.size()));
        int num3 = (a1.nextInt(nouns.size()));
        
        
        outputText.setText("Thou art a " + adjectives1.get(num1) + adjectives2.get(num2) + 
            nouns.get(num3) + "!");

    }
}
