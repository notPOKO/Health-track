/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.*;
import java.awt.*;

public class NutritionPage extends JFrame {
    private JTextField foodField, caloriesField;
    private JButton saveButton;
    private User user;

    public NutritionPage(User user) {
        this.user = user;
        setTitle("Nutrition Tracking");
        setSize(350, 250);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        foodField = new JTextField(20);
        caloriesField = new JTextField(20);
        saveButton = new JButton("Save Meal");

        // Action listener for the save button
        saveButton.addActionListener(e -> saveMeal());

        // Create labels
        JLabel foodLabel = new JLabel("Food:");
        JLabel caloriesLabel = new JLabel("Calories:");

        // Setup layout manager
        setLayout(new GridLayout(3, 2, 10, 10)); // GridLayout for form

        // Add components to frame
        add(foodLabel);
        add(foodField);
        add(caloriesLabel);
        add(caloriesField);
        add(saveButton);

        setVisible(true);
    }

    private void saveMeal() {
        String food = foodField.getText();
        String calories = caloriesField.getText();

        if (!food.isEmpty() && !calories.isEmpty()) {
            // Save the meal data (just print to console for simplicity)
            System.out.println("Meal Saved: " + food + ", " + calories + " calories.");
            JOptionPane.showMessageDialog(this, "Meal saved!");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }
}
