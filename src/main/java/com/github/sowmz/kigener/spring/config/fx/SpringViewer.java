package com.github.sowmz.kigener.spring.config.fx;

import com.github.sowmz.kigener.enterprise.jaxb.SimpleConversion;
import com.github.sowmz.kigener.spring.config.model.Beans;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpringViewer extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = getPane();

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene( scene );
        primaryStage.setTitle("Spring Viewer");
        primaryStage.show();

    }

    GridPane getPane(){
        GridPane gridPane = new GridPane();

        Beans beans = SimpleConversion.getClass("src/main/resources/com/github/sowmz/kigener/spring/config/sample.xml",new Beans());

        System.out.println(beans);

        ObjectPanes.getPane(beans, gridPane);

        return gridPane;
    }
}
