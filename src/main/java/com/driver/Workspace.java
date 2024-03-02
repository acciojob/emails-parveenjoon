import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workspace extends Gmail {

    private List<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
        System.out.println("Meeting added to the calendar");
    }

    public int findMaxMeetings() {
        Collections.sort(calendar, Comparator.comparing(Meeting::getEndTime));
        int maxMeetings = 0;
        LocalTime lastEndTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.getStartTime().compareTo(lastEndTime) >= 0) {
                maxMeetings++;
                lastEndTime = meeting.getEndTime();
            }
        }
        return maxMeetings;
    }
}
