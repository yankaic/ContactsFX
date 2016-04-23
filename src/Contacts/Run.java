/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contacts;

import entity.Person;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.ListViewController;

/**
 *
 * @author Yan Kaic
 */
public class Run extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ListView.fxml"));
      AnchorPane infoView = (AnchorPane) loader.load();
      ListViewController controller = loader.getController();
      controller.setData(loadList());
            
      Scene scene = new Scene(infoView);
      primaryStage.setTitle("Informações do Contato");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    catch (IOException ex) {
      Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  public ObservableList<Person> loadList(){    
    ObservableList<Person> personData = FXCollections.observableArrayList();
    personData.add(new Person("José"));
    personData.add(new Person("Maria"));
    personData.add(new Person("Carlos"));
    personData.add(new Person("Marcos"));
    personData.add(new Person("Marcio"));
    personData.add(new Person("Augusto"));
    personData.add(new Person("Pedro"));
    return personData;
  }
  
}
