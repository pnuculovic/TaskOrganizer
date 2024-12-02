package TaskOrganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TaskOrganizerGUI {
    private TaskManager taskManager;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public TaskOrganizerGUI() {
        taskManager = new TaskManager();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JFrame frame = new JFrame("Task Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark as Completed");
        JButton editButton = new JButton("Edit Task");
        JButton sortButton = new JButton("Sort by Date");
        JButton saveButton = new JButton("Save Tasks");
        JButton loadButton = new JButton("Load Tasks");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        // Add action listeners
        addButton.addActionListener(this::addTask);
        deleteButton.addActionListener(this::deleteTask);
        completeButton.addActionListener(this::markTaskCompleted);
        editButton.addActionListener(this::editTask);
        sortButton.addActionListener(this::sortTasksByDate);
        saveButton.addActionListener(this::saveTasks);
        loadButton.addActionListener(this::loadTasks);

        // Add components to frame
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addTask(ActionEvent e) {
        String description = JOptionPane.showInputDialog("Enter task description:");
        if (description == null || description.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task description cannot be empty!");
            return;
        }

        String dueDateInput = JOptionPane.showInputDialog("Enter due date (MM/dd/yyyy):");
        if (dueDateInput == null || dueDateInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Due date cannot be empty!");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            Date dueDate = sdf.parse(dueDateInput);

            Task task = new Task(description, dueDate);
            taskManager.addTask(task);
            listModel.addElement(task.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use MM/dd/yyyy.");
        }
    }

    private void deleteTask(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = taskManager.getTasks().get(selectedIndex);
            taskManager.deleteTask(task);
            listModel.remove(selectedIndex);
        }
    }

    private void markTaskCompleted(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = taskManager.getTasks().get(selectedIndex);
            taskManager.markTaskCompleted(task);
            listModel.set(selectedIndex, task.toString());
        }
    }

    private void editTask(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "No task selected to edit.");
            return;
        }

        Task task = taskManager.getTasks().get(selectedIndex);

        // Edit description
        String newDescription = JOptionPane.showInputDialog("Enter new description:", task.getDescription());
        if (newDescription != null && !newDescription.trim().isEmpty()) {
            task.setDescription(newDescription);
        }

        // Edit due date
        String newDueDateInput = JOptionPane.showInputDialog("Enter new due date (MM/dd/yyyy):", 
                                                             new SimpleDateFormat("MM/dd/yyyy").format(task.getDueDate()));
        if (newDueDateInput != null && !newDueDateInput.trim().isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                sdf.setLenient(false);
                Date newDueDate = sdf.parse(newDueDateInput);
                task.setDueDate(newDueDate);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please use MM/dd/yyyy.");
            }
        }

        // Update task in the list
        listModel.set(selectedIndex, task.toString());
    }

    private void sortTasksByDate(ActionEvent e) {
        Collections.sort(taskManager.getTasks(), Comparator.comparing(Task::getDueDate));
        listModel.clear();
        for (Task task : taskManager.getTasks()) {
            listModel.addElement(task.toString());
        }
    }

    private void saveTasks(ActionEvent e) {
        try {
            taskManager.saveTasksToFile("tasks.dat");
            JOptionPane.showMessageDialog(null, "Tasks saved successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error saving tasks: " + ex.getMessage());
        }
    }

    private void loadTasks(ActionEvent e) {
        try {
            taskManager.loadTasksFromFile("tasks.dat");
            listModel.clear();
            for (Task task : taskManager.getTasks()) {
                listModel.addElement(task.toString());
            }
            JOptionPane.showMessageDialog(null, "Tasks loaded successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading tasks: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskOrganizerGUI::new);
    }
}

