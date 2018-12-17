
package org.hadoop.testing;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Testing extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
     	Group root = new Group();
        Scene scene = new Scene(root,750,500, Color.WHITE);
        ScrollPane scrollPane = new ScrollPane();
        
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(70, 50, 50, 50));
        vbox1.setSpacing(15);
        
        
        Button buttonLoad = new Button(".csv");
    String str=null;
        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	  FileChooser fileChooser = new FileChooser();
                  FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files (*.csv)", "*.csv");
                  fileChooser.getExtensionFilters().add(extFilter);
                  File file = fileChooser.showOpenDialog(primaryStage);
           //       System.out.println(file);
                  
            }
        });
        Button movetohdfs = new Button("move");
     
        vbox1.getChildren().add(buttonLoad);
        vbox1.getChildren().add(movetohdfs);
        scrollPane.setContent(vbox1); 
        scene.setRoot(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


	

}
