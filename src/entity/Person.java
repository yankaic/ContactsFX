
package entity;

/**
 *
 * @author Yan Kaic
 */
public class Person {
  private String name;
  private String cellphone;
  private String phone;
  private String birthday;
  private String city;
  private String street;
  private String postal;
  
  public Person(String name){
    this.name = name;
    this.cellphone = "";
    this.phone = "";
    this.birthday = "";
    this.city = "";
    this.street = "";
    this.postal = "";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostal() {
    return postal;
  }

  public void setPostal(String postal) {
    this.postal = postal;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
  
  
  
  
  
}
