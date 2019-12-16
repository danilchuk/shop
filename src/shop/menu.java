package shop;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class menu extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("My First SHOP (yes,yes,yes)");

		TableView <Range>laptoptableView = new TableView<>();

		TableColumn<Range,String> brandcolumn = new TableColumn<>("Brand");
		brandcolumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

		TableColumn<Range,Integer> pricecolumn = new TableColumn<>("Price");
		pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		laptoptableView.getColumns().setAll(brandcolumn,pricecolumn);
		laptoptableView.setMaxWidth(110);

		laptoptableView.getItems().add(new Range("HP", 1200));
		laptoptableView.getItems().add(new Range("Acer", 600));
		laptoptableView.getItems().add(new Range("lenovo", 900));

		VBox laptopvbox = new VBox(laptoptableView);

		Scene scene2 = new Scene(laptopvbox);

		primaryStage.setScene(scene2);

		primaryStage.show();

		TableView <Range>keyboardtableView = new TableView<>();

		TableColumn<Range,String> keyboardbrandcolumn = new TableColumn<>("Brand");
		keyboardbrandcolumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

		TableColumn<Range,Integer> keyboardpricecolumn = new TableColumn<>("Price");
		keyboardpricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		keyboardtableView.getColumns().setAll(brandcolumn,pricecolumn);
		keyboardtableView.setMaxWidth(110);

		keyboardtableView.getItems().add(new Range("zx", 123));
		keyboardtableView.getItems().add(new Range("cv", 456));
		keyboardtableView.getItems().add(new Range("mnb", 789));

		VBox keyboardvbox = new VBox(keyboardtableView);

		Scene scene3 = new Scene(keyboardvbox);

		primaryStage.setScene(scene3);

		primaryStage.show();

		TableView mousetableView = new TableView();

		TableColumn<String, Range> mousebrandcolumn = new TableColumn<>("Brand");
		mousebrandcolumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

		TableColumn<Integer, Range> mousepricecolumn = new TableColumn<>("Price");
		mousepricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		mousetableView.getColumns().add(brandcolumn);
		mousetableView.getColumns().add(pricecolumn);
		mousetableView.setMaxWidth(110);

		mousetableView.getItems().add(new Range("edc", 741));
		mousetableView.getItems().add(new Range("tgb", 852));
		mousetableView.getItems().add(new Range("ik,", 963));

		VBox mousevbox = new VBox(mousetableView);

		Scene scene4 = new Scene(mousevbox);

		primaryStage.setScene(scene4);

		primaryStage.show();

		Label label = new Label("Welcome to the store");

		MenuItem laptop = new MenuItem("laptop");
		MenuItem keyboard = new MenuItem("keyboard");
		MenuItem mouse = new MenuItem("mouse");

		GridPane tilePane=new GridPane();
		
		laptop.setOnAction(event -> {
			tilePane.add(laptoptableView,0,2,1,1); 

			primaryStage.sizeToScene();
			
			
			
			/* System.out.println("laptop selected via Lambda"); */
		});

		keyboard.setOnAction(event -> {
			tilePane.add(keyboardtableView,0,2,1,1); 

			primaryStage.sizeToScene();

			/* System.out.println("keyboard selected via Lambda"); */
		});

		mouse.setOnAction(event -> {
			tilePane.add(mousetableView,0,2,1,1); 

			primaryStage.sizeToScene();


			/* System.out.println("mouse selected via Lambda"); */
		});

		MenuButton range = new MenuButton("Range", null, laptop, keyboard, mouse);

		Button statistics = new Button("statistics");
		statistics.setOnAction(event -> {
			primaryStage.setTitle("Statistics");

			Label labelstatisticsnumberOfDevaices = new Label("number of devaices");
			PieChart numberOfDevaicespieChart = new PieChart();

			PieChart.Data laptopslicenumber = new PieChart.Data("Laptop", 3);
			PieChart.Data keyboardslicenumber = new PieChart.Data("Keyboard", 3);
			PieChart.Data mouseslicenumber = new PieChart.Data("Mouse", 3);

			numberOfDevaicespieChart.getData().add(laptopslicenumber);
			numberOfDevaicespieChart.getData().add(keyboardslicenumber);
			numberOfDevaicespieChart.getData().add(mouseslicenumber);

			Label labelstatisticstotalcoast = new Label("total coast");
			PieChart totalcoastpieChart = new PieChart();

			PieChart.Data laptopslicetotal = new PieChart.Data("Laptop", 2700);
			PieChart.Data keyboardslicetotal = new PieChart.Data("Keyboard", 1368);
			PieChart.Data mouseslicetotal = new PieChart.Data("Mouse", 2556);

			totalcoastpieChart.getData().add(laptopslicetotal);
			totalcoastpieChart.getData().add(keyboardslicetotal);
			totalcoastpieChart.getData().add(mouseslicetotal);

			VBox statisticsvbox = new VBox(labelstatisticsnumberOfDevaices, numberOfDevaicespieChart,
					labelstatisticstotalcoast, totalcoastpieChart);

			Scene scene = new Scene(statisticsvbox, 400, 200);

			primaryStage.setScene(scene);
			primaryStage.setHeight(600);
			primaryStage.setWidth(600);

			primaryStage.show();
		});

		/*TilePane tilePane = new TilePane();*/

		tilePane.add(label,0,0,1,1);
		tilePane.add(range,0,1,1,1);
		tilePane.add(statistics,1,1,1,1);

		/*
		 * tilePane.setHgap (600); tilePane.setVgap (200);
		 

		tilePane.setTileAlignment(Pos.TOP_LEFT);*/

		Scene scene = new Scene(tilePane, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
		final String FILE_NAME="laptop_Range.txt";
		File fileLaptop=new File(FILE_NAME);
		if (fileLaptop.exists()) {
			fileLaptop.delete();
			OutputStream fosLaptop=new OutputStream (fileLaptop);
			}
		try {
			if(fileLaptop.createNewFile())
			
		{
				System.out.println("Файл"+fileLaptop.getName()+"создан в"+fileLaptop.getAbsolutePath());
				}
		 else {
			 System.out.println("Невозможно создать файл");
			 
		 }
			fileLaptop.setLastModified(System.currentTimeMillis());}
		catch(IOException e) {
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
