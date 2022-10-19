import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

    public static int getUserAccountIndex(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(name))
                return i;
        }
        return -1;
    }

    public static int getProjectIndex(String id, ArrayList<Project> projects) {
        int count = 0;
        for (Project item : projects) {
            if (item.getProjectId() == id) {
                break;
            } else
                ++count;
        }
        return count - 1;
    }

    public static int getUserIndex(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public static int getActivityIndex(String id, ArrayList<Activity> activities) {
        int count = 0;
        for (Activity item : activities) {
            if (item.getActivityId() == id) {
                break;
            } else
                ++count;
        }
        return count - 1;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Project> projects = new ArrayList<Project>();
        ArrayList<Activity> activities = new ArrayList<Activity>();
        boolean isUserLogged = false;
        int command, accountIndex, pay;
        User loggedUser = null;
        String userLogin, userPassword, userRole, userName, id, description, startDate, finishDate, coordName,
                projectPaySpan;

        while (!isUserLogged) {
            System.out.println("1. Fazer login\n" +
                    "2. Fazer cadastro\n" +
                    "3. Recuperar senha");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 1) {
                System.out.println("Insira seu login");
                userLogin = scan.nextLine();

                accountIndex = getUserAccountIndex(users, userLogin);

                if (accountIndex == -1) {
                    System.out.println("Usuário não encontrado");
                    continue;
                }

                loggedUser = users.get(accountIndex);
                System.out.println("Insira sua senha");
                userPassword = scan.nextLine();

                if (loggedUser.getPassword().equals(userPassword)) {
                    isUserLogged = true;
                    System.out.println("Logado com sucesso. Bem vindo, " + loggedUser.getName());
                } else
                    System.out.println("A senha inserida não corresponde ao login informado");
            } else if (command == 2) {
                System.out.println("Insira seu nome");
                userName = scan.nextLine();
                System.out.println("Insira sua profissão");
                userRole = scan.nextLine();
                System.out.println("Insira seu login");
                userLogin = scan.nextLine();
                System.out.println("Insira sua senha");
                userPassword = scan.nextLine();

                if (userRole.equals("Professor") || userRole.equals("Pesquisador")) {
                    users.add(new Coordinator(userName, userRole, userLogin, userPassword));
                } else
                    users.add(new User(userName, userRole, userLogin, userPassword));
            } else if (command == 3) {
                System.out.println("Insira o login da conta que você deseja recuperar");
                userLogin = scan.nextLine();
                accountIndex = getUserAccountIndex(users, userLogin);

                if (accountIndex == -1) {
                    System.out.println("Usuário não encontrado");
                    continue;
                }

                System.out.println("Insira o nome de usuário da conta que você deseja recuperar");
                userName = scan.nextLine();
                if (!users.get(accountIndex).getName().equals(userName)) {
                    System.out.println("O nome informado não corresponde ao do usuário cadastrado");
                    continue;
                }
                System.out.println("Insira a nova senha");
                userPassword = scan.nextLine();
                users.get(accountIndex).setPassword(userPassword);
                System.out.println("Senha alterada com sucesso");
            } else
                System.out.println("Comando inválido, tente novamente");
        }
        while (true) {
            loggedUser.menu();
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0) {
                break;
            } else if (command == 1) {
                System.out.println(
                        "1. Consultar usuários\n" +
                                "2. Consultar projetos\n" +
                                "3. Consultar atividades\n" +
                                "0. Voltar.");
                command = scan.nextInt();
                scan.nextLine();

                if (command == 0)
                    continue;
                else if (command == 1) {
                    System.out.println("Insira o nome do usuário");
                    userName = scan.nextLine();
                    users.get(getUserIndex(users, userName)).displayUserInfo();
                } else if (command == 2) {
                    System.out.println("Insira o id do projeto");
                    id = scan.nextLine();
                    projects.get(getProjectIndex(id, projects)).displayProjectInfo();
                } else if (command == 3) {
                    System.out.println("Insira o id da atividade");
                    id = scan.nextLine();
                    activities.get(getActivityIndex(id, activities)).displayActivityInfo();
                }
            } else if (command == 2) {
                System.out.println("1. Projetos\n" +
                        "2. Atividades\n" +
                        "0. Voltar");
                command = scan.nextInt();
                scan.nextLine();

                if (command == 0)
                    continue;

                System.out.println("====================");

                if (command == 1) {
                    if (projects.isEmpty()) {
                        System.out.println("Nenhum projeto foi adicionado ao sistema.");
                        continue;
                    }
                    for (Project project : projects) {
                        project.displayProjectInfo();
                    }
                } else if (command == 2) {
                    if (activities.isEmpty()) {
                        System.out.println("Nenhuma atividade foi adicionada ao sistema.");
                        continue;
                    }
                    for (Activity activity : activities) {
                        activity.displayActivityInfo();
                    }
                }

                System.out.println("====================");
            } else if (command == 3) {
                System.out.println("1. Alterar nome\n" +
                        "2. Alterar login\n" +
                        "3. Alterar senha\n" +
                        "0. Voltar");
                command = scan.nextInt();
                scan.nextLine();

                if (command == 0) {
                    continue;
                } else if (command == 1) {
                    System.out.println("Insira o novo nome: ");
                    loggedUser.setName(scan.nextLine());
                } else if (command == 2) {
                    System.out.println("Insira o novo login: ");
                    loggedUser.setLogin(scan.nextLine());
                } else if (command == 3) {
                    System.out.println("Insira a nova senha: ");
                    loggedUser.setPassword(scan.nextLine());
                }
            } else if (command == 4) {
                System.out.println("1. Criar projeto\n" +
                        "2. Excluir projeto\n" +
                        "3. Editar projeto\n" +
                        "4. Alterar status do projeto" +
                        "0. Voltar");
                command = scan.nextInt();
                scan.nextLine();

                if (command == 0) {
                    continue;
                } else if (command == 1) {
                    System.out.println(
                            "Insira, em sequência as seguintes informações do projeto: " +
                                    "Identificação, descrição, data e hora do início, data e hora do término e coordenador do projeto,:");
                    id = scan.nextLine();
                    description = scan.nextLine();
                    startDate = scan.nextLine();
                    finishDate = scan.nextLine();
                    coordName = scan.nextLine();

                    projects.add(new Project(id, description, startDate, finishDate,
                            users.get(getUserIndex(users, coordName))));
                } else if (command == 2) {
                    System.out.println("Insira o id do projeto a ser removido: ");
                    id = scan.nextLine();
                    projects.remove(getProjectIndex(id, projects));
                    System.out.println("Projeto removido com sucesso.");
                } else if (command == 3) {
                    System.out.println("Insira o id do projeto: ");
                    id = scan.nextLine();
                    Project editedProject = projects.get(getProjectIndex(id, projects));

                    System.out.println("1. Editar id\n" +
                            "2. Editar descrição\n" +
                            "3. Editar data e hora de início\n" +
                            "4. Editar data e hora de término\n" +
                            "5. Editar coordenador do projeto\n" +
                            "6. Adicionar profissional ao projeto\n" +
                            "7. Editar valor da bolsa\n" +
                            "8. Editar período de vigência da bolsa\n" +
                            "9. Adicionar atividade ao projeto");

                    command = scan.nextInt();
                    scan.nextLine();

                    switch (command) {
                        case 1:
                            System.out.println("Insira o novo id do projeto: ");
                            id = scan.nextLine();
                            editedProject.setProjectId(id);
                            break;

                        case 2:
                            System.out.println("Insira a nova descrição do projeto: ");
                            description = scan.nextLine();
                            editedProject.setDescription(description);
                            ;
                            break;

                        case 3:
                            System.out.println("Insira a nova data e hora de início: ");
                            startDate = scan.nextLine();
                            editedProject.setStartDate(startDate);
                            ;
                            break;

                        case 4:
                            System.out.println("Insira a nova data e hora de término: ");
                            finishDate = scan.nextLine();
                            editedProject.setFinishDate(finishDate);
                            ;
                            break;

                        case 5:
                            System.out.println("Insira o nome do novo coordenador: ");
                            coordName = scan.nextLine();
                            editedProject.setProjectCoordinator(users.get(getUserIndex(users, coordName)));
                            break;

                        case 6:
                            System.out.println("Insira o nome do profissional: ");
                            userName = scan.nextLine();
                            editedProject.getProjectWorkers().add(users.get(getUserIndex(users, userName)));
                            users.get(getUserIndex(users, userName)).linkedProjects.add(editedProject);
                            break;

                        case 7:
                            System.out.println("Insira o novo valor da bolsa: ");
                            pay = scan.nextInt();
                            scan.nextLine();
                            editedProject.setProjectPay(pay);
                            break;

                        case 8:
                            System.out.println("Insira o novo período de vigência da bolsa: ");
                            projectPaySpan = scan.nextLine();
                            editedProject.setProjectPayTimeSpan(projectPaySpan);
                            break;

                        case 9:
                            System.out.println("Insira o id da atividade: ");
                            id = scan.nextLine();
                            editedProject.getProjectActivities().add(activities.get(getActivityIndex(id, activities)));

                        default:
                            continue;
                    }
                    System.out.println("Edição de projeto concluída com sucesso.");
                } else if (command == 4) {
                    System.out.println("Insira o id do projeto");
                    id = scan.nextLine();
                    Project editedProject = projects.get(getProjectIndex(id, projects));

                    System.out.println("Tem certeza que deseja prosseguir com a operação?(Y/N)");
                    id = scan.nextLine();

                    if (id.equals("N")) {
                        continue;
                    } else if (id.equals("Y")) {
                        editedProject.updateStatus();
                    }
                }
            } else if (command == 5) {
                System.out.println("1. Criar usuário\n" +
                        "2. Excluir usuário\n" +
                        "3. Editar usuário\n" +
                        "0. Voltar");
                command = scan.nextInt();
                scan.nextLine();

                if (command == 0) {
                    continue;
                } else if (command == 1) {
                    System.out.println("Insira o nome do usuário");
                    userName = scan.nextLine();
                    System.out.println("Insira a profissão do usuário");
                    userRole = scan.nextLine();
                    System.out.println("Insira o login do usuário");
                    userLogin = scan.nextLine();
                    System.out.println("Insira a senha do usuário");
                    userPassword = scan.nextLine();
                    users.add(new User(userName, userRole, userLogin, userPassword));
                } else if (command == 2) {
                    System.out.println("Insira o nome do usuário a ser removido: ");
                    id = scan.nextLine();
                    users.remove(getUserIndex(users, id));
                    System.out.println("Usuário removido com sucesso.");
                } else if (command == 3) {
                    System.out.println("Insira o nome do usuário: ");
                    userName = scan.nextLine();
                    User editedUser = users.get(getUserIndex(users, userName));

                    System.out.println("1. Editar nome");
                    System.out.println("2. Editar profissão");
                    command = scan.nextInt();
                    scan.nextLine();

                    if (command == 1) {
                        System.out.println("Insira o novo nome do usuário: ");
                        id = scan.nextLine();
                        editedUser.setName(id);
                        System.out.println("Nome do usuário alterado com sucesso.");
                    } else if (command == 2) {
                        System.out.println("Insira a nova profissão do usuário: ");
                        userRole = scan.nextLine();
                        editedUser.setRole(userRole);
                        System.out.println("Profissão do usuário alterada com sucesso.");
                    }
                }
            } else if (command == 6) {
                System.out.println("1. Criar Atividade\n" +
                        "2. Excluir Atividade\n" +
                        "3. Editar Atividade\n" +
                        "0. Voltar");
                command = scan.nextInt();
                scan.nextLine();
                if (command == 0) {
                    continue;
                } else if (command == 1) {
                    System.out.println(
                            "Insira, em sequência as seguintes informações da atividade: Identificação, descrição, data e hora do início, data e hora do término e supervisor da atividade: ");
                    id = scan.nextLine();
                    description = scan.nextLine();
                    startDate = scan.nextLine();
                    finishDate = scan.nextLine();
                    coordName = scan.nextLine();
                    activities.add(new Activity(id, description, startDate, finishDate,
                            users.get(getUserIndex(users, coordName))));
                } else if (command == 2) {
                    System.out.println("Insira o id do projeto que contém a atividade: ");
                    id = scan.nextLine();
                    Project addingProject = projects.get(getProjectIndex(id, projects));
                    System.out.println("Insira o id da atividade a ser removida: ");
                    id = scan.nextLine();
                    addingProject.getProjectActivities()
                            .remove(getActivityIndex(id, addingProject.getProjectActivities()));
                    System.out.println("Atividade removida com sucesso.");
                } else if (command == 3) {
                    System.out.println("Insira o id da atividade: ");
                    id = scan.nextLine();
                    Activity editedActivity = activities.get(getActivityIndex(id, activities));
                    System.out.println("1. Editar id.");
                    System.out.println("2. Editar descrição.");
                    System.out.println("3. Editar data e hora de início.");
                    System.out.println("4. Editar data e hora de término.");
                    System.out.println("5. Editar responsável pela atividade.");
                    System.out.println("6. Adicionar profissional a atividade.");
                    System.out.println("7. Adicionar tarefa a ser realizada.");
                    System.out.println("8. Adicionar profissional de outro projeto.");

                    command = scan.nextInt();
                    scan.nextLine();

                    switch (command) {
                        case 1:
                            System.out.println("Insira o novo id: ");
                            id = scan.nextLine();
                            editedActivity.setActivityId(id);
                            break;

                        case 2:
                            System.out.println("Insira a nova descrição: ");
                            description = scan.nextLine();
                            editedActivity.setActivityDescription(description);
                            break;

                        case 3:
                            System.out.println("Insira a nova data e hora de início: ");
                            startDate = scan.nextLine();
                            editedActivity.setStartDate(startDate);
                            break;

                        case 4:
                            System.out.println("Insira a nova data e hora de término: ");
                            finishDate = scan.nextLine();
                            editedActivity.setFinishDate(finishDate);
                            break;

                        case 5:
                            System.out.println("Insira o novo supervisor: ");
                            coordName = scan.nextLine();
                            editedActivity.setActivitySupervisor(users.get(getUserIndex(users, coordName)));
                            break;

                        case 6:
                            System.out.println("Insira o nome do usuário: ");
                            id = scan.nextLine();
                            editedActivity.getActivityWorkers().add(users.get(getUserIndex(users, id)));
                            users.get(getUserIndex(users, id)).linkedActivies.add(editedActivity);
                            break;

                        case 7:
                            System.out.println("Insira a nova task: ");
                            id = scan.nextLine();
                            editedActivity.getTasks().add(id);
                            break;

                        case 8:
                            System.out.println("Insira o nome do usuário: ");
                            id = scan.nextLine();
                            editedActivity.getTempWorkers().add(users.get(getUserIndex(users, id)));
                    }

                    System.out.println("Alteração realizada com sucesso");
                }
            } else if (command == 7) {
                System.out.println("--------------------");
                System.out.println("Pagamentos no dia " + LocalDate.now().toString() + ":");
                for (Project project : projects) {
                    if (project.getProjectWorkers().isEmpty())
                        continue;
                    for (User projectWorker : users) {
                        System.out.println("- " + projectWorker.getName() + ": R$" + project.getProjectPay());
                    }
                }
                System.out.println("--------------------");
            }
        }
        scan.close();
    }
}