package entity;

import java.time.LocalDate;
import java.time.Month;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yan Kaic
 */
public class Person {

  private StringProperty name;
  private StringProperty cellphone;
  private StringProperty phone;
  private ObjectProperty<LocalDate> birthday;
  private StringProperty city;
  private StringProperty street;
  private IntegerProperty postal;

  public Person() {
    this(null);
  }

  public Person(String name) {
    this.name = new SimpleStringProperty(name);
    this.cellphone = new SimpleStringProperty("(77) 9999-9999");
    this.phone = new SimpleStringProperty("(77) 9999-9999");
    this.birthday = new SimpleObjectProperty<>(LocalDate.of(2016, Month.MARCH, 21));
    this.city = new SimpleStringProperty("Vitória da Conquista");
    this.street = new SimpleStringProperty("Av. Olivia Flores");
    this.postal = new SimpleIntegerProperty(45000000);
  }
  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getCellphone() {
    return cellphone.get();
  }

  public void setCellphone(String cellphone) {
    this.cellphone.set(cellphone);
  }

  public String getPhone() {
    return phone.get();
  }

  public void setPhone(String phone) {
    this.phone.set(phone);
  }

  public LocalDate getBirthday() {
    return birthday.get();
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday.set(birthday);
  }

  public String getCity() {
    return city.get();
  }

  public void setCity(String city) {
    this.city.set(city);
  }

  public int getPostal() {
    return postal.get();
  }

  public void setPostal(int postal) {
    this.postal.set(postal);
  }

  public String getStreet() {
    return street.get();
  }

  public void setStreet(String street) {
    this.street.set(street);
  }

  public StringProperty getNameProperty() {
    return name;
  }

  public void setName(StringProperty name) {
    this.name = name;
  }

  public StringProperty getCellphoneProperty() {
    return cellphone;
  }

  public void setCellphone(StringProperty cellphone) {
    this.cellphone = cellphone;
  }

  public StringProperty getPhoneProperty() {
    return phone;
  }

  public void setPhone(StringProperty phone) {
    this.phone = phone;
  }

  public ObjectProperty<LocalDate> getBirthdayProperty() {
    return birthday;
  }

  public void setBirthday(ObjectProperty<LocalDate> birthday) {
    this.birthday = birthday;
  }

  public StringProperty getCityProperty() {
    return city;
  }

  public void setCity(StringProperty city) {
    this.city = city;
  }

  public StringProperty getStreetProperty() {
    return street;
  }

  public void setStreet(StringProperty street) {
    this.street = street;
  }

  public IntegerProperty getPostalProperty() {
    return postal;
  }

  public void setPostal(IntegerProperty postal) {
    this.postal = postal;
  }

  
  
  
  
  

  
}
