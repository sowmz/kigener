package com.github.sowmz.kigener.spring.config.fx;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.beancontext.BeanContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

public class ObjectPanes {

    static public void getPane(Object object, Pane paneToPopulate)
    {
        BeanInfo beanInfo=null;
        try {
             beanInfo = Introspector.getBeanInfo(object.getClass());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor propertyDescriptor : propertyDescriptors){

            String name = propertyDescriptor.getName();

            Object resultObject = null;

            try {
                resultObject = propertyDescriptor.getReadMethod().invoke(object, new Object[]{});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if(resultObject == null)
                continue;

            if(name.equals("class"))
            {
        //        paneToPopulate.getChildren().addAll(new Text(resultObject.toString()));
        //        paneToPopulate.getChildren().addAll(new Text("     "));
                continue;
            }else if (resultObject instanceof Collection)
            {
                FlowPane containerPane = new FlowPane();
                setColor(containerPane);
                containerPane.getChildren().addAll(new Text("List item "+name+":   "));

                List list = (List)resultObject;

                for(Object listObj : list){
                    FlowPane flowPane = new FlowPane();
                    setColor(flowPane);
                    getPane(listObj, flowPane);
                    containerPane.getChildren().add(flowPane);
                }

                paneToPopulate.getChildren().add(containerPane);

            }else if (resultObject instanceof String)
            {
                paneToPopulate.getChildren().addAll(new Text(name+": "+(String)resultObject+"\t "));

            }else
            {
                FlowPane pane = new FlowPane();
                setColor(pane);

                pane.getChildren().addAll(new Text(name+"\t"));

                getPane(resultObject, pane);

                paneToPopulate.getChildren().add(pane);
            }



        }

    }

    static Color[] allColors = { Color.PALEGREEN, Color.BLUEVIOLET,
            Color.GREY, Color.DARKGREY, Color.DIMGREY, Color.LIGHTGREY,
    Color.BEIGE, Color.BISQUE, Color.BLANCHEDALMOND};

    static int colorIndex = 0;

    static Color getColor(){

        colorIndex = (colorIndex + 1 )%allColors.length;

        Color color = allColors[colorIndex];
        System.out.println(color.toString());

        return color;
    }

    static void setColor(Pane pane)
    {
        Color color = getColor();

        pane.setBackground(new Background(
                new BackgroundFill(color,
                        new CornerRadii(0.1),
                        new Insets(0.1, 0.2, 0.1, 0.2))));

        if(pane instanceof FlowPane)
        {
            FlowPane flowPane = (FlowPane)pane;
            flowPane.setVgap(5);
            flowPane.setHgap(5);
        }

    }

}
