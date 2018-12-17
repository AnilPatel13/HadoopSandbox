package com.Hadoop_project.home;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

public class Algorithm 
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
        l1.setText("Linear Regression Model");
        hb.getChildren().add(l1);
        
        TextField txt1=new TextField();
        txt1.setPromptText("enter the path of dataset");
        hb.getChildren().add(txt1);
        
        TextArea area1=new TextArea();
        area1.setPromptText("outhput");
        area1.setPrefColumnCount(30);
        
        Button btn = new Button();
        btn.setText("Build");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	DataSource source =new DataSource(txt1.getText());
        		Instances dataset=source.getDataSet();
        		dataset.setClassIndex(dataset.numAttributes()-1);
        /*LinearRegression lr=new LinearRegression();
        lr.buildClassifier(dataset);
        System.out.println(lr);*/
        	SMOreg reg=new SMOreg();
        	reg.buildClassifier(dataset);
        	System.out.println(reg);
            	area1.setText(reg.toString());
            	
            }
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb.getChildren().add(btn);
        
        
       
		
        
        HBox hb2 = new HBox();
        hb2.setPadding(new Insets(15, 12, 15, 12));
        hb2.setSpacing(10);
        vb.getChildren().add(hb2);
		
        Label l2=new Label();
        l2.setText("Linear Regression Model Evaluation");
        hb2.getChildren().add(l2);
        
        TextField txt2=new TextField();
        txt2.setPromptText("training set path");
        hb2.getChildren().add(txt2);
        
        TextField txt3=new TextField();
        txt3.setPromptText("testing set path");
        hb2.getChildren().add(txt3);
        
        Button btn1 = new Button();
        btn1.setText("Evaluate");
        btn1.setOnAction(new EventHandler<ActionEvent>()
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArrayList<String> as=new ArrayList<>();
            	DataSource source =new DataSource(txt2.getText());
        		Instances dataset=source.getDataSet();
        		dataset.setClassIndex(dataset.numAttributes()-1);
        	
        		/*J48 tree=new J48();
        		tree.buildClassifier(dataset);*/
        		SMOreg lr=new SMOreg();
        				lr.buildClassifier(dataset);
        		Evaluation eval=new Evaluation(dataset);
        		//Random rand=new Random(1);
        		//int folds=10;
        		
        		DataSource source1 =new DataSource(txt3.getText());
        		Instances testdataset=source.getDataSet();
        	testdataset.setClassIndex(testdataset.numAttributes()-1);
        	//val.crossValidateModel(tree,testdataset,folds,rand);
        	
        	
        	eval.evaluateModel(lr,testdataset);
        	
        	as.add(eval.toSummaryString("Evaluate result:\n",false));
        	System.out.println(eval.toSummaryString("Evaluate result:\n",false));
        	
        	as.add("corect % ="+eval.pctCorrect());
        	System.out.println("corect % ="+eval.pctCorrect());
        	
        	as.add("incorrect % ="+eval.pctIncorrect());
        	System.out.println("incorrect % ="+eval.pctIncorrect());
        	
        	//System.out.println("AUC % ="+eval.areaUnderROC(1));
        	//System.out.println("KAPPA % ="+eval.kappa());
        	as.add("RMSE % ="+eval.rootMeanSquaredError());
        	System.out.println("RMSE % ="+eval.rootMeanSquaredError());
        	
        	as.add("MSE % ="+eval.meanAbsoluteError());
        	System.out.println("MSE % ="+eval.meanAbsoluteError());
        	
        	as.add("RAE % ="+eval.relativeAbsoluteError());
        	System.out.println("RAE % ="+eval.relativeAbsoluteError());
        	
        	as.add("RRSE % ="+eval.rootRelativeSquaredError());
        	System.out.println("RRSE % ="+eval.rootRelativeSquaredError());
        	//System.out.println("precision % ="+eval.precision(1));
        	//System.out.println(eval.toMatrixString("===OVERALL CONFUSION MATRIX=== \n"));
            	
        	String output = "";
            java.util.Iterator<String> it=as.iterator();
            while(it.hasNext())
            {
         	   output += it.next() + "\n";
         	   
         	  
            }
            area1.setText(output);
            
            
            }
            
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb2.getChildren().add(btn1);
        
        
        HBox hb3 = new HBox();
        hb3.setPadding(new Insets(15, 12, 15, 12));
        hb3.setSpacing(10);
        vb.getChildren().add(hb3);
		
        Label l3=new Label();
        l3.setText("Linear Regression Model Predict");
        hb3.getChildren().add(l3);
        
        TextField txt4=new TextField();
        txt4.setPromptText("training set path");
        hb3.getChildren().add(txt4);
        
        TextField txt5=new TextField();
        txt5.setPromptText("testing set path");
        hb3.getChildren().add(txt5);
        
        Button btn2 = new Button();
        btn2.setText("predict");
        btn2.setOnAction(new EventHandler<ActionEvent>()
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArrayList<String> as=new ArrayList<>();
            	DataSource source =new DataSource(txt4.getText());
        		Instances dataset=source.getDataSet();
        		dataset.setClassIndex(dataset.numAttributes()-1);
        	
        		
        		SMOreg smo=new SMOreg();
        		smo.buildClassifier(dataset);
        		System.out.println(smo);
        		
        		
        		DataSource source1 =new DataSource(txt5.getText());
        		Instances testdataset=source.getDataSet();
        		testdataset.setClassIndex(testdataset.numAttributes()-1);
        		as.add("=========================");
        		as.add("Actual class,smo predicted");
        		System.out.println("=========================");
        		System.out.println("Actual class,smo predicted");
        		
        		for(int i=0;i<testdataset.numInstances();i++)
        		{
        			double actualclass=testdataset.instance(i).classValue();
        			//String actual=testdataset.classAttribute().value((int)actualclass);
        			
        			Instance newinst=testdataset.instance(i);
        			double predsmo=smo.classifyInstance(newinst);
        			
        			//String PredString=testdataset.classAttribute().value((int)prednb);
        			System.out.println(actualclass+", "+predsmo);
        			as.add(actualclass+", "+predsmo);
        		}
        		
        		 String output = "";
                 java.util.Iterator<String> it=as.iterator();
                 while(it.hasNext())
                 {
              	   output += it.next() + "\n";
              	   
              	  
                 }
                 area1.setText(output);
            }
            
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb3.getChildren().add(btn2);
        
        
        
        HBox hb4 = new HBox();
        hb4.setPadding(new Insets(15, 12, 15, 12));
        hb4.setSpacing(10);
        vb.getChildren().add(hb4);
		
        Label l4=new Label();
        l4.setText("CLUSTERING KMEANS");
        hb4.getChildren().add(l4);
        
        TextField txt6=new TextField();
        txt6.setPromptText("training set path");
        hb4.getChildren().add(txt6);
        
        TextField txt7=new TextField();
        txt7.setPromptText("testing set path");
        hb4.getChildren().add(txt7);
        
        TextField txt8=new TextField();
        txt8.setPromptText("no");
        txt8.setPrefColumnCount(3);
        hb4.getChildren().add(txt8);
        
        Button btn3 = new Button();
        btn3.setText("build");
        btn3.setOnAction(new EventHandler<ActionEvent>()
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArrayList<String> as=new ArrayList<>();
            	DataSource source =new DataSource(txt6.getText());
        		Instances dataset=source.getDataSet();
        	
        		SimpleKMeans model =new SimpleKMeans();
        		model.setNumClusters(4);
        		model.buildClusterer(dataset);
        		System.out.println(model);
        		as.add(model.toString());
        		
        		ClusterEvaluation clseval=new ClusterEvaluation();
        		DataSource source1 =new DataSource(txt7.getText());
        		Instances data1=source1.getDataSet();
        		
        		clseval.setClusterer(model);
        		clseval.evaluateClusterer(data1);
        		System.out.println("# of cluster "+clseval.getNumClusters());
            as.add("# of cluster "+clseval.getNumClusters());
            
            String output = "";
            java.util.Iterator<String> it=as.iterator();
            while(it.hasNext())
            {
         	   output += it.next() + "\n";
         	   
         	  
            }
            area1.setText(output);
            
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
        l5.setText("NAIVE BAYES");
        hb5.getChildren().add(l5);
        
        TextField txt9=new TextField();
        txt9.setPromptText("training set path");
        hb5.getChildren().add(txt9);
        
        TextField txt10=new TextField();
        txt10.setPromptText("testing set path");
        hb5.getChildren().add(txt10);
        
        
        Button btn4 = new Button();
        btn4.setText("predict");
        btn4.setOnAction(new EventHandler<ActionEvent>()
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            try
            {
            	ArrayList<String> as=new ArrayList<>();
            	DataSource source =new DataSource(txt9.getText());
        		Instances dataset=source.getDataSet();
        		dataset.setClassIndex(dataset.numAttributes()-1);
        	int numclasses=dataset.numClasses();
        	for(int i=0;i<numclasses;i++)
        	{
        		String classsvalue=dataset.classAttribute().value(i);
        		System.out.println("class value "+i+" is "+classsvalue);
        		as.add("class value "+i+" is "+classsvalue);
        	}
        	NaiveBayes nb=new NaiveBayes();
        	nb.buildClassifier(dataset);
        	
        	DataSource source1 =new DataSource(txt10.getText());
        	Instances testdataset=source.getDataSet();
        	testdataset.setClassIndex(testdataset.numAttributes()-1);
        	System.out.println("=========================");
        	as.add("=========================");
        	System.out.println("Actual class,nb predicted");
        	as.add("Actual class,nb predicted");
        	for(int i=0;i<testdataset.numInstances();i++)
        	{
        		double actualclass=testdataset.instance(i).classValue();
        		String actual=testdataset.classAttribute().value((int)actualclass);
        		
        		Instance newinst=testdataset.instance(i);
        		double prednb=nb.classifyInstance(newinst);
        		
        		String PredString=testdataset.classAttribute().value((int)prednb);
        		System.out.println(actual+", "+PredString);
        		as.add(actual+", "+PredString);
        	
        	
        	}
        	
        	 String output = "";
             java.util.Iterator<String> it=as.iterator();
             while(it.hasNext())
             {
          	   output += it.next() + "\n";
          	   
          	  
             }
             area1.setText(output);
            }
            
            catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            }
        });
        hb5.getChildren().add(btn4);
        
        HBox hb6 = new HBox();
        hb6.setPadding(new Insets(15, 12, 15, 12));
        hb6.setSpacing(10);
        vb.getChildren().add(hb6);
        
        hb6.getChildren().add(area1);
        
		return vb;
		
	}
}
