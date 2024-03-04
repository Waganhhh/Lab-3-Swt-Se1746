package view;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PHAM KHAC VINH
 */
public class Utility {

    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";

    Scanner scanner = new Scanner(System.in);

    public int getInt(String message, String firstError, String secondError,
            String thirdError, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public float getFloat(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    float number = Float.parseFloat(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    public String getDate() {
        while (true) {
            System.out.print("Enter date: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
                    System.out.println("Date must be in format dd-MM-yyyy");
                } else {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    dateFormat.setLenient(false);

                    try {
                        Date currentDate = new Date();
                        Date inputDate = dateFormat.parse(input);
                        currentDate = dateFormat.parse(dateFormat.format(currentDate));
                        
                        if (inputDate.after(currentDate)) {
                            return input;
                        } else {
                            System.out.println("Date must be greater or equal to current date !!");
                        }

                    } catch (Exception e) {
                        System.out.println("Date does not exist !!");
                    }

                }
            }
        }
    }
    
    public String getRequirementNameInput() {
        String requirementName = getString("Requirement Name: ",
                "Wrong", REGEX_STRING);
        return requirementName;
    }
    
    public int getTaskTypeInput() {
        int taskType = getInt("Task Type: ",
                "Wrong", "Wrong", "Wrong", 1, 4);
        return taskType;
    }
    
    public double getFromInput() {
        double from = getDouble("Enter from: ", "Wrong", "Wrong", "Wrong",
                8, 17);
        return from;
    }
    
    public double getToInput(double from) {
        double to = getDouble("Enter to: ", "Wrong", "Wrong", "Wrong", from + 0.5,
                17.5);
        return to;
    }
    
    public String getAssigneeInput() {
        String assignee = getString("Enter assignee: ", "Wrong", REGEX_STRING);
        return assignee;
    }
    
    public String getReviewerInput() {
        String reviewer = getString("Enter reviewer: ", "Wrong", REGEX_STRING);
        return reviewer;
    }
    
}
