/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Person;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
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
  private ObservableList<Person> listA;
  private ObservableList<Person> listB;
  private AnchorPane tableB;

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
      tableB = (AnchorPane) loader.load();
      itensBox.getChildren().add(tableB);
      tableBController = loader.getController();
      tableBController.setParent(this);

      infoView.setVisible(false);
      tableB.setVisible(false);

    }
    catch (IOException ex) {
      Logger.getLogger(ListViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void setData(ObservableList<Person> personList) {
    this.personList = personList;
    listA = FXCollections.observableArrayList();
    listB = FXCollections.observableArrayList();
    for (Person person : personList) {
      listA.add(person);
    }
    tableAController.setData(listA);
    tableBController.setData(listB);
    tableAController.resize();
  }

  public void setSelected(Person selectedPerson) {
    if (selectedPerson == null) {
      infoView.setVisible(false);
      tableB.setVisible(false);
      while (!listB.isEmpty()) {
        listA.add(listB.remove(0));
      }
      return;
    }
    if (listA.contains(selectedPerson)) {
      while (listA.get(listA.size() - 1) != selectedPerson) {
        listB.add(listA.remove(listA.size() - 1));
      }
    }
    else {
      while (listB.get(0) != selectedPerson) {
        listA.add(listB.remove(0));
      }
    }
    infoController.show(selectedPerson);
    tableAController.resize();
    tableBController.resize();
    infoView.setVisible(true);
    tableB.setVisible(true);

  }
  
  public void removePerson(Person person){
      if(listA.contains(person)){
          listA.remove(person);
      }
      else if(listB.contains(person)){
          listB.remove(person);
      }
      infoView.setVisible(false);
  }
  
  public void updatePerson(Person person){
      if(!listA.contains(person)){
          listA.add(person);
      }
  }

  @FXML
  public void outClick() {
    setSelected(null);
  }
  
  @FXML
  public void addClick(){
      Person person = new Person();
      infoView.setVisible(true);
      infoController.show(person);
      infoController.editClick();
  }

}
