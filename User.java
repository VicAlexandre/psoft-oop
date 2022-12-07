import java.util.ArrayList;

public class User {
    private String login, password, name, role;

    public ArrayList<Project> linkedProjects;
    public ArrayList<Activity> linkedActivies;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public User(String name, String role, String login, String password) {
        this.name = name;
        this.role = role;
        this.login = login;
        this.password = password;

        linkedProjects = new ArrayList<Project>();
        linkedActivies = new ArrayList<Activity>();

        System.out.printf(
                "--------------------%nUsuário criado com sucesso. %nNome: %s%nProfissão: %s%n--------------------%n",
                name, role);
    }

    public void menu() {
        System.out.println("0. Sair\n" +
                "1. Consultas\n" +
                "2. Relatórios\n" +
                "3. Alterar informações pessoais");
    }

    public void displayUserInfo() {
        System.out.println("--------------------");
        System.out.println("Nome do usuário: " + this.name);
        System.out.println("Profissão do usuário: " + this.role);
        System.out.println("--------------------");
        return;
    }
}