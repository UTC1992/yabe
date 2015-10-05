package controllers;

import java.util.List;

import models.User;

public class Security extends Secure.Security{
	
	static boolean authenticate(String username, String password) {
		
		boolean valor = false;
		
		List<User> usuarios = User.findAll();
		int encontrado=0;
		for(int i=0; i < usuarios.size() && encontrado == 0; i++)
		{
			if(usuarios.get(i).email.equals(username))
			{
				if(usuarios.get(i).password.equals(password))
				{
					valor = true;
				}
			}
		}
		return valor;
    }
	
	static void onDisconnected() {
	    Application.index();
	}
	
	static void onAuthenticated() {
	    Admin.index();
	}
	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin;
	    }
	    return false;
	}

}
