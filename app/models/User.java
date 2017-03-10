package models;
public class User{
 
  private String uName;
  private String uEmail;
  private String uPwd;
  
  /** Constructor for user class */
  public User(String uName, String uEmail, String uPwd) {
    this.uName = uName;
    this.uEmail = uEmail;
    this.uPwd = uPwd;
  }
  
  /*returns the name of the user*/
  public String getName() {
    return uName;
  }
  
  /** sets the name of the user*/
  public void setName(String uName) {
    this.uName = uName;
  }
  
  /** returns the email of the user*/
  public String getEmail() {
    return uEmail;
  }
  
  /** sets the email of the user*/
  public void setEmail(String email) {
    this.uEmail = uEmail;
  }
  
  /** returns the password of the  user*/
  public String getPassword() {
    return uPwd;
  }
  
  /** sets the password of the user*/
  public void setPassword(String uPwd) {
    this.uPwd = uPwd;
  }

}
