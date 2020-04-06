/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ahmed
 */
public class User {
    
    public int id;
    public String username;
    public String pass;
    public String email;
    public boolean isadmin;
    public int credit_limit;

    public User(int id, String username, String pass, String email, boolean isadmin, int credit_limit) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.isadmin = isadmin;
        this.credit_limit = credit_limit;
    }

    public User() {
       
    }

    public User(int id, String username, String pass, String email, int credit_limit) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.credit_limit = credit_limit;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public int getCredit_limit() {
        return credit_limit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public void setCredit_limit(int credit_limit) {
        this.credit_limit = credit_limit;
    }

   
    
    
}
