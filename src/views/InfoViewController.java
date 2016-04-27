/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Person;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Yan Kaic
 */
public class InfoViewController implements Initializable {

  @FXML
  private Label nameLabel;
  @FXML
  private Button editButton;
  @FXML
  private Button removeButton;
  @FXML
  private Button saveButton;
  @FXML
  private Button cancelButton;
  @FXML
  private GridPane gridPane;
  @FXML
  private Label cellphoneLabel;
  @FXML
  private Label cityLabel;
  @FXML
  private Label postalLabel;
  @FXML
  private Label birthdayLabel;
  @FXML
  private Label phoneLabel;
  @FXML
  private Label streetLabel;
  @FXML
  private GridPane titleBox;

  @FXML
  private HBox buttonBox;

  @FXML
  private AnchorPane cardPane;

  private TextField cellphoneField;
  private TextField phoneField;
  private TextField cityField;
  private TextField streetField;
  private TextField birthdayField;
  private TextField postalField;
  private TextField nameField;
  private Person person;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    cardPane.getChildren().remove(saveButton);
    cardPane.getChildren().remove(cancelButton);
    person = new Person("Yan Kaic");
    createFields();
    loadLabels();
  }
  
  public void show(Person person){
    this.person = person;
    loadLabels();
  }

  private void createFields() {
    phoneField = new TextField();
    cellphoneField = new TextField();
    cityField = new TextField();
    streetField = new TextField();
    postalField = new TextField();
    birthdayField = new TextField();
    nameField = new TextField();
    Font font = nameField.getFont();
    nameField.setFont(new Font(font.getName(), 25));
  }

  @FXML
  public void editClick() {
    buttonMode2();

    visibilityLabels(false);
    loadFields();

    addFields();
  }

  private void buttonMode2() {
    buttonBox.getChildren().add(saveButton);
    buttonBox.getChildren().add(cancelButton);
    buttonBox.getChildren().remove(editButton);
    buttonBox.getChildren().remove(removeButton);
  }

  @FXML
  public void cancelClick() {
    buttonMode1();
    removeFields();
    visibilityLabels(true);
  }

  private void buttonMode1() {
    buttonBox.getChildren().remove(saveButton);
    buttonBox.getChildren().remove(cancelButton);
    buttonBox.getChildren().add(editButton);
    buttonBox.getChildren().add(removeButton);
  }

  @FXML
  public void saveClick() {
    buttonMode1();
    savePerson();
    removeFields();
    loadLabels();
    visibilityLabels(true);
  }

  private void savePerson() {
    person.setName(nameField.getText());
    person.setPhone(phoneField.getText());
    person.setCellphone(cellphoneField.getText());
//    person.setBirthday(birthdayField.getText());
    person.setCity(cityField.getText());
    person.setStreet(streetField.getText());
    person.setPostal(Integer.parseInt(postalField.getText()));
  }

  private void addFields() {
    gridPane.add(cellphoneField, 1, 0);
    gridPane.add(phoneField, 1, 1);
    gridPane.add(cityField, 1, 2);
    gridPane.add(streetField, 1, 3);
    gridPane.add(postalField, 1, 4);
    gridPane.add(birthdayField, 1, 5);
    titleBox.add(nameField, 0, 0);
  }

  private void removeFields() {
    gridPane.getChildren().remove(cellphoneField);
    gridPane.getChildren().remove(phoneField);
    gridPane.getChildren().remove(cityField);
    gridPane.getChildren().remove(streetField);
    gridPane.getChildren().remove(postalField);
    gridPane.getChildren().remove(birthdayField);
    titleBox.getChildren().remove(nameField);
  }

  private void loadFields() {
    nameField.setText(person.getName());
    cellphoneField.setText(person.getCellphone());
    phoneField.setText(person.getPhone());
    cityField.setText(person.getCity());
    streetField.setText(person.getStreet());
    postalField.setText(person.getPostal()+"");
    birthdayField.setText(person.getBirthday().format(DateTimeFormatter.ISO_DATE));
  }

  private void loadLabels() {
    nameLabel.setText(person.getName());
    cellphoneLabel.setText(person.getCellphone());
    phoneLabel.setText(person.getPhone());
    cityLabel.setText(person.getCity());
    streetLabel.setText(person.getStreet());
    postalLabel.setText(person.getPostal()+"");
    birthdayLabel.setText(person.getBirthday().format(DateTimeFormatter.ISO_DATE));
  }

  private void visibilityLabels(boolean b) {
    nameLabel.setVisible(b);
    birthdayLabel.setVisible(b);
    postalLabel.setVisible(b);
    streetLabel.setVisible(b);
    cityLabel.setVisible(b);
    phoneLabel.setVisible(b);
    cellphoneLabel.setVisible(b);
  }

}
