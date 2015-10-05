package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Table(name="blog_user")
@Entity
public class User extends Model {
    
    @Email
    @Required
    public String email;
    
    @Required
    public String password;
    
    public String fullname;
    public boolean isAdmin;
    
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
 
    public String toString() {
        return email;
    }
    
    
    
}