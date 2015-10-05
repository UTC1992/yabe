package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {
    
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) 
        {
            User usuario = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", usuario.fullname);
        }
    }
 
    public static void index() {
        render();
    }
    
}