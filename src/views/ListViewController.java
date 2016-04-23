/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Yan Kaic
 */
public class ListViewController implements Initializable {

  @FXML
  private VBox itensBox;
  private ObservableList<Person> personList;
  private MenuViewController tableAController;
  private MenuViewController tableBController;
  private AnchorPane infoView;
  private InfoViewController infoController;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MenuView.fxml"));
      AnchorPane tableA = (AnchorPane) loader.load();
      itensBox.getChildren().add(tableA);
      tableAController = loader.getController();
      tableAController.setParent(this);

      loader = new FXMLLoader(getClass().getResource("/views/InfoView.fxml"));
      infoView = (AnchorPane) loader.load();
      itensBox.getChildren().add(1, infoView);
      infoController = loader.getController();

      loader = new FXMLLoader(getClass().getResource("/views/MenuView.fxml"));
      AnchorPane tableB = (AnchorPane) loader.load();
      itensBox.getChildren().add(tableB);
      tableBController = loader.getController();

    }
    catch (IOException ex) {
      Logger.getLogger(ListViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void setData(ObservableList<Person> personList) {
    this.personList = personList;
    tableAController.setData(personList);
  }

  public void setSelected(Person selectedPerson) {
    if (selectedPerson == null) {
      return;
    }
    infoController.show(selectedPerson);

    ObservableList<Person> listA = FXCollections.observableArrayList();
    ObservableList<Person> listB = FXCollections.observableArrayList();
    boolean toA = true;
    for (Person person : personList) {
      if (person == selectedPerson) {
        toA = false;
        continue;
      }
      if (toA) {
        listA.add(person);
      }
      else {
        listB.add(person);
      }
    }
    tableAController.setData(listA);
    tableBController.setData(listB);
  }

}
