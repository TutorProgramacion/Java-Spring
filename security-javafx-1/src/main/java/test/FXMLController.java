package test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by Carmelo Marin Abrego on 01/03/2016.
 */
public class FXMLController {

    private static String prefix = "Controller";

    private Parent root;

    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(getFxmlName()));
        loader.setControllerFactory(clz -> this);
        return loader.load();
    }

    private String getFxmlName(){
        String name = this.getClass().getName();
        name = name.replaceAll("\\.", "/");

        if(name.endsWith(prefix)){
            name = name.substring(0, name.lastIndexOf(prefix));
        }

        return name + ".fxml";
    }

    public Parent getRoot() throws IOException{
        if(root == null){
            root = load();
        }
        return root;
    }
}
