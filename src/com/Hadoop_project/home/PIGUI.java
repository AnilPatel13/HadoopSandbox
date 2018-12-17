package com.Hadoop_project.home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PIGUI
{
	public static HBox Start()
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		 HBox hb = new HBox();
	        hb.setPadding(new Insets(15, 12, 15, 12));
	        hb.setSpacing(10);
	        
	        VBox vb = new VBox();
	        vb.setPadding(new Insets(10, 50, 50, 50));
	        vb.setSpacing(10);
	        
	        TextArea txt1=new TextArea();
	        txt1.setPromptText("Enter the pig Querry Here.");
	        vb.getChildren().add(txt1);
	        
	        TextArea txt2=new TextArea();
	        txt2.setPromptText("output");
	        
	        
	        Button btn = new Button();
	        btn.setText("Run Pig Script");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                
	            	 ObservableList<CharSequence> paragraph = txt1.getParagraphs();
	            	    Iterator<CharSequence>  iter = paragraph.iterator();
	            	    try
	            	    {
	            	        BufferedWriter bf = new BufferedWriter(new FileWriter(new File("/home/home/Desktop/pigfiles/file1.pig")));
	            	        while(iter.hasNext())
	            	        {
	            	            CharSequence seq = iter.next();
	            	            bf.append(seq);
	            	            bf.newLine();
	            	        }
	            	        bf.flush();
	            	        bf.close();
	            	    }
	            	    catch (IOException e)
	            	    {
	            	        e.printStackTrace();
	            	    }
	            	    
	            	    
	            	String Path="/home/home/Desktop/pig-0.16.0/bin/pig -x local /home/home/Desktop/pigfiles/file1.pig";
	            	try{
	            		
	            	 
	            	Process p = Runtime.getRuntime().exec(Path);
	                
	                BufferedReader stdInput = new BufferedReader(new 
	                     InputStreamReader(p.getInputStream()));

	                BufferedReader stdError = new BufferedReader(new 
	                     InputStreamReader(p.getErrorStream()));
	                	ArrayList<String> as=new ArrayList<>();
	                	
	                	
	                System.out.println("Here is the standard output of the command:\n");
	                while ((Path = stdInput.readLine()) != null) 
	                {
	                	as.add(Path);
	                }
	                String output = "";
	                java.util.Iterator<String> it=as.iterator();
	                while(it.hasNext())
	                {
	             	   output += it.next() + "\n";
	             	   
	             	  
	                }
	                txt2.setText(output);
	            	}
	            	catch (Exception e) {
						e.printStackTrace();
					}
	            }
	        });
	        vb.getChildren().add(btn);
	        
	        Button btn2 = new Button();
	        btn2.setText("Clear");
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                txt1.setText("");
	                txt2.setText("");
	            }
	        });
	        vb.getChildren().add(btn2);
	        
	       
	        
	        
	        vb.getChildren().add(txt2);
	        
	        hb.getChildren().add(vb);
		
		
		
		return hb;
		
	}
}
