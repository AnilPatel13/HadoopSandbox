package com.Hadoop_project.home;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class DATA_TRANSFORMATION 
{

	public static VBox Start()
	{
		VBox vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(10);
        vb.getChildren().add(hb);
        
        Label l1=new Label();
        l1.setText("Convert to .arff");
        hb.getChildren().add(l1);
        
        TextField txt1=new TextField();
        txt1.setPromptText("enter the path of .csv file");
        hb.getChildren().add(txt1);
        
        TextField txt2=new TextField();
        txt2.setPromptText("enter the outhput path to save");
        hb.getChildren().add(txt2);
        
        Button btn = new Button();
        btn.setText("Convert");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	CSVLoader loader =new CSVLoader();
            	loader.setSource(new File(txt1.getText()));
            	Instances data=loader.getDataSet();
            	
            	ArffSaver saver=new ArffSaver();
            	saver.setInstances(data);
            	saver.setFile(new File(txt2.getText()));
            	saver.writeBatch();
            	
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("SUCCESS");
            	alert.setHeaderText("SUCCESS FULLY CONVERTED");
            	alert.setContentText("I have a great message for you!");

            	alert.showAndWait();
            	
            	
            }
            catch (Exception e) {
            	

            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("SUCCESS");
            	alert.setHeaderText("SUCCESS FULLY CONVERTED");
            	alert.setContentText("I have a great message for you!");
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb.getChildren().add(btn);
        
        HBox hb1 = new HBox();
        hb1.setPadding(new Insets(15, 12, 15, 12));
        hb1.setSpacing(10);
        vb.getChildren().add(hb1);
        
        Label l2=new Label();
        l2.setText("Convert to .csv");
        hb1.getChildren().add(l2);
        
        TextField txt3=new TextField();
        txt3.setPromptText("enter the path of .arff file");
        hb1.getChildren().add(txt3);
        
        TextField txt4=new TextField();
        txt4.setPromptText("enter the outhput path to save");
        hb1.getChildren().add(txt4);
        
        Button btn1 = new Button();
        btn1.setText("Convert");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArffLoader loader=new ArffLoader();
        		loader.setSource(new File(txt3.getText()));
        		Instances data=loader.getDataSet();
        		
        		
        		CSVSaver saver=new CSVSaver();
        		saver.setInstances(data);
        		saver.setFile(new File(txt4.getText()));
        		saver.writeBatch();
            	
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("SUCCESS");
            	alert.setHeaderText("SUCCESS FULLY CONVERTED");
            	alert.setContentText("I have a great message for you!");

            	alert.showAndWait();
            	
            	
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb1.getChildren().add(btn1);
        
        TextArea txtarea1=new TextArea();
        txtarea1.setPromptText("output");
        
        HBox hb2 = new HBox();
        hb2.setPadding(new Insets(15, 12, 15, 12));
        hb2.setSpacing(10);
        vb.getChildren().add(hb2);
        
        Label l3=new Label();
        l3.setText("Dataset summary:-1");
        hb2.getChildren().add(l3);
        
        TextField txt5=new TextField();
        txt5.setPromptText("enter path of dataset");
        hb2.getChildren().add(txt5);
        
        
        
        Button btn2 = new Button();
        btn2.setText("summary");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArrayList<String> as1=new ArrayList<>();
            	DataSource source =new DataSource(txt5.getText());
        		Instances data=source.getDataSet();
        		
        		if(data.classIndex()==-1)
        		{
        			data.setClassIndex(data.numAttributes()-1);
        		}
        		int numattr=data.numAttributes()-1;
        		
        		
        		for(int i=0;i<numattr;i++)
        		{
        			if(data.attribute(i).isNominal())
        			{
        				as1.add("the "+i+" th is nominal");
        				
        				System.out.println("the "+i+" th is nominal");
        			int n=data.attribute(i).numValues();
        			
        			as1.add("the "+i+" th attributes has "+n+" values");
        			System.out.println("the "+i+" th attributes has "+n+" values");
        			}
        			AttributeStats as=data.attributeStats(i);
        			int dc=as.distinctCount;
        			
        			as1.add("the "+i+" th attribute has: "+dc+" distinct count");
        			System.out.println("the "+i+" th attribute has: "+dc+" distinct count");
        			

        			if(data.attribute(i).isNumeric())
        			{
        				as1.add("the "+i+" th is numeric");
        				System.out.println("the "+i+" th is numeric");
        				Stats s=as.numericStats;
        				as1.add("the "+i+" th attributes has min value "+s.min+" and max value "+s.max+" and mean value is "+s.mean+" std dev is "+s.stdDev);
        			System.out.println("the "+i+" th attributes has min value "+s.min+" and max value "+s.max+" and mean value is "+s.mean+" std dev is "+s.stdDev);
        			}
        			
        		}
        		int numinst=data.numInstances();
        		for(int j=0;j<numinst;j++)
        		{
        			Instance instance=data.instance(j);
        			if(instance.isMissing(0))
        			{
        				as1.add("the "+0+" attribute is missing");
        				System.out.println("the "+0+" attribute is missing");
        			}
        			if(instance.classIsMissing())
        			{
        				as1.add("the class is missing in the "+j+" instances");
        				System.out.println("the class is missing in the "+j+" instances");
        			}
        			double cv=instance.classValue();
        			as1.add(instance.classAttribute().value((int)cv));
        			System.out.println(instance.classAttribute().value((int)cv));
        		}
            	
        		 String output = "";
        	        java.util.Iterator<String> it=as1.iterator();
        	        while(it.hasNext())
        	        {
        	     	   output += it.next() + "\n";
        	     	   
        	     	  
        	        }
        	        txtarea1.setText(output);
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb2.getChildren().add(btn2);
        
        HBox hb3 = new HBox();
        hb3.setPadding(new Insets(15, 12, 15, 12));
        hb3.setSpacing(10);
        vb.getChildren().add(hb3);
        
        hb3.getChildren().add(txtarea1);
        

        HBox hb4 = new HBox();
        hb4.setPadding(new Insets(15, 12, 15, 12));
        hb4.setSpacing(10);
        vb.getChildren().add(hb4);
        
        Label l4=new Label();
        l4.setText("remove the column");
        hb4.getChildren().add(l4);
        
        TextField txt6=new TextField();
        txt6.setPromptText("enter the path of .arff file");
        hb4.getChildren().add(txt6);
        
        TextField txt7=new TextField();
        txt7.setPromptText("no");
        txt7.setPrefColumnCount(4);
        hb4.getChildren().add(txt7);
        
        TextField txt8=new TextField();
        txt8.setPromptText("enter the path to save");
        hb4.getChildren().add(txt8);
        
        Button btn3 = new Button();
        btn3.setText("remove");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	DataSource source =new DataSource(txt6.getText());
        		Instances dataset=source.getDataSet();
        		System.out.println(txt7.getText());
        		String[] opts=new String[]{"-R",txt7.getText()};
        	Remove remove=new Remove();
        	remove.setOptions(opts);
        	remove.setInputFormat(dataset);
        	
        	Instances newdata=Filter.useFilter(dataset,remove);
        	
        	ArffSaver saver=new ArffSaver();
        	saver.setInstances(newdata);
        	saver.setFile(new File(txt8.getText()));
        	saver.writeBatch();
            	
            	
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb4.getChildren().add(btn3);
        
        HBox hb5 = new HBox();
        hb5.setPadding(new Insets(15, 12, 15, 12));
        hb5.setSpacing(10);
        vb.getChildren().add(hb5);
        
        Label l5=new Label();
        l5.setText("Auto Remove column (ID)");
        hb5.getChildren().add(l5);
        
        TextField txt9=new TextField();
        txt9.setPromptText("enter the path of .arff file");
        hb5.getChildren().add(txt9);
        
        TextField txt10=new TextField();
        txt10.setPromptText("enter the path to save");
        hb5.getChildren().add(txt10);
        
        Button btn4 = new Button();
        btn4.setText("Autoremove");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            DataSource source =new DataSource(txt9.getText());
    		Instances dataset=source.getDataSet();
    		
    		weka.filters.supervised.attribute.AttributeSelection filter=new weka.filters.supervised.attribute.AttributeSelection();
    		CfsSubsetEval eval=new CfsSubsetEval();
    		GreedyStepwise search=new GreedyStepwise();
    		search.setSearchBackwards(true);
    		filter.setEvaluator(eval);
    		filter.setSearch(search);
    		filter.setInputFormat(dataset);
    		Instances newdata=Filter.useFilter(dataset,filter);
    		
    		ArffSaver saver=new ArffSaver();
    		saver.setInstances(newdata);
    		saver.setFile(new File(txt10.getText()));
    		saver.writeBatch();
            	
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb5.getChildren().add(btn4);
        
     return vb;   
	}
}
