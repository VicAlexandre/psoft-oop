import java.util.ArrayList;
import java.util.Scanner;

public class RemoveAction implements Action {
    public void removeUser(ArrayList<User> users, Scanner scanner, Utils searches) {
        System.out.println("Digite o nome do usuário que deseja remover:");
        String name = scanner.nextLine();
        try {
            users.remove(searches.getUserIndex(users, name));
            System.out.println("Usuário removido com sucesso");
        } catch (Exception e) {
            System.out.println("Usuário não encontrado");
        }
    }

    public void removeProject(ArrayList<Project> projects, Scanner scanner, Utils searches) {
        System.out.println("Digite o id do projeto que deseja remover:");
        String id = scanner.nextLine();
        try {
            projects.remove(searches.getProjectIndex(id, projects));
            System.out.println("Projeto removido com sucesso");
        } catch (Exception e) {
            System.out.println("Projeto não encontrado");
        }
    }

    public void removeActivity(ArrayList<Activity> activities, Scanner scanner, Utils searches) {
        System.out.println("Digite o id da atividade que deseja remover:");
        String id = scanner.nextLine();
        try {
            activities.remove(searches.getActivityIndex(id, activities));
            System.out.println("Atividade removida com sucesso");
        } catch (Exception e) {
            System.out.println("Atividade não encontrada");
        }
    }
}
