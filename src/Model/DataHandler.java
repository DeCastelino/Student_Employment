package Model;

import java.util.HashMap;

public class DataHandler {

    private HashMap<String, User> users;

    DataHandler () {
        users = new HashMap <> ();
        Serialization.read(users, "Users.txt");
    }

    // Login for Applicant / Employer / Admin
    public boolean verifyUser (String username, String password) {

         if (users.containsKey(username) && users.get(username).checkPassword(password)) {
            if (users.get(username).isPermBlacklist()) {
                System.err.println("Sorry, your account is permanently blacklisted. Check back later or contact Admin");
                return false;
            }
            System.out.println("Login as " + username + " Successful!");

            return true;
        }
        System.out.println("Incorrect username or password");
        return false;
    }

    public void registerUser (String userType) throws Exception {
        System.out.println("Enter new username: ");
        String username = Global.scanner.nextLine();
        System.out.println("Enter new password: ");
        String password = Global.scanner.nextLine();
        System.out.println("Account successfully created!");
        Admin admin = new Admin();
        users.put(username, admin);
        Serialization.write(users, "Users.txt");    // Write changes to file
    }

    // Accessible by admin only
    public void printProvisional (String username) {
        Admin admin = (Admin) users.get(username);
        admin.printProvBlacklisted();
    }
    // Accessible by admin only
    public void printPermanent (String username) {
        Admin admin = (Admin) users.get(username);
        admin.printPermBlacklisted();
    }

    // Accessors
    public void printApplicantRecords() {
        for (User user : users.values()) {
            if (user.getUserType().equalsIgnoreCase("Applicant"))
                System.out.println(user.toString());
        }
    }

    public void printEmployerRecords() {
        for (User user : users.values()) {
            if (user.getUserType().equalsIgnoreCase("Employer"))
                System.out.println(user.toString());
        }
    }
}
