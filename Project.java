import java.util.ArrayList;

public class Project {
    public String projectId, description, startDate, finishDate, projectPayTimeSpan;
    public String projectCoordinator;
    public ArrayList<Worker> projectWorkers;
    public ArrayList<Activity> projectActivities;
    public double projectPay;

    public Project(String projectId, String description, String startDate, String finishDate, String projectPayTimeSpan, String projectCoordinator, double projectPay, ArrayList<Worker> users){
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.projectPayTimeSpan = projectPayTimeSpan;
        this.projectPay = projectPay;
        this.projectCoordinator = projectCoordinator;
        this.projectWorkers = new ArrayList<Worker>();
        this.projectActivities = new ArrayList<Activity>();
        System.out.printf("--------------------%nProjeto criado com sucesso. %nId: %s%nDescricao: %s%nCoordenador: %s%n--------------------%n", projectId, description, projectCoordinator);
    }

    public void addWorker(Worker newWorker){
        this.projectWorkers.add(newWorker);
        System.out.println("Usuário adicionado ao projeto com sucesso.");
    }

    public void addActivity(Activity newActivity){
        this.projectActivities.add(newActivity);
    }

}