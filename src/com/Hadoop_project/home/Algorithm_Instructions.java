package com.Hadoop_project.home;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Algorithm_Instructions
{
	public static VBox Start()
	{
		
		VBox vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);
        
        Label l1=new Label();
        l1.setText("INSTRUCTIONS FOR ALGORITHMS");
        vb.getChildren().add(l1);
        
        Label l2=new Label();
        l2.setText("1.DATASET MUST BE CONVERT TO .csv Format To .arff");
        vb.getChildren().add(l2);
        
        Label l3=new Label();
        l3.setText("2.DATASET MUST BE SPLITED To Training and Testing dataset");
        vb.getChildren().add(l3);
        
        Label l4=new Label();
        l4.setText("3.FOR Linear Regression All Dataset Must be in Numeric");
        vb.getChildren().add(l4);
        
       /* Label l5=new Label();
        l5.setText("4.");
        vb.getChildren().add(l5);
        
        Label l2=new Label();
        l1.setText("1.DATASET MUST BE CONVERT TO .csv Format To .arff");
        vb.getChildren().add(l1);
        
        Label l2=new Label();
        l1.setText("1.DATASET MUST BE CONVERT TO .csv Format To .arff");
        vb.getChildren().add(l1);
        
        Label l2=new Label();
        l1.setText("1.DATASET MUST BE CONVERT TO .csv Format To .arff");
        vb.getChildren().add(l1);*/
		
		return vb;
	}
}
