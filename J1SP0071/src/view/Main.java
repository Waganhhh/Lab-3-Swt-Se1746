/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageTask;

public class Main {

    public static void main(String[] args) {
        ManageTask manage = new ManageTask();
        Utility utility = new Utility();
        manage.mockData();
        while (true) {
            displayMenu();
            int option = utility.getInt("Option: ", "Wrong", "Wrong", "Wrong", 1, 4);

            switch (option) {
                case 1:
                    //input task
                    manage.inputTask();
                    break;
                case 2:
                    //delete task
                    manage.deleteTask();
                    break;
                case 3:
                    //display task
                    manage.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }

        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
