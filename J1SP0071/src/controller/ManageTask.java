/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Task;
import view.Utility;

public class ManageTask {

    Utility input = new Utility();
    ArrayList<Task> listTask = new ArrayList<>();

    public void inputTask() {
        //input information
        String requirementName, date, assignee, reviewer;
        int taskType;
        double from, to;

        requirementName = input.getRequirementNameInput();
        taskType = input.getTaskTypeInput();
        date = input.getDate();
        from = input.getFromInput();
        to = input.getToInput(from);
        assignee = input.getAssigneeInput();
        reviewer = input.getReviewerInput();

        //check duplicate
        if (checkDuplicate(date, assignee, from, to)) {
            System.out.println("Overlaps task !!");
        } else {
            Task task = new Task(taskType, requirementName, date, from, to, assignee, reviewer);
            listTask.add(task);
        }

    }

    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean checkDuplicate(String date, String assignee, double from, double to) {

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : listTask) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from2 < from1 && to2 > from1
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                //if from2 = from1 => return true
                if (from == task.getFrom()) {
                    return true;
                }
                // if from2 > from1 and from2 < to1=> return true
                if (from > task.getFrom() && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteTask() {
        //input id
        int id = input.getInt("Enter id: ", "Wrong", "Wrong", "Wrong",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        //search task by id
        Task task = searchTaskById(id);

        //not found
        if (task == null) {
            System.out.println("NOT FOUND !!");
            System.out.println("DELETE FAILED !!");
            //found
        } else {
            listTask.remove(task);
        }

    }

    public void displayTask() {
        for (Task task : listTask) {
            System.out.println(task);
        }
    }

    private Task searchTaskById(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void mockData() {
        listTask.add(new Task(1, "Nguyen Van A", "a", 0, 0, "A", "A"));
        listTask.add(new Task(2, "Nguyen Van B", "a", 0, 0, "A", "A"));
        listTask.add(new Task(3, "Nguyen Van C", "a", 0, 0, "A", "A"));
    }

}
