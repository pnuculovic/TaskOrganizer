package TaskOrganizer;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    private String description;
    private Date dueDate;
    private boolean status; // true = completed, false = pending

    // Constructor
    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.status = false; // Default status
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return status;
    }

    public void setCompleted(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return (status ? "[Completed] " : "[Pending] ") + description + " (Due: " + sdf.format(dueDate) + ")";
    }
}
