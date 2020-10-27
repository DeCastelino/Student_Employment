package Model;

import java.io.Serializable;
import java.util.HashMap;

public class Admin extends User implements Serializable {

    private HashMap <String, User> users;

    Admin () {
        users = new HashMap<>();
    }

    // Modifiers
    public void setUsername (String username) { setUsername(username); }

    public void setPassword (String password) { setPassword(password); }

    public void setUserType () {setUserType("Admin");}

    // Method to set complainant class to provisional blacklist
    public void setProvBlacklist (String username) {
        users.get(username).setProvBlacklist(true);
    }
    //Method to move from provisional to permanent blacklisting
    public void setPermBlacklist (String username) {
        users.get(username).setPermBlacklist(true);
        users.get(username).setProvBlacklist(false);
    }
    // Method to remove blacklisting (prov or permanent)
    public void removePermBlacklist (String username) {
        users.get(username).setPermBlacklist(false);
    }

    //Accessors
    public String getUsername () {return super.getUsername(); }
    public String getName () { return super.getName(); }

    public void printProvBlacklisted () {
        for (User user : users.values()) {
            if (user.isProvBlacklist())
                System.out.println("Name: " + user.getName() + ", Username: " + user.getUsername() + ", User Type: " + user.getUserType());
        }
    }

    public void printPermBlacklisted () {
        for (User user : users.values()) {
            if (user.isPermBlacklist())
                System.out.println("Name: " + user.getName() + ", Username: " + user.getUsername() + ", User Type: " + user.getUserType());
        }
    }

    @Override
    public String toString() {
        return "Admin [ Name: " + super.getName() + ", Username: " + super.getUsername() + " ]";
    }
}
