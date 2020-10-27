package Model;

import java.io.Serializable;

public abstract class User implements Serializable {

    private String userName;
    private String password;
    private String name;
    private String userType;
    private boolean isPermBlacklist = false;
    private boolean isProvBlacklist = false;

    // Modifiers
    public void setUsername (String userName) { this.userName = userName; }
    public void setPassword (String password) { this.password = password; }
    public void setUserType (String userType) { this.userType = userType; }
    public void setProvBlacklist (boolean value) { isProvBlacklist = value; }
    public void setPermBlacklist (boolean value) { isPermBlacklist = value; }
    public void setName (String name) { this.name = name; }

    // Accessors
    public boolean checkPassword (String password) { if (this.password.equals(password)) return true; return false; }
    public String getUsername () { return userName; }
    public String getName () { return name;}
    public String getUserType () { return userType; }
    public boolean isPermBlacklist () { return isPermBlacklist; }
    public boolean isProvBlacklist () { return isProvBlacklist; }
}
