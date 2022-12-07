import java.util.ArrayList;
import java.util.Scanner;

public class AddAction implements Action {
    public void addUser(ArrayList<User> users, Scanner scanner) {
        System.out.println("Digite o nome do usuário:");
        String name = scanner.nextLine();
        System.out.println("Digite a profissão do usuário:");
        String role = scanner.nextLine();
        System.out.println("Digite o login do usuário:");
        String login = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        String password = scanner.nextLine();
        if (role.equals("Professor") || role.equals("Pesquisador")) {
            users.add(new Coordinator(name, role, login, password));
        } else
            users.add(new User(name, role, login, password));
    }

    public void addProject(ArrayList<Project> projects, ArrayList<User> users, Scanner scanner, Utils searches) {
        System.out.println("Insira, em sequência as seguintes informações do projeto: "
                + "Identificação, descrição, data e hora do início, data e hora do término e coordenador do projeto,:");
        String id = scanner.nextLine();
        String description = scanner.nextLine();
        String startDate = scanner.nextLine();
        String finishDate = scanner.nextLine();
        String coordName = scanner.nextLine();

        try {
            projects.add(new Project(id, description, startDate, finishDate,
                    users.get(searches.getUserIndex(users, coordName))));
        } catch (Exception e) {
            System.out.println("Coordenador não encontrado");
        }
    }

    public void addActivity(ArrayList<Activity> activities, ArrayList<User> users, Scanner scanner, Utils searches) {
        System.out.println("Insira, em sequência as seguintes informações da atividade: "
                + "Identificação, descrição, data e hora do início, data e hora do término e supervisor da atividade: ");
        String id = scanner.nextLine();
        String description = scanner.nextLine();
        String startDate = scanner.nextLine();
        String finishDate = scanner.nextLine();
        String supervisorName = scanner.nextLine();

        try {
            activities.add(new Activity(id, description, startDate, finishDate,
                    users.get(searches.getUserIndex(users, supervisorName))));
        } catch (Exception e) {
            System.out.println("Supervisor não encontrado");
        }
    }

}
