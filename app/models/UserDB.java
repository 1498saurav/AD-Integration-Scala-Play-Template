package models;

import java.util.HashMap;
import java.util.Map;

public class UserDB{
  
  private static Map<String, User> userDetails = new HashMap<String, User>();
  
  /** Adds the particular user to the userDetails map */
  public  static void addUserDetails(String uName, String uEmail, String uPwd) {
    userDetails.put(uEmail, new User(uName, uEmail, uPwd));
  }
  
  /** Returns true if the email belongs to a registered user*/
  public  static boolean isUser(String uEmail) {
    return userDetails.containsKey(uEmail);
  }

  /** returns the user details stored in the map or else
   * returns null if no user found
   */
  public static User getUser(String uEmail) {
    return userDetails.get((uEmail == null) ? "" : uEmail);
  }

  /** returns true if both email and password are true*/
  public static boolean isValid(String uEmail, String uPwd) {
    return ((uEmail != null) && (uPwd != null) && isUser(uEmail) 
            && getUser(uEmail).getPassword().equals(uPwd));
  }
  
}
