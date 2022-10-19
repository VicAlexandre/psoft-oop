import java.util.ArrayList;

public class Project {
    private String projectId, description, startDate, finishDate, projectPayTimeSpan, projectStatus;
    private User projectCoordinator;
    private ArrayList<User> projectWorkers;
    private ArrayList<Activity> projectActivities;
    private double projectPay;

    public String getProjectId() {
        return projectId;
    }

    public Project(String projectId, String description, String startDate, String finishDate,
            User projectCoordinator) {
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.projectStatus = "Em processo de criação";
        this.projectCoordinator = projectCoordinator;
        this.projectWorkers = new ArrayList<User>();
        this.projectActivities = new ArrayList<Activity>();
        System.out.printf(
                "--------------------%nProjeto criado com sucesso. %nId: %s%nDescricao: %s%nCoordenador: %s%n--------------------%n",
                projectId, description, projectCoordinator.getName());
    }

    public void displayProjectInfo() {

        System.out.println("--------------------");
        System.out.println("Id do projeto: " + this.projectId);
        System.out.println("Descrição do projeto: " + this.description);
        System.out.println("Coordenador do projeto: " + this.projectCoordinator.getName());
        System.out.println("Data de início do projeto: " + this.startDate);
        System.out.println("Data de término do projeto: " + this.finishDate);
        System.out.println("Status: " + this.projectStatus);
        System.out.println("--------------------");
    }

    public void updateStatus() {
        if (this.projectStatus.equals("Em processo de criação")) {
            this.projectStatus = "Iniciado";
        } else if (this.projectStatus.equals("Iniciado")) {
            if (this.projectWorkers.isEmpty()) {
                System.out.println("Falha ao iniciar o projeto, realize a alocação de usuários antes de dar início");
                return;
            }
            this.projectStatus = "Em andamento";
        } else if (this.projectStatus.equals("Em andamento")) {
            if (this.projectActivities.isEmpty()) {
                System.out.println("Falha ao iniciar o projeto, nenhuma atividade encontrada");
                return;
            }
            this.projectStatus = "Concluído";
        }
        System.out.println("--------------------");
        System.out.println("Status do projeto: " + this.projectStatus);
        System.out.println("--------------------");
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getProjectPayTimeSpan() {
        return projectPayTimeSpan;
    }

    public void setProjectPayTimeSpan(String projectPayTimeSpan) {
        this.projectPayTimeSpan = projectPayTimeSpan;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public User getProjectCoordinator() {
        return projectCoordinator;
    }

    public void setProjectCoordinator(User projectCoordinator) {
        this.projectCoordinator = projectCoordinator;
    }

    public ArrayList<User> getProjectWorkers() {
        return projectWorkers;
    }

    public ArrayList<Activity> getProjectActivities() {
        return projectActivities;
    }

    public double getProjectPay() {
        return projectPay;
    }

    public void setProjectPay(double projectPay) {
        this.projectPay = projectPay;
    }

}
