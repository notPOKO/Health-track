/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorkoutPage extends JFrame {
    private JTextField workoutTypeField, durationField, caloriesField;
    private JButton saveButton;
    private User user;
    private Reminder reminder;

    public WorkoutPage(User user) {
        this.user = user;
        this.reminder = new Reminder(user);  // Create a reminder instance for the user

        setTitle("Workout Logging");
        setSize(350, 250);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        workoutTypeField = new JTextField(20);
        durationField = new JTextField(20);
        caloriesField = new JTextField(20);
        saveButton = new JButton("Save Workout");

        // Action listener for the save button
        saveButton.addActionListener(e -> saveWorkout());

        // Create labels
        JLabel workoutTypeLabel = new JLabel("Workout Type:");
        JLabel durationLabel = new JLabel("Duration (min):");
        JLabel caloriesLabel = new JLabel("Calories Burned:");

        // Setup layout manager
        setLayout(new GridLayout(4, 2, 10, 10)); // GridLayout for form

        // Add components to frame
        add(workoutTypeLabel);
        add(workoutTypeField);
        add(durationLabel);
        add(durationField);
        add(caloriesLabel);
        add(caloriesField);
        add(saveButton);

        setVisible(true);

        // Start the reminder for daily workout tracking
        reminder.startDailyReminder();
    }

    private void saveWorkout() {
        String workoutType = workoutTypeField.getText();
        String duration = durationField.getText();
        String calories = caloriesField.getText();

        if (!workoutType.isEmpty() && !duration.isEmpty() && !calories.isEmpty()) {
            System.out.println("Workout Saved: " + workoutType + ", " + duration + " minutes, " + calories + " calories burned.");
            JOptionPane.showMessageDialog(this, "Workout saved!");

            // After saving the workout, transition to the next page (NutritionPage)
            new NutritionPage(user);  // Transition to nutrition tracking page
            dispose();  // Close the WorkoutPage
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    public static void main(String[] args) {
        new WorkoutPage(new User("Turki Alnofaee", "Turki@example.com", "password123"));  // Example user
    }
}

