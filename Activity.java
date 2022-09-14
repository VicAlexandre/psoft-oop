import java.util.ArrayList;

public class Activity {
    public String activityId, activityDescription, startDate, finishDate;
    public String activitySupervisor;
    public ArrayList<User> activityWorkers;
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
}   