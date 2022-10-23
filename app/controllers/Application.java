package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.profile;
import views.html.login;
import views.html.signup;
import views.form.LoginFormDetails;
import views.form.SignUpFormDetails;
import play.mvc.Security;

import javax.inject.Inject;

public class Application extends Controller {

  @Inject
  FormFactory formFactory;
  /** Gives Index page */
  public  Result index() {
    return ok(index.render("Home", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx())));
  }
  
  /**Gives login page */
  public  Result login() {

    Form<LoginFormDetails> formData = formFactory.form(LoginFormDetails.class);
    return ok(login.render("Login", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx()), formData));
  }
  
    /**Gives signup page */
  public  Result signup() {
    Form<SignUpFormDetails> formData = formFactory.form(SignUpFormDetails.class);
    return ok(signup.render("Sign Up", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx()), formData));
  }
  
   /** Log out (registered and logged in users) and returns to the Index page*/
  @Security.Authenticated(Authorised.class)
  public  Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /** Go to Profile page (only to lgged in users) */
  @Security.Authenticated(Authorised.class)
  public  Result profile() {
    return ok(profile.render("Profile", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx())));
  }

  /** Processes a login form submission from an unregistered user*/
  public  Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormDetails> formData = formFactory.form(LoginFormDetails.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Invalid Login credentials.");
      return badRequest(login.render("Login", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx()), formData));
    }
    else {
      // set the session variable because credentials are right
      session().clear();
      session("email", formData.get().uEmail);
      return redirect(routes.Application.profile());
    }
  }
  
  
  /** Processes a login form submission from an unregistered user*/
  public  Result postSignup() {

    // Get the submitted form data from the request object, and run validation.
    Form<SignUpFormDetails> formData = formFactory.form(SignUpFormDetails.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Invalid");
      return badRequest(signup.render("Sign Up", Authorised.isLoggedIn(ctx()), Authorised.getUserInfo(ctx()), formData));
    }
    else {
      // set the session variable because credentials are right
      return redirect(routes.Application.login());
    }
  }
  
  
}
