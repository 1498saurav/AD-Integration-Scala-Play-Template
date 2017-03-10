package controllers;

import models.User;
import models.UserDB;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;


public class Authorised extends Security.Authenticator {

  /** return the email address of the logged in user, or if not null */
  @Override
  public String getUsername(Context ctx) {
    return ctx.session().get("email");
  }

  /** if unauthorized returns to the login page */
  @Override
  public Result onUnauthorized(Context context) {
    return redirect(routes.Application.login()); 
  }
  
  /** return the email of the logged in user, or if not returns null*/
  public static String getUser(Context ctx) {
    return ctx.session().get("email");
  }
  
  /** returns true if there is a logged in user */
  public static boolean isLoggedIn(Context ctx) {
    return (getUser(ctx) != null);
  }
  
  /** Return the UserInfo of the logged in user, or null if not*/
  public static User getUserInfo(Context ctx) {
    return (isLoggedIn(ctx) ? UserDB.getUser(getUser(ctx)) : null);
  }
}