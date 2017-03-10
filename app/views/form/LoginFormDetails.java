package views.form;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserDB;

public class LoginFormDetails {

  /** submitted user email. */
  public String uEmail = "";
  /** submitted user password. */
  public String pwd = "";

  /** Required for form instantiation. */
  public LoginFormDetails() {
  }

  /** Form validation*/
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (!UserDB.isValid(uEmail, pwd)) {
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));      
    }

    return (errors.size() > 0) ? errors : null;
  }

}
