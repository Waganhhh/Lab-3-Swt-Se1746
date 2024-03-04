/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Task;

/**
 *
 * @author Quang Anh
 */
public class ManageTaskTest {
    private ManageTask manage;
    private Task task1;
    private Task task2;
    private Task task3;
    ArrayList<Task> listTask = new ArrayList<>();
    
    public ManageTaskTest() {
        manage = new ManageTask();
    }

    @Before
    public void setUp() {
        task1 = new Task(1, "2022-03-01", "John", 10.0, 12.0, "Task description 1", "Incomplete");
        task2 = new Task(2, "2022-03-01", "Alice", 11.0, 13.0, "Task description 2", "Incomplete");
        task3 = new Task(3, "2022-03-02", "Bob", 11.0, 13.0, "Task description 3", "Incomplete");

        listTask.add(task1);
        listTask.add(task2);
        listTask.add(task3);
    }

    @Test
    public void testCheckDuplicate_NoOverlap() {
        // Arrange
        String date = "2022-03-01";
        String assignee = "Alice";
        double from = 14.0;
        double to = 16.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertFalse(result);
    }

    @Test
    public void testCheckDuplicate_Overlap() {
        // Arrange
        String date = "2022-03-01";
        String assignee = "Alice";
        double from = 12.0;
        double to = 15.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertTrue(result);
    }

    @Test
    public void testCheckDuplicate_OverlapAtEdge() {
        // Arrange
        String date = "2022-03-01";
        String assignee = "Alice";
        double from = 10.0;
        double to = 11.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertTrue(result);
    }

    @Test
    public void testCheckDuplicate_NoOverlapDifferentDate() {
        // Arrange
        String date = "2022-03-03";
        String assignee = "Alice";
        double from = 12.0;
        double to = 15.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertFalse(result);
    }
    
    @Test
    public void testCheckDuplicate_OverlapAtEnd() {
        // Arrange
        int id = 4;
        String date = "2022-03-01";
        String assignee = "Bob";
        double from = 13.0;
        double to = 17.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertTrue(result);
    }

    @Test
    public void testCheckDuplicate_OverlapInside() {
        // Arrange
        int id = 4;
        String date = "2022-03-01";
        String assignee = "Alice";
        double from = 11.5;
        double to = 12.5;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertTrue(result);
    }
    
    @Test
    public void testCheckDuplicate_NoOverlapDifferentAssignee() {
        // Arrange
        int id = 4;
        String date = "2022-03-01";
        String assignee = "Charlie";
        double from = 9.0;
        double to = 15.0;
        boolean result = manage.checkDuplicate(date, assignee, from, to);
        assertFalse(result);
    }
    
}
