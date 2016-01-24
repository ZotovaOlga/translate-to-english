package com.couch.english;

import static javafx.application.Application.launch;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        
        Text logo = new Text(0,100,"English couch");
        logo.setFont(Font.font("Arial Black",25));
        logo.setFill(Color.web("#E8EAEB"));
        
        final InnerShadow innerShadow = new InnerShadow();
        innerShadow.setRadius(2);
        innerShadow.setOffsetX(-0.09);
        innerShadow.setOffsetY(-1.3);
        logo.setEffect(innerShadow);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(logo);
        vbox.setAlignment(Pos.TOP_CENTER);
        
        Label question = new Label(getQuestion());
        Label word = new Label(getWord());
        question.setId("questionLabel");
        word.setId("questionWordLabel");
        
        VBox centerVBox = new VBox();
        centerVBox.setAlignment(Pos.TOP_CENTER);
        centerVBox.getChildren().add(question);
        centerVBox.getChildren().add(word);
        centerVBox.getChildren().add(getAnswerButtons());
        
        BorderPane root = new BorderPane();
        root.setTop(vbox);
        root.setCenter(centerVBox);
        
        Scene scene = new Scene(root, 350, 170);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                KeyCode key = t.getCode();
                
                if (key == KeyCode.ESCAPE){
                    stage.close();
                }
            }
        });
        
        scene.getStylesheets().add("/styles/MainForm.css");
        
        stage.setTitle("English couch");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private String getQuestion() {
        return "How to trnaslate: ";
    }

    private String getWord() {
        return "success";
    }
    
    /*
    * Creates and populate box with button with correct and wrong answers
    */
    private VBox getAnswerButtons(){
        Button answer1 = new Button("Провал");
        Button answer2 = new Button("Удача");
        Button answer3 = new Button("Проникновение");
        Button answer4 = new Button("Удержание");
        
        answer1.getStyleClass().add("answerButton");
        answer2.getStyleClass().add("answerButton");
        answer3.getStyleClass().add("answerButton");
        answer4.getStyleClass().add("answerButton");
        
        answer1.setWrapText(true);
        answer2.setWrapText(true);
        answer3.setWrapText(true);
        answer4.setWrapText(true);

        answer1.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override 
                    public void handle(MouseEvent e) {
                        System.out.println("Wrong");
                    }
                });
        
        answer2.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override 
                    public void handle(MouseEvent e) {
                        System.out.println("Correct!!!");
                    }
                });
                
        answer3.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override 
                    public void handle(MouseEvent e) {
                        System.out.println("Wrong");
                    }
                });
                        
        answer4.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override 
                    public void handle(MouseEvent e) {
                        System.out.println("Wrong");
                    }
                });
        
        //Horisontal box
        HBox answerButtons = new HBox();
        answerButtons.setAlignment(Pos.CENTER);
        answerButtons.getChildren().addAll(answer1, answer2, answer3, answer4);
        answerButtons.setSpacing(2);
        
        //new vertical box
        VBox answerButtonsContainer = new VBox();
        answerButtonsContainer.getChildren().add(answerButtons);
        answerButtonsContainer.setAlignment(Pos.CENTER);
        
        return answerButtonsContainer;
    }
}
