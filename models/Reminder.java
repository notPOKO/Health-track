
package models;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    private Timer timer;
    private User user;

    public Reminder(User user) {
        this.user = user;
        this.timer = new Timer();
    }

    public void startDailyReminder() {
        // Schedule a daily reminder at a fixed time (e.g., every day at 8 AM)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                remindUserToLogWorkout();
            }
        }, 0, 24 * 60 * 60 * 1000); // Repeat every 24 hours
    }

    public void remindUserToLogWorkout() {
        // Reminder logic: remind the user to log their workout or nutrition
        System.out.println("Reminder: You haven't logged your workout or nutrition for today!");
        // In a real app, you could use a dialog box or system notification
        // JOptionPane.showMessageDialog(null, "Reminder: Log your workout!");
    }

    public static void main(String[] args) {
        // Create a user and start the reminder service for them
        User user = new User("John", "john@example.com", "password");
        Reminder reminder = new Reminder(user);
        reminder.startDailyReminder();
    }
}

