package Model;

import java.util.InputMismatchException;

public class Main {
    private static DataHandler dh;

    public static void main(String[] args) throws Exception {
        Main main = new Main ();
        dh = new DataHandler();
        do {
            main.mainMenu();
        } while (true);
    }

    public void mainMenu () throws Exception {
        System.out.println("1. Login as Applicant");
        System.out.println("2. Login as Employer");
        System.out.println("3. Login as Admin");
        System.out.println("4. Register as Applicant");
        System.out.println("5. Register as Employer");
        System.out.println("6. Register as Admin");
        System.out.println("0. Exit");

        System.out.print("Enter your response: ");

        try {
            int input = Global.scanner.nextInt();
            Global.scanner.nextLine();

            switch (input) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    // need to check
                    System.out.println("Enter username: ");
                    String appUsername = Global.scanner.nextLine();
                    System.out.println("Enter password: ");
                    String appPassword = Global.scanner.nextLine();
                    if (dh.verifyUser(appUsername, appPassword)) applicantMenu(appUsername);
                    break;

                case 2:
                    // need to check
                    System.out.println("Enter username: ");
                    String empUsername = Global.scanner.nextLine();
                    System.out.println("Enter password: ");
                    String empPassword = Global.scanner.nextLine();
                    if (dh.verifyUser(empUsername, empPassword)) employerMenu(empUsername);
                    break;

                case 3:
                    // need to check
                    System.out.println("Enter username: ");
                    String adminUsername = Global.scanner.nextLine();
                    System.out.println("Enter password: ");
                    String adminPassword = Global.scanner.nextLine();
                    if (dh.verifyUser(adminUsername, adminPassword)) adminMenu(adminUsername);
                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    dh.registerUser("Admin");
                    break;

                default:
                    System.err.println("Incorrect selection. Select number from 0-6 only");
            }
        } catch (InputMismatchException ime) {
            System.err.println("Incorrect Input. Try Again");
        }
    }

    public void adminMenu (String username) throws Exception {
        do {
            System.out.println();
            System.out.println("1. View provisionally blacklisted members");
            System.out.println("2. View permanent blacklisted members");
            System.out.println("3. View applicant records");
            System.out.println("4. View employer records");
            System.out.println("0. Return to main menu");

            try {
                int input = Global.scanner.nextInt();
                Global.scanner.nextLine();

                switch (input) {
                    case 0:
                        System.out.println("Are you sure you want to log out? (Y / N)");
                        char value = Global.scanner.nextLine().toUpperCase().charAt(0);
                        if (value == 'Y') mainMenu();
                        break;

                    case 1:
                        dh.printProvisional(username);
                        break;

                    case 2:
                        dh.printPermanent(username);
                        break;

                    case 3:
                        dh.printApplicantRecords();
                        break;

                    case 4:
                        dh.printEmployerRecords();
                        break;

                    default:
                        System.err.println("Incorrect selection. Choose between 0-4");
                }
            } catch (InputMismatchException ime) {
                System.err.println("Incorrect Input. Try Again");
            }
        } while (true);
    }

    public void applicantMenu (String username) {

    }


    public void employerMenu (String username) {

    }
}
