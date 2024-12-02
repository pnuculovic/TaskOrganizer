# Task Organizer: Implementation Manual

## Overview
The application is implemented using three classes:
1. **Task**:
   - Represents a task with a description, due date, and completion status.

2. **TaskManager**:
   - Manages a list of tasks and provides functionality to add, delete, mark as completed, save, and load tasks.

3. **TaskOrganizerGUI**:
   - Provides the graphical user interface for interacting with tasks.

## Code Structure
- **Task.java**:
  - Defines the task object with attributes (`description`, `dueDate`, `status`) and methods for manipulation.

- **TaskManager.java**:
  - Manages a collection of tasks using an `ArrayList`.
  - Handles saving and loading tasks using serialization.

- **TaskOrganizerGUI.java**:
  - Implements the GUI using `Swing`.
  - Provides buttons and actions for adding, editing, deleting, sorting, saving, and loading tasks.

## Key Features
1. **Add Task**:
   - Adds a new task with a description and due date.

2. **Edit Task**:
   - Allows editing the description and due date of an existing task.

3. **Delete Task**:
   - Removes a selected task from the list.

4. **Mark as Completed**:
   - Marks a selected task as completed.

5. **Sort by Date**:
   - Sorts all tasks in ascending order of their due dates.

6. **Save/Load Tasks**:
   - Saves the current list of tasks to a file and reloads them later.

## Known Issues
- None.

## Future Enhancements (Optional)
- Implement recurring tasks.
- Add categories or tags for tasks.
