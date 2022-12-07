import java.util.Scanner;
import java.util.ArrayList;

public class EditAction implements Action {
    public void editUser(User user, Scanner scanner) {
        int command = 0;
        System.out.println("1. Editar nome\n" + "2.Editar profissão\n");
        try {
            command = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido");
        }
        switch (command) {
            case 1:
                System.out.println("Digite o novo nome do usuário:");
                String name = scanner.nextLine();
                user.setName(name);
                break;
            case 2:
                System.out.println("Digite a nova profissão do usuário:");
                String role = scanner.nextLine();
                user.setRole(role);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void selfEdit(User user, Scanner scanner) {
        int command = 0;
        System.out.println("1. Editar nome\n" + "2.Editar profissão\n" + "3.Editar senha\n");
        try {
            command = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido");
        }
        switch (command) {
            case 1:
                System.out.println("Digite o novo nome do usuário:");
                String name = scanner.nextLine();
                user.setName(name);
                break;
            case 2:
                System.out.println("Digite a nova profissão do usuário:");
                String role = scanner.nextLine();
                user.setRole(role);
                break;
            case 3:
                System.out.println("Digite a nova senha do usuário:");
                String password = scanner.nextLine();
                user.setPassword(password);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void editProject(Project editedProject, ArrayList<User> users, Scanner scanner, Utils searches,
            ArrayList<Activity> activities) {
        int command = 0;
        System.out.println("1. Editar id\n" + "2. Editar descrição\n"
                + "3. Editar data e hora de início\n" + "4. Editar data e hora de término\n"
                + "5. Editar coordenador do projeto\n" + "6. Adicionar profissional ao projeto\n"
                + "7. Editar valor da bolsa\n" + "8. Editar período de vigência da bolsa\n"
                + "9. Adicionar atividade ao projeto");
        try {
            command = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido");
        }

        switch (command) {
            case 1:
                System.out.println("Insira o novo id do projeto: ");
                String id = scanner.nextLine();
                editedProject.setId(id);
                break;

            case 2:
                System.out.println("Insira a nova descrição do projeto: ");
                String description = scanner.nextLine();
                editedProject.setDescription(description);
                ;
                break;

            case 3:
                System.out.println("Insira a nova data e hora de início: ");
                String startDate = scanner.nextLine();
                editedProject.setStartDate(startDate);
                ;
                break;

            case 4:
                System.out.println("Insira a nova data e hora de término: ");
                String finishDate = scanner.nextLine();
                editedProject.setFinishDate(finishDate);
                ;
                break;

            case 5:
                System.out.println("Insira o nome do novo coordenador: ");
                String coordName = scanner.nextLine();
                editedProject.setSupervisor(users.get(searches.getUserIndex(users, coordName)));
                break;

            case 6:
                System.out.println("Insira o nome do profissional: ");
                String username = scanner.nextLine();
                editedProject.getWorkers()
                        .add(users.get(searches.getUserIndex(users, username)));
                users.get(searches.getUserIndex(users, username)).linkedProjects.add(editedProject);
                break;

            case 7:
                System.out.println("Insira o novo valor da bolsa: ");
                int pay = scanner.nextInt();
                scanner.nextLine();
                editedProject.setProjectPay(pay);
                break;

            case 8:
                System.out.println("Insira o novo período de vigência da bolsa: ");
                String projectPaySpan = scanner.nextLine();
                editedProject.setProjectPayTimeSpan(projectPaySpan);
                break;

            case 9:
                System.out.println("1. Adicionar atividade já criada ao projeto\n" +
                        "2. Criar nova atividade e adicioná-la ao projeto");
                int command2 = scanner.nextInt();
                scanner.nextLine();
                if (command2 == 1) {
                    System.out.println("Insira o id da atividade: ");
                    String activityId = scanner.nextLine();
                    editedProject.getProjectActivities()
                            .add(activities.get(searches.getActivityIndex(activityId, activities)));
                } else if (command2 == 2) {
                    AddAction addAction = new AddAction();
                    addAction.addActivity(activities, users, scanner, searches);
                } else {
                    System.out.println("Opção inválida");
                }
            default:
                break;
        }
        System.out.println("Edição de projeto concluída com sucesso.");
    }

    public void editActivity(Activity editedActivity, ArrayList<User> users, Scanner scanner, Utils searches) {
        System.out.println("1. Editar id\n"
                + "2. Editar descrição\n"
                + "3. Editar data e hora de início\n"
                + "4. Editar data e hora de término\n"
                + "5. Editar responsável pela atividade\n"
                + "6. Adicionar profissional a atividade\n"
                + "7. Adicionar tarefa a ser realizada\n"
                + "8. Marcar tarefa como concluída\n"
                + "9. Adicionar profissional de outro projeto");

        int command = 0;
        try {
            command = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um número válido");
        }

        switch (command) {
            case 1:
                System.out.println("Insira o novo id: ");
                String id = scanner.nextLine();
                editedActivity.setId(id);
                break;

            case 2:
                System.out.println("Insira a nova descrição: ");
                String description = scanner.nextLine();
                editedActivity.setDescription(description);
                break;

            case 3:
                System.out.println("Insira a nova data e hora de início: ");
                String startDate = scanner.nextLine();
                editedActivity.setStartDate(startDate);
                break;

            case 4:
                System.out.println("Insira a nova data e hora de término: ");
                String finishDate = scanner.nextLine();
                editedActivity.setFinishDate(finishDate);
                break;

            case 5:
                System.out.println("Insira o novo supervisor: ");
                String coordName = scanner.nextLine();
                editedActivity
                        .setSupervisor(users.get(searches.getUserIndex(users, coordName)));
                break;

            case 6:
                System.out.println("Insira o nome do usuário: ");
                String userId = scanner.nextLine();
                editedActivity.getWorkers().add(users.get(searches.getUserIndex(users, userId)));
                users.get(searches.getUserIndex(users, userId)).linkedActivies.add(editedActivity);
                break;

            case 7:
                System.out.println("Insira o nome da tarefa: ");
                String taskName = scanner.nextLine();
                editedActivity.getTasks().add(new Task(taskName));
                break;

            case 8:
                System.out.println("Insira o nome da tarefa: ");
                String doneTask = scanner.nextLine();
                ArrayList<Task> tasks = editedActivity.getTasks();
                tasks.get(searches.getTaskIndex(doneTask, tasks)).setDone(true);
                break;

            case 9:
                System.out.println("Insira o nome do usuário: ");
                String borrowedUserId = scanner.nextLine();
                editedActivity.getTempWorkers().add(users.get(searches.getUserIndex(users, borrowedUserId)));
        }

        System.out.println("Alteração realizada com sucesso");
    }
}
