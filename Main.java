import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int returnIndex(String id, ArrayList<Project> projects){
        int count = 0;
        for(Project item : projects){
            if(item.projectId == id){
                break;
            }
            else
                ++count;
        }
        return count-1;
    }

    public static int returnIndexWorker(String name, ArrayList<Worker> workers){
        int count = 0;
        for(Worker item : workers){
            if(item.name == name){
                break;
            }
            else
                ++count;
        }
        return count-1;
    }

    public static int returnIndexActivity(String id, ArrayList<Activity> activities){
        int count = 0;
        for(Activity item : activities){
            if(item.activityId == id){
                break;
            }
            else
                ++count;
        }
        return count-1;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Worker> users = new ArrayList<Worker>();
        ArrayList<Project> projects = new ArrayList<Project>();
        int command;
        String userName, userRole, description, id, startDate, finishDate, coordName, projectPaySpan, searchIndex;
        double pay;
        while (true) {
            System.out.println(
                    "Insira '1' para criar um usuário, projeto ou atividade, '2' para editar um usuário, projeto ou atividade, e '0' para sair do programa.");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0)
                break;

            else if (command == 1) {
                System.out.println("Insira '1' para adicionar um usuário, projeto ou atividade, ou '2' para remover.");
                command = scan.nextInt();
                scan.nextLine();
                if(command == 1){
                    System.out.println("Insira '1' para adicionar um usuário, '2' para adicionar um projeto, '3' para adicionar uma atividade ou qualquer outra tecla para sair.");
                    command = scan.nextInt();
                    scan.nextLine();
                    if(command == 1){
                        System.out.println("Insira o nome do usuário:");
                        userName = scan.nextLine();
                        System.out.println("Insira a profissão do usuário:");
                        userRole = scan.nextLine();
                        users.add(new Worker(userName, userRole));
                    }
                    else if(command == 2){
                        System.out.println(
                            "Insira, em sequência as seguintes informações do projeto: Identificação, descrição, data e hora do início, data e hora do término, coordenador do projeto, valor da bolsa e período de vigência da bolsa:");
                            id = scan.nextLine();
                            description = scan.nextLine();
                            startDate = scan.nextLine();
                            finishDate = scan.nextLine();
                            coordName = scan.nextLine();
                            pay = scan.nextInt();
                            scan.nextLine();
                            projectPaySpan = scan.nextLine();
                            projects.add(new Project(id, description, startDate, finishDate, projectPaySpan, coordName, pay, users));
                    }
                    else if(command == 3){
                        System.out.println("Insira, em sequência as seguintes informações da atividade: Identificação, descrição, data e hora do início, data e hora do término e supervisor da atividade: ");
                        id = scan.nextLine();
                        description = scan.nextLine();
                        startDate = scan.nextLine();
                        finishDate = scan.nextLine();
                        coordName = scan.nextLine();
                        System.out.println("Insira o id do projeto para inclusão da atividade:");
                        searchIndex = scan.nextLine();
                        Project addingProject = projects.get(returnIndex(searchIndex, projects));
                        addingProject.addActivity(new Activity(id, description, startDate, finishDate, coordName)); 
                    }
                }

            else if(command == 2){
                System.out.println("Insira '1' para remover um usuário, '2' para remover um projeto, '3' para remover uma atividade ou qualquer outra tecla para sair.");
                command = scan.nextInt();
                scan.nextLine();
                if(command == 1){
                    System.out.println("Insira o nome do usuário a ser removido: ");
                    id = scan.nextLine();
                    users.remove(returnIndexWorker(id, users));
                    System.out.println("Usuário removido com sucesso.");
                }
                else if(command == 2){
                    System.out.println("Insira o id do projeto a ser removido: ");
                    id = scan.nextLine();
                    projects.remove(returnIndex(id, projects));
                    System.out.println("Projeto removido com sucesso.");
                }
                else if(command == 3){
                    System.out.println("Insira o id do projeto que contém a atividade: ");
                    id = scan.nextLine();
                    Project addingProject = projects.get(returnIndex(id, projects));
                    System.out.println("Insira o id da atividade a ser removida: ");
                    id = scan.nextLine();
                    addingProject.projectActivities.remove(returnIndexActivity(id, addingProject.projectActivities));
                    System.out.println("Atividade removida com sucesso.");
                }
                else continue;
            }
                    
            } else if (command == 2) {
                System.out.println("1. Editar usuário");
                System.out.println("2. Editar projeto");
                System.out.println("3. Editar atividade");
                System.out.println("0. Sair do menu");
                command = scan.nextInt();
                scan.nextLine();
                
                if(command == 0) continue;

                else if(command == 1){
                    System.out.println("Insira o nome do usuário: ");
                    id = scan.nextLine();
                    Worker editedUser = users.get(returnIndexWorker(id, users));

                    System.out.println("1. Editar nome");
                    System.out.println("2. Editar profissão");
                    command = scan.nextInt();
                    scan.nextLine();

                    if(command == 1){
                        System.out.println("Insira o novo nome do usuário: ");
                        id = scan.nextLine();
                        editedUser.name = id;
                        System.out.println("Nome do usuário editado com sucesso.");
                    }
                    else if(command == 2){
                        System.out.println("Insira a nova profissão do usuário: ");
                        id = scan.nextLine();
                        editedUser.role = id;
                        System.out.println("Profissão do usuário editada com sucesso.");
                    }
                }
                else if(command == 2){
                    System.out.println("Insira o id do projeto: ");
                    id = scan.nextLine();
                    Project editedProject = projects.get(returnIndex(id, projects));

                    System.out.println("1. Editar id.");
                    System.out.println("2. Editar descrição.");
                    System.out.println("3. Editar data e hora de início.");
                    System.out.println("4. Editar data e hora de término.");
                    System.out.println("5. Editar coordenador do projeto.");
                    System.out.println("6. Adicionar profissional ao projeto");
                    System.out.println("7. Editar valor da bolsa");
                    System.out.println("8. Editar período de vigência da bolsa");

                    command = scan.nextInt();
                    scan.nextLine();

                    switch(command) {
                        case 1:
                            System.out.println("Insira o novo id do projeto: ");
                            id = scan.nextLine();
                            editedProject.projectId = id;
                            break;

                        case 2:
                            System.out.println("Insira a nova descrição do projeto: ");
                            description = scan.nextLine();
                            editedProject.description = description;
                            break;

                        case 3:
                            System.out.println("Insira a nova data e hora de início: ");
                            startDate = scan.nextLine();
                            editedProject.startDate = startDate;
                            break;

                        case 4:
                            System.out.println("Insira a nova data e hora de término: ");
                            finishDate = scan.nextLine();
                            editedProject.finishDate = finishDate;
                            break;

                        case 5:
                            System.out.println("Insira o novo coordenador: ");
                            coordName = scan.nextLine();
                            editedProject.projectCoordinator = coordName;
                            break;

                        case 6:
                            System.out.println("Insira o nome do usuário: ");
                            id = scan.nextLine();
                            Worker newWorker = users.get(returnIndexWorker(id, users));
                            editedProject.projectWorkers.add(newWorker);
                            break;
                        
                        case 7:
                            System.out.println("Insira o novo valor da bolsa: ");
                            pay = scan.nextInt();
                            scan.nextLine();
                            editedProject.projectPay = pay;
                            break;
                        
                        case 8:
                            System.out.println("Insira o novo período de vigência da bolsa: ");
                            projectPaySpan = scan.nextLine();
                            editedProject.projectPayTimeSpan = projectPaySpan;
                            break;
                        
                        default:
                            continue;
                            
                    }
                    System.out.println("Edição de projeto concluída com sucesso.");
                }
            } else if(command == 3){

                System.out.println("Insira o id do projeto onde se encontra a atividade: ");
                id = scan.nextLine();
                Project editedProject = projects.get(returnIndex(id, projects));

                System.out.println("Insira o id da atividade: ");
                id = scan.nextLine();
                Activity editedActivity = editedProject.projectActivities.get(returnIndexActivity(id, editedProject.projectActivities)); 

                System.out.println("1. Editar id.");
                System.out.println("2. Editar descrição.");
                System.out.println("3. Editar data e hora de início.");
                System.out.println("4. Editar data e hora de término.");
                System.out.println("5. Editar responsável pela atividade.");
                System.out.println("6. Adicionar profissional a atividade.");
                System.out.println("7. Adicionar tarefa a ser realizada.");

                command = scan.nextInt();
                scan.nextLine();

                switch(command) {
                    case 1:
                        System.out.println("Insira o novo id: ");
                        id = scan.nextLine();
                        editedActivity.activityId = id;
                        break;

                    case 2:
                        System.out.println("Insira a nova descrição: ");
                        description = scan.nextLine();
                        editedActivity.activityDescription = description;
                        break;

                    case 3:
                        System.out.println("Insira a nova data e hora de início: ");
                        startDate = scan.nextLine();
                        editedActivity.startDate = startDate;
                        break;

                    case 4:
                        System.out.println("Insira a nova data e hora de término: ");
                        finishDate = scan.nextLine();
                        editedActivity.finishDate = finishDate;
                        break;

                    case 5:
                        System.out.println("Insira o novo supervisor: ");
                        coordName = scan.nextLine();
                        editedActivity.activitySupervisor = coordName;
                        break;

                    case 6:
                        System.out.println("Insira o nome do usuário: ");
                        id = scan.nextLine();
                        Worker newWorker = users.get(returnIndexWorker(id, users));
                        editedActivity.activityWorkers.add(newWorker);
                        break;
                    
                    case 7:
                        System.out.println("Insira a nova task: ");
                        id = scan.nextLine();
                        editedActivity.tasks.add(id);
                        break;
            }
                
        }
        scan.close();
    }
}
}