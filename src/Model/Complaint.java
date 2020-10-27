package Model;
import java.io.Serializable;
import java.util.ArrayList;

public class Complaint implements Serializable {

    private ArrayList <User> complainantList;
    private ArrayList <String> feedbackList;
    private int totalComplaints;
    private boolean isBlacklisted;

    Complaint () {
        totalComplaints = 0;
        isBlacklisted = false;
    }

    public void registerComp (User complainant, String feedback) throws ComplaintLimitExceeded {
        totalComplaints++;
        if (totalComplaints < 3) {
            complainantList.add(complainant);
            feedbackList.add(feedback);
            System.out.println("Complaint has been registered");
        }
        else {
            isBlacklisted = true;
            throw new ComplaintLimitExceeded ();
        }
    }

    // Reset Complaint
    public void reset () {
        totalComplaints = 0;
        isBlacklisted = false;
    }

    // ACCESSORS
    public boolean isBlacklisted () { return isBlacklisted; }
    public ArrayList <String> getFeedback () { return feedbackList; }

}
