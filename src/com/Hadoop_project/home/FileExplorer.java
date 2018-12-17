package com.Hadoop_project.home;

import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class FileExplorer 
{
	
	public static GridPane folder(String Path1)
	{

	   
		 GridPane grid = new GridPane();
		 grid.setPadding(new Insets(5));
		 grid.setHgap(5);
		 grid.setVgap(5);
	  
	    
	    String Path=Path1;
        
        try { 
            
     	   	if(Path.length()!=0)
     	   	{
                Process p = Runtime.getRuntime().exec(Path);
                
                BufferedReader stdInput = new BufferedReader(new 
                     InputStreamReader(p.getInputStream()));

                BufferedReader stdError = new BufferedReader(new 
                     InputStreamReader(p.getErrorStream()));
                	ArrayList<String> as=new ArrayList<>();
                	
                	
                System.out.println("Here is the standard output of the command:\n");
                while ((Path = stdInput.readLine()) != null) 
                {
                    System.out.println(Path);
                    as.add(Path.substring(Path.indexOf("/")+1,Path.length()));
                   // flow.getChildren().add(new Button(Path.substring(Path.indexOf("/")+1,Path.length())));
                  
                 }

                String S[]=new String[as.size()];
              int counter=0;
              
                for(String s:as)
                	S[counter++]=s;
                
                int counter1=0;
               int r=0;
                    for (int c = 0; c<5; c++) 
                    {
                    	if(r%2==0)
                    	{
              
                    		Image img = new Image("https://lh3.googleusercontent.com/rNtKm9tBpcrOdTC3BAMFmPhd1oOvnt--GJgOdXWhkzyKp0kYYF8dkXS0krdO4QLRhCEz9zKc=s50-h50-e365");
                    		ImageView imgView = new ImageView(img);
                    		grid.setConstraints(imgView,c,r);
                    		grid.getChildren().add(imgView);
                    		if(c==4)
                            {
                            	r++;
                            	c=0-1;
                            }
                    	}
                    	else
                    	{
                    	if(counter1<S.length)
                    	{
                    		System.out.println("String is"+S[counter1]);
                        
                    		
                        grid.add(new Label(S[counter1]),c, r);
                        
                        counter1++;
                        if(c==4)
                        {
                        	r++;
                        	c=0-1;
                        }
                    	
                    	}
                    	}
                    }
                    	
                    
                

                
                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((Path = stdError.readLine()) != null) {
                    System.out.println(Path);
                    as.add(Path);
                }
                
               
                
                
              
                
            }
        }
            catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
                System.exit(-1);
            }
	    
		return grid;
		
	}
	
}
