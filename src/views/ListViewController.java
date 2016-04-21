/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Yan Kaic
 */
public class ListViewController implements Initializable {
  
  @FXML
  private VBox itensBox;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/InfoView.fxml"));
      AnchorPane infoView = (AnchorPane) loader.load();
      itensBox.getChildren().add(infoView);
    }
    catch (IOException ex) {
      Logger.getLogger(ListViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }  
  
 
  
}
