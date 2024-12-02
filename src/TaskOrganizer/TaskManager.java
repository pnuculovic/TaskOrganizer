package TaskOrganizer;

import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Delete a task
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    // Mark a task as completed
    public void markTaskCompleted(Task task) {
        task.setCompleted(true);
    }

    // Get all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Save tasks to a file
    public void saveTasksToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tasks);
        }
    }

    // Load tasks from a file
    public void loadTasksFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tasks = (ArrayList<Task>) ois.readObject();
        }
    }
}
