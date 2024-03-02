import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email {

    private int inboxCapacity;
    private List<Mail> inbox;
    private List<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        if (inbox.size() >= inboxCapacity) {
            moveOldestMailToTrash();
        }
        inbox.add(new Mail(date, sender, message));
        System.out.println("Mail received successfully");
    }

    public void deleteMail(String message) {
        inbox.removeIf(mail -> mail.getMessage().equals(message));
        System.out.println("Mail deleted successfully");
    }

    public String findLatestMessage() {
        return inbox.isEmpty() ? null : inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage() {
        return inbox.isEmpty() ? null : inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end) {
        return (int) inbox.stream()
                .filter(mail -> mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0)
                .count();
    }

    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
        System.out.println("Trash emptied successfully");
    }

    private void moveOldestMailToTrash() {
        if (!inbox.isEmpty()) {
            trash.add(inbox.remove(0));
        }
    }
}
