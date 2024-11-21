
package models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private ArrayList<User> users;

    public LoginPage() {
        users = new ArrayList<>(); // This will hold users in-memory

        // Test User (You can add more)
        users.add(new User("John Doe", "john@example.com", "password123"));

        // Set window properties
        setTitle("HealthTrack - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        // Setup layout manager
        setLayout(new GridLayout(5, 2, 10, 10)); // GridLayout with 5 rows, 2 columns, and gaps between components

        // Add components to the frame
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        // Add action listeners
        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> handleRegister());

        // Set the window visibility
        setVisible(true);
    }

    private void handleLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        for (User user : users) {
            if (user.getEmail().equals(email) && user.checkPassword(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new GoalSettingPage(user);  // Go to goal setting page
                dispose();  // Close the login page
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
    }

    private void handleRegister() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String name = JOptionPane.showInputDialog(this, "Enter your name:");

        if (name != null && !name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            User newUser = new User(name, email, password);
            users.add(newUser);
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
