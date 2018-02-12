package com.github.sowmz.kigener.rest.client.fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Browser {

    public static Pane getPane() {
        GridPane gridPane = new GridPane();

        TextField textField = new TextField("Enter URL here");
        Button submitButton = new Button("Go");
        TextArea outputArea = new TextArea();

        textField.setPrefWidth(400);

        gridPane.add(textField, 0, 0, 4, 1);
        gridPane.add(submitButton, 4, 0, 1, 1);
        gridPane.add(outputArea, 0, 1, 5, 5);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                outputArea.setText(getOutput(textField.getText()));
            }
        });

        return gridPane;
    }

    public static Pane getWebPane() {
        GridPane gridPane = new GridPane();

        TextField textField = new TextField("Enter URL here");
        Button submitButton = new Button("Go");
//        TextArea outputArea = new TextArea();

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();


        gridPane.add(textField, 0, 0, 4, 1);
        gridPane.add(submitButton, 4, 0, 1, 1);
        gridPane.add(webView, 0, 1, 5, 5);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                engine.load(textField.getText());
                engine.loadContent(getOutput(textField.getText()));

            }
        });

        return gridPane;
    }

    static String getOutput(String url) {

        String output = "";
        String line;

        URL urlConn = null;
        try {
            urlConn = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection urlConnection = null;
        try {
            urlConnection = urlConn.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while ((line = bufferedReader.readLine()) != null) {
                output = output + line + "\n";
            }
        } catch (Exception e) {

        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
