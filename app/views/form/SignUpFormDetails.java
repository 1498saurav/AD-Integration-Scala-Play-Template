package views.form;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserDB;

public class SignUpFormDetails {

  
/** submitted user name. */
  public String name = "";
  /** submitted user email. */
  public String uEmail = "";
  /** submitted user password. */
  public String pwd = "";

  /** Required for form instantiation. */
  public SignUpFormDetails() {
  }

  /** Form validation*/
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if ((uEmail == null) || (pwd == null) || (name == null)) {
      errors.add(new ValidationError("name", ""));
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));      
    }else{
        UserDB.addUserDetails(name, uEmail, pwd);
    }

    return (errors.size() > 0) ? errors : null;
  }

}
