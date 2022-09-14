import java.util.ArrayList;

public class User {
    public String name, role, login, password;
    public boolean coordinator;
    public ArrayList<Project> linkedProjects;
    public ArrayList<Activity> linkedActivies;

    public User(String name, String role, String login, String password) {
        this.name = name;
        this.role = role;
        this.login = login;
        this.password = password;

        if(role.equals("Professor") || role.equals("Pesquisador")){
            this.coordinator = true;
        } else 
            this.coordinator = false;

        linkedProjects = new ArrayList<Project>();
        linkedActivies = new ArrayList<Activity>();
        System.out.printf(
                "--------------------%nUsuário criado com sucesso. %nNome: %s%nProfissão: %s%n--------------------%n",
                name, role);

    }

    public void displayUserInfo() {
        System.out.println("--------------------");
        System.out.println("Nome do usuário: " + this.name);
        System.out.println("Profissão do usuário: " + this.role);
        System.out.println("Pode ser coordenador: " + (this.coordinator ? "Sim" : "Não"));
        System.out.println("--------------------");
        return;
    }
    
    public void addProject(Project projectToBeLinked){
        this.linkedProjects.add(projectToBeLinked);
    }

    public void addProject(Activity activityToBeLinked){
        this.linkedActivies.add(activityToBeLinked);
    }
}