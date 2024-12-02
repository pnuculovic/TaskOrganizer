# Simple Task Organizer

## **CSI2300 Course Project**

**Project Name**: Task Organizer  
**Team Name**: Logic Lab  
**Member**: Peter Nuculovic  

---

## **Project Description**

**Purpose**:  
The Task Organizer is a desktop Java application that provides users with a means of organizing daily chores. Users can add, modify, and delete tasks and also mark them as done. Therefore, it's practical for personal organization and productivity.

**Why I Want to Build It**:  
With busy schedules and an increase in the number of responsibilities one has, being organized is key. This project will provide users with a light tool that provides the needed functionality to track activities without the overhead associated with larger task management applications. 

**Usage**:  
The application allows users to:
- Add tasks with custom descriptions and due dates.
- Edit tasks to update descriptions or due dates.
- Mark tasks as completed.
- Delete tasks from the list.
- Sort tasks by due date.
- Save tasks to a file and load them later to resume progress.

---

## **Plan and Estimate of Effort**
In order to progressively add the necessary functionality and improve the program, I want to work on this project whenever I have free time. By adhering to the course objectives and making sure that every part functions properly, I hope to make the Task Organizer as useful and easy to use as possible.

### **Focus Areas**:
- Adding essential functions like task addition, editing, and deletion.
- Building a straightforward, user-friendly GUI to handle tasks efficiently.
- Constant testing and debugging to ensure dependability.
- Improving usability based on user feedback and observations.

Although the schedule is negotiable, I strive to finish every component with care and excellence.

---

## **Completion Note**
The Task Organizer project has been successfully completed, meeting all outlined objectives and requirements. This project was a valuable learning experience, and I'm proud of the functionality and usability achieved. Thank you for reviewing this work!


```mermaid
classDiagram
    class Task {
        - String description
        - Date dueDate
        - boolean status
        + getDescription()
        + setDescription()
        + isCompleted()
        + setCompleted()
        + toString()
    }
    class TaskManager {
        - ArrayList~Task~ tasks
        + addTask(Task)
        + deleteTask(Task)
        + markTaskCompleted(Task)
        + saveTasksToFile(String fileName)
        + loadTasksFromFile(String fileName)
        + getTasks()
    }
    class TaskOrganizerGUI {
        - JFrame frame
        - JList taskList
        - DefaultListModel~String~ listModel
        + addTask(ActionEvent e)
        + deleteTask(ActionEvent e)
        + markTaskCompleted(ActionEvent e)
        + editTask(ActionEvent e)
        + sortTasksByDate(ActionEvent e)
        + saveTasks(ActionEvent e)
        + loadTasks(ActionEvent e)
    }

    TaskManager --> Task : manages >
    TaskOrganizerGUI --> TaskManager : uses >
    TaskOrganizerGUI --> Task : displays >
