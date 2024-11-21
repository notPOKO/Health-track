package models;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String name;
    private String email;
    private String password;
    private int calorieGoal;
    private int workoutGoal;

    // Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = hashPassword(password); // Hash the password
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(hashPassword(inputPassword));
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Set and get goals
    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public void setWorkoutGoal(int workoutGoal) {
        this.workoutGoal = workoutGoal;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public int getWorkoutGoal() {
        return workoutGoal;
    }
}
