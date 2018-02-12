package com.github.sowmz.kigener.rest.client;

import com.github.sowmz.kigener.rest.client.fx.Browser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClientApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Pane pane = Browser.getPane();
        Pane pane = Browser.getWebPane();

        Scene scene = new Scene(pane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
