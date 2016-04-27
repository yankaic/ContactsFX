/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Person;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Yan Kaic
 */
public class MenuViewController implements Initializable {

  @FXML
  private TableView<Person> personTable;
  @FXML
  private TableColumn<Person, String> leftColumn;
  @FXML
  private TableColumn<Person, String> rightColumn;
  private ListViewController parent;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    leftColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    rightColumn.setCellValueFactory(cellData -> cellData.getValue().getCellphoneProperty());
  }

  void setData(ObservableList<Person> personList) {
    personTable.setItems(personList);

    personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      parent.setSelected(newValue);
      personTable.getSelectionModel().clearSelection();
    });
  }

  public void setParent(ListViewController parent) {
    this.parent = parent;
  }

  void resize() {
    ObservableList<Person> personList = personTable.getItems();
    personTable.setPrefHeight(personList.size() * (personTable.getFixedCellSize() + 2) + 65);
  }

}
