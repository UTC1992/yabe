package controllers;

import org.hibernate.annotations.Check;

import play.mvc.With;

@Check(constraints="admin")
@With(Secure.class)
public class Comments extends CRUD {

}
