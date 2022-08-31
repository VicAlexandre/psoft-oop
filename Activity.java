import java.util.ArrayList;

public class Activity {
    public String activityId, activityDescription, startDate, finishDate;
    public String activitySupervisor;
    public ArrayList<Worker> activityWorkers;
    public ArrayList<String> tasks;

    public Activity(String activityId, String actitityDescription, String startDate, String finishDate, String activitySupervisor){
        this.activityId = activityId;
        this.activityDescription = actitityDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.activitySupervisor = activitySupervisor;
        this.tasks = new ArrayList<String>();
        System.out.printf("--------------------%nAtividade criada com sucesso. %nId: %s%nDescricao: %s%nSupervisor: %s%n--------------------%n", activityId, actitityDescription, activitySupervisor);
    }
}   