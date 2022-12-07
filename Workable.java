import java.util.ArrayList;

public abstract class Workable {
    protected String id, description, startDate, finishDate;
    protected User supervisor;
    protected ArrayList<User> workers;

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public ArrayList<User> getWorkers() {
        return workers;
    }

}
