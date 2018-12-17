package com.Hadoop_project.home;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Home extends Application 
{

	String path="/home/home/Desktop/hadoop-2.6.0/bin/./hadoop fs -ls /";
	public static void main(String[] args)
	{
        Application.launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<>();
		al.add("HOME");
		al.add("HDFS");
		al.add("PIG DATACLEANING");
		al.add("HIVE DATACLEANING");
		al.add("Algorithms Instructions");
		al.add("data_transformation");
		al.add("Algorithms");
		al.add("File Explorer");
		primaryStage.setTitle("HADOOP PROJECT");
		Group root = new Group();
        Scene scene = new Scene(root,750,500, Color.WHITE);
        ScrollPane scrollPane = new ScrollPane();
        TabPane tabPane = new TabPane();
   
        
        ArrayList<Tab> addtab=new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {
        	addtab.add(new Tab(al.get(i)));
        }
        
        int counter=0;
        
        for(Tab tab1:addtab)
        	tabPane.getTabs().add(tab1);
        
        
        
        
        HBox hbox = new HBox();
        
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(70, 50, 50, 50));
        vbox1.setSpacing(15);
        
       
        Label label2 = new Label("OUTPUT");
        label2.setFont(new Font("Arial", 30));
        vbox1.getChildren().add(label2);
        TextField textField = new TextField ();
        textField.setPromptText("ENTER THE UNIX COMMAND");
        vbox1.getChildren().add(textField);
        TextArea txtarea=new TextArea();
        txtarea.setPrefColumnCount(22);
        txtarea.setPrefRowCount(10);;
        vbox1.getChildren().add(txtarea);
        
      
        Button btn = new Button();
        btn.setText("CLEAR");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            textField.setText("");
            txtarea.setText("");
            }
        });
        vbox1.getChildren().add(btn);
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(70, 50, 50, 50));
        vbox.setSpacing(15);
        
        
        
        
        
        hbox.getChildren().add(vbox);
        hbox.getChildren().add(vbox1);
       
        Label label1 = new Label("HADOOP UI");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.web("#0076a3"));
        vbox.getChildren().add(label1);
        
        Button btn1 = new Button();
        btn1.setText("UNIX COMMAND");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String S=textField.getText();
              
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
                       txtarea.setText(output);
            	   	}
            	   	else
            	   		txtarea.setText(" WARNING!!! please enter the command");
                       
                   }
                   catch (IOException e) {
                       System.out.println("exception happened - here's what I know: ");
                       e.printStackTrace();
                       System.exit(-1);
                   }
            }
        });
        vbox.getChildren().add(btn1);
        
        
        Button btn2 = new Button();
        btn2.setText("START HADOOP");
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String S;
                try {
           
                
  
                    Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/sbin/start-all.sh");
                    
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
                    txtarea.setText(output);
                    
                    
                }
                catch (IOException e) {
                    System.out.println("exception happened - here's what I know: ");
                    e.printStackTrace();
                    System.exit(-1);
                }
         }
     });
        
        vbox.getChildren().add(btn2);
        Button btn3 = new Button();
        btn3.setText("JPS  COMMAND");
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String S;
                try {
           
                
  
                    Process p = Runtime.getRuntime().exec("jps");
                    
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
                    txtarea.setText(output);
                    
                    
                }
                catch (IOException e) {
                    System.out.println("exception happened - here's what I know: ");
                    e.printStackTrace();
                    System.exit(-1);
                }
         }
     });
        vbox.getChildren().add(btn3);
        Button btn4 = new Button();
        btn4.setText("STOP  HADOOP");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               String S;
                try {
           
                
  
                    Process p = Runtime.getRuntime().exec("/home/home/Desktop/hadoop-2.6.0/sbin/stop-all.sh");
                    
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
                    txtarea.setText(output);
                    
                    
                }
                catch (IOException e) {
                    System.out.println("exception happened - here's what I know: ");
                    e.printStackTrace();
                    System.exit(-1);
                }
         }
     });
        vbox.getChildren().add(btn4);
        
       
           
        
        
        
       
        addtab.get(0).setContent(hbox);
        addtab.get(1).setContent(HDFS.Start());
        addtab.get(2).setContent(PIGUI.Start());
        addtab.get(3).setContent(HiveUI.Start());
        addtab.get(4).setContent(Algorithm_Instructions.Start());
        addtab.get(5).setContent(DATA_TRANSFORMATION.Start());
        addtab.get(6).setContent(Algorithm.Start());
        addtab.get(7).setContent(FileExplorer.folder(path));
        
        
        scrollPane.setContent(tabPane); 
        scene.setRoot(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.show();

	}

}
