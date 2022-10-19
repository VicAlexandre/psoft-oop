import java.util.ArrayList;

public class Activity {
    private String activityId, activityDescription, startDate, finishDate;
    private User activitySupervisor;
    private ArrayList<User> activityWorkers;
    private ArrayList<User> tempWorkers;
    private ArrayList<String> tasks;

    public Activity(String activityId, String activityDescription, String startDate, String finishDate,
            User activitySupervisor) {
        this.activityId = activityId;
        this.activityDescription = activityDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.activitySupervisor = activitySupervisor;
        this.tasks = new ArrayList<String>();
        this.activityWorkers = new ArrayList<User>();
        this.tempWorkers = new ArrayList<User>();
        System.out.printf(
                "--------------------%nAtividade criada com sucesso. %nId: %s%nDescricao: %s%nSupervisor: %s%n--------------------%n",
                activityId, activityDescription, activitySupervisor.getName());
    }

    public void displayActivityInfo() {
        System.out.println("--------------------");
        System.out.println("Id da atividade: " + this.activityId);
        System.out.println("Descrição da atividade: " + this.activityDescription);
        System.out.println("Supervisor da atividade: " + this.activitySupervisor);
        System.out.println("Data de início da atividade: " + this.startDate);
        System.out.println("Data de término da atividade: " + this.finishDate);
        System.out.println("--------------------");
        return;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public User getActivitySupervisor() {
        return activitySupervisor;
    }

    public void setActivitySupervisor(User activitySupervisor) {
        this.activitySupervisor = activitySupervisor;
    }

    public ArrayList<User> getActivityWorkers() {
        return activityWorkers;
    }

    public void setActivityWorkers(ArrayList<User> activityWorkers) {
        this.activityWorkers = activityWorkers;
    }

    public ArrayList<User> getTempWorkers() {
        return tempWorkers;
    }

    public void setTempWorkers(ArrayList<User> tempWorkers) {
        this.tempWorkers = tempWorkers;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

}
