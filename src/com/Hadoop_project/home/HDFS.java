package com.Hadoop_project.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HDFS 
{
public static VBox Start()
{
	HBox hbox = new HBox(5);
	hbox.setPadding(new Insets(10,50,10, 50));
	hbox.setSpacing(10);
	
	
	VBox vb = new VBox();
    vb.setPadding(new Insets(10, 50, 50, 50));
    vb.setSpacing(10);
    vb.getChildren().add(hbox);
    TextField txt1 =new TextField();
    TextArea output1 =new TextArea();
    output1.setPrefColumnCount(37);
    Button jps = new Button();
    jps.setText("JPS");
    jps.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
           String S="jps";
          
           try {
               
        	   	if(S.length()!=0)
        	   	{
                   Process p = Runtime.getRuntime().exec(S);
                   
                   BufferedReader stdInput = new BufferedReader(new 
                        InputStreamReader(p.getInputStream()));

                   BufferedReader stdError = new BufferedReader(new 
                        InputStreamReader(p.getErrorStream()));
                   	ArrayList<String> as=new ArrayList<>();
                   // read the output from the command
                   System.out.println("Here is the standard output of the command:\n");
                   while ((S = stdInput.readLine()) != null) 
                   {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   // read any errors from the attempted command
                   System.out.println("Here is the standard error of the command (if any):\n");
                   while ((S = stdError.readLine()) != null) {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   String output = "";
                   java.util.Iterator<String> it=as.iterator();
                   while(it.hasNext())
                   {
                	   output += it.next() + "\n";
                	   
                	  
                   }
                   output1.setText(output);
        	   	}
        	   	else
        	   		output1.setText(" WARNING!!! please enter the command");
                   
               }
               catch (IOException e) {
                   System.out.println("exception happened - here's what I know: ");
                   e.printStackTrace();
                   System.exit(-1);
               }
        }
    });
    hbox.getChildren().add(jps);
    
    
    
    
   
    txt1.setPrefWidth(400);
    hbox.getChildren().add(txt1);
    
    HBox hbox1 = new HBox(5);
	hbox1.setPadding(new Insets(10,50,10, 50));
	hbox1.setSpacing(10);
	vb.getChildren().add(hbox1);
    Button ls = new Button();
    ls.setText("LS DIRECTORY");
    ls.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
           String S=txt1.getText();
           
           System.out.println("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -ls "+S);
       
           try {
               
        	   	if(S.length()!=0)
        	   	{
                   Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -ls "+S);
                   
                   BufferedReader stdInput = new BufferedReader(new 
                        InputStreamReader(p.getInputStream()));

                   BufferedReader stdError = new BufferedReader(new 
                        InputStreamReader(p.getErrorStream()));
                   	ArrayList<String> as=new ArrayList<>();
                   // read the output from the command
                   System.out.println("Here is the standard output of the command:\n");
                   while ((S = stdInput.readLine()) != null) 
                   {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   // read any errors from the attempted command
                   System.out.println("Here is the standard error of the command (if any):\n");
                   while ((S = stdError.readLine()) != null) {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   String output = "";
                   java.util.Iterator<String> it=as.iterator();
                   while(it.hasNext())
                   {
                	   output += it.next() + "\n";
                	   
                	  
                   }
                   output1.setText(output);
        	   	}
        	   	else
        	   		output1.setText(" WARNING!!! please enter the command");
                   
               }
               catch (IOException e) {
                   System.out.println("exception happened - here's what I know: ");
                   e.printStackTrace();
                   System.exit(-1);
               }
        }
    });
    
        
    hbox1.getChildren().add(ls);
   
    Button make = new Button();
    make.setText("MAKE DIRECTORY");
    make.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
           String S=txt1.getText();
           

       
           try {
               
        	   	if(S.length()!=0)
        	   	{
                   Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -mkdir "+S);
                   
                   BufferedReader stdInput = new BufferedReader(new 
                        InputStreamReader(p.getInputStream()));

                   BufferedReader stdError = new BufferedReader(new 
                        InputStreamReader(p.getErrorStream()));
                   	ArrayList<String> as=new ArrayList<>();
                   // read the output from the command
                   System.out.println("Here is the standard output of the command:\n");
                   while ((S = stdInput.readLine()) != null) 
                   {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   // read any errors from the attempted command
                   System.out.println("Here is the standard error of the command (if any):\n");
                   while ((S = stdError.readLine()) != null) {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   String output = "";
                   java.util.Iterator<String> it=as.iterator();
                   while(it.hasNext())
                   {
                	   output += it.next() + "\n";
                	   
                	  
                   }
                   output1.setText(output);
        	   	}
        	   	else
        	   		output1.setText(" WARNING!!! please enter the command");
                   
               }
               catch (IOException e) {
                   System.out.println("exception happened - here's what I know: ");
                   e.printStackTrace();
                   System.exit(-1);
               }
        }
    });
    
    hbox1.getChildren().add(make);
    
    Button remove = new Button();
    remove.setText("REMOVE DIRECTORY");
    remove.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
           String S=txt1.getText();
           

       
           try {
               
        	   	if(S.length()!=0)
        	   	{
                   Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -rmr "+S);
                   
                   BufferedReader stdInput = new BufferedReader(new 
                        InputStreamReader(p.getInputStream()));

                   BufferedReader stdError = new BufferedReader(new 
                        InputStreamReader(p.getErrorStream()));
                   	ArrayList<String> as=new ArrayList<>();
                   // read the output from the command
                   System.out.println("Here is the standard output of the command:\n");
                   while ((S = stdInput.readLine()) != null) 
                   {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   // read any errors from the attempted command
                   System.out.println("Here is the standard error of the command (if any):\n");
                   while ((S = stdError.readLine()) != null) {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   String output = "";
                   java.util.Iterator<String> it=as.iterator();
                   while(it.hasNext())
                   {
                	   output += it.next() + "\n";
                	   
                	  
                   }
                   output1.setText(output);
        	   	}
        	   	else
        	   		output1.setText(" WARNING!!! please enter the command");
                   
               }
               catch (IOException e) {
                   System.out.println("exception happened - here's what I know: ");
                   e.printStackTrace();
                   System.exit(-1);
               }
        }
    });
    
    hbox1.getChildren().add(remove);
    
    HBox hbox2 = new HBox(5);
	hbox2.setPadding(new Insets(10,50,10, 50));
	hbox2.setSpacing(10);
	vb.getChildren().add(hbox2);
    Label select = new Label();
    select.setText("       INPUT FILE PATH");
    hbox2.getChildren().add(select);
    TextField txt2=new TextField();
    TextField txtfile = new TextField();

    
    Button dfs = new Button();
    dfs.setText("MOVE DATA TO HDFS");
    dfs.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
           String S=txtfile.getText();
           String S1=txt2.getText();

           System.out.println("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -put "+S+" "+S1);
           try {
               
        	   	if(S.length()!=0)
        	   	{
                   Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -put "+S+" "+S1);
                   
                   BufferedReader stdInput = new BufferedReader(new 
                        InputStreamReader(p.getInputStream()));

                   BufferedReader stdError = new BufferedReader(new 
                        InputStreamReader(p.getErrorStream()));
                   	ArrayList<String> as=new ArrayList<>();
                   // read the output from the command
                   System.out.println("Here is the standard output of the command:\n");
                   while ((S = stdInput.readLine()) != null) 
                   {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   // read any errors from the attempted command
                   System.out.println("Here is the standard error of the command (if any):\n");
                   while ((S = stdError.readLine()) != null) {
                       System.out.println(S);
                       as.add(S);
                   }
                   
                   String output = "";
                   java.util.Iterator<String> it=as.iterator();
                   while(it.hasNext())
                   {
                	   output += it.next() + "\n";
                	   
                	  
                   }
                   output1.setText(output);
        	   	}
        	   	else
        	   		output1.setText(" WARNING!!! please enter the command");
                   
               }
               catch (IOException e) {
                   System.out.println("exception happened - here's what I know: ");
                   e.printStackTrace();
                   System.exit(-1);
               }
        }
    });
    
    hbox2.getChildren().add(dfs);
    
    Label outputpath = new Label();
    outputpath.setText("OUTPUT PATH");
    hbox2.getChildren().add(outputpath);
    
    HBox hbox3 = new HBox(5);
    hbox3.setPadding(new Insets(10,50,10, 50));
	hbox3.setSpacing(10);
	vb.getChildren().add(hbox3);
    
	txtfile.setPrefWidth(250);
    hbox3.getChildren().add(txtfile);
    
    
    txt2.setPrefWidth(250);
    hbox3.getChildren().add(txt2);
    
   
    HBox hbox4 = new HBox(5);
    hbox4.setPadding(new Insets(10,50,10, 50));
	hbox4.setSpacing(10);
  
    hbox4.getChildren().add(output1);
    vb.getChildren().add(hbox4);
    return vb;
}

}
