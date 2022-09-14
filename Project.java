import java.util.ArrayList;

public class Project {
    public String projectId, description, startDate, finishDate, projectPayTimeSpan, projectStatus;
    public User projectCoordinator;
    public ArrayList<User> projectWorkers;
    public ArrayList<Activity> projectActivities;
    public double projectPay;

    public Project(String projectId, String description, String startDate, String finishDate, String projectPayTimeSpan,
            User projectCoordinator, double projectPay, ArrayList<User> users) {
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.projectStatus = "Em processo de criação";
        this.projectPayTimeSpan = projectPayTimeSpan;
        this.projectPay = projectPay;
        this.projectCoordinator = projectCoordinator;
        this.projectWorkers = new ArrayList<User>();
        this.projectActivities = new ArrayList<Activity>();
        System.out.printf(
                "--------------------%nProjeto criado com sucesso. %nId: %s%nDescricao: %s%nCoordenador: %s%n--------------------%n",
                projectId, description, projectCoordinator.name);
    }

    public void addWorker(User newWorker) {
        this.projectWorkers.add(newWorker);
        System.out.println("Usuário adicionado ao projeto com sucesso.");
        return;
    }

    public void addActivity(Activity newActivity) {
        this.projectActivities.add(newActivity);
        return;
    }

    public void updateStatus() {
        if (this.projectStatus.equals("Em processo de criação")){
            this.projectStatus = "Iniciado";
        } else if(this.projectStatus.equals("Iniciado")){
            if(this.projectWorkers.isEmpty()){
                System.out.println("Falha ao iniciar o projeto, realize a alocação de usuários antes de dar início");
                return;
            }
            this.projectStatus = "Em andamento";
        } else if(this.projectStatus.equals("Em andamento")){
            if(this.projectActivities.isEmpty()){
                System.out.println("Falha ao iniciar o projeto, nenhuma atividade encontrada");
                return;
            }
            this.projectStatus = "Concluído";
        }
        System.out.println("--------------------");
        System.out.println("Status do projeto alterado: " + this.projectStatus);
        System.out.println("--------------------");
    }

    public void displayProjectInfo() {

        System.out.println("--------------------");
        System.out.println("Id do projeto: " + this.projectId);
        System.out.println("Descrição do projeto: " + this.description);
        System.out.println("Coordenador do projeto: " + this.projectCoordinator.name);
        System.out.println("Data de início do projeto: " + this.startDate);
        System.out.println("Data de término do projeto: " + this.finishDate);
        System.out.println("Status: " + this.projectStatus);
        System.out.println("--------------------");
    }
}