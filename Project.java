import java.util.ArrayList;

public class Project extends Workable {
    private String projectPayTimeSpan, projectStatus;
    private ArrayList<Activity> projectActivities;
    private double projectPay;

    public Project(String id, String description, String startDate, String finishDate,
            User supervisor) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.projectStatus = "Em processo de criação";
        this.supervisor = supervisor;
        this.workers = new ArrayList<User>();
        this.projectActivities = new ArrayList<Activity>();
        System.out.printf(
                "--------------------%nProjeto criado com sucesso. %nId: %s%nDescricao: %s%nCoordenador: %s%n--------------------%n",
                id, description, supervisor.getName());
    }

    public void displayProjectInfo() {
        System.out.println("--------------------");
        System.out.println("Id do projeto: " + this.id);
        System.out.println("Descrição do projeto: " + this.description);
        System.out.println("Coordenador do projeto: " + this.supervisor.getName());
        System.out.println("Data de início do projeto: " + this.startDate);
        System.out.println("Data de término do projeto: " + this.finishDate);
        System.out.println("Status: " + this.projectStatus);
        System.out.println("--------------------");
    }

    public void updateStatus() {
        if (this.projectStatus.equals("Em processo de criação")) {
            this.projectStatus = "Iniciado";
        } else if (this.projectStatus.equals("Iniciado")) {
            if (this.workers.isEmpty()) {
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
        System.out.println("Status do projeto alterado: " + this.projectStatus);
        System.out.println("--------------------");
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

    public ArrayList<Activity> getProjectActivities() {
        return projectActivities;
    }

    public double getProjectPay() {
        return projectPay;
    }
}