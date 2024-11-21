/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalSettingPage extends JFrame {
    private JTextField calorieGoalField;
    private JTextField workoutGoalField;
    private JButton saveGoalButton;
    private User user;

    public GoalSettingPage(User user) {
        this.user = user;
        setTitle("Goal Setting");
        setSize(350, 250);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        calorieGoalField = new JTextField(20);
        workoutGoalField = new JTextField(20);
        saveGoalButton = new JButton("Save Goals");

        // Action listener for the save button
        saveGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGoals();
            }
        });

        // Create labels
        JLabel calorieGoalLabel = new JLabel("Calories Burned Goal:");
        JLabel workoutGoalLabel = new JLabel("Workout Goal (count):");

        // Setup layout manager
        setLayout(new GridLayout(3, 2, 10, 10));

        // Add components to frame
        add(calorieGoalLabel);
        add(calorieGoalField);
        add(workoutGoalLabel);
        add(workoutGoalField);
        add(saveGoalButton);

        setVisible(true);
    }

    private void saveGoals() {
        String calorieGoal = calorieGoalField.getText();
        String workoutGoal = workoutGoalField.getText();

        if (!calorieGoal.isEmpty() && !workoutGoal.isEmpty()) {
            user.setCalorieGoal(Integer.parseInt(calorieGoal));
            user.setWorkoutGoal(Integer.parseInt(workoutGoal));

            JOptionPane.showMessageDialog(this, "Goals saved successfully!");
            new WorkoutPage(user);  // Transition to workout page
            dispose();  // Close GoalSettingPage
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    public static void main(String[] args) {
        new GoalSettingPage(new User("John", "john@example.com", "password123"));
    }
}
