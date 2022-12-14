import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

   public static int getProjectIndex(String id, ArrayList<Project> projects) {
      int count = 0;
      for (Project item : projects) {
         if (item.projectId == id) {
            break;
         } else
            ++count;
      }
      return count - 1;
   }

   public static int getUserAccountIndex(ArrayList<User> users, String name) {
      for (int i = 0; i < users.size(); i++) {
         if (users.get(i).login.equals(name))
            return i;
      }
      return -1;
   }

   public static int getUserIndex(ArrayList<User> users, String name) {
      for (int i = 0; i < users.size(); i++) {
         if (users.get(i).name.equals(name))
            return i;
      }
      return -1;
   }

   public static int getActivityIndex(String id, ArrayList<Activity> activities) {
      int count = 0;
      for (Activity item : activities) {
         if (item.activityId == id) {
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
      int command, accountIndex;
      String userName, userRole, description, id, startDate, finishDate, coordName, projectPaySpan,
            userLogin, userPassword;
      double pay;
      boolean isUserLogged = false;
      User loggedUser = null;

      while (true) {
         if (!isUserLogged) {
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
                  System.out.println("Usu??rio n??o encontrado");
                  continue;
               }

               loggedUser = users.get(accountIndex);
               System.out.println("Insira sua senha");
               userPassword = scan.nextLine();

               if (loggedUser.password.equals(userPassword)) {
                  isUserLogged = true;
                  System.out.println("Logado com sucesso. Bem vindo, " + loggedUser.name + ".");
               } else
                  System.out.println("A senha inserida n??o corresponde ao login informado");
            } else if (command == 2) {
               System.out.println("Insira seu nome");
               userName = scan.nextLine();
               System.out.println("Insira sua profiss??o");
               userRole = scan.nextLine();
               System.out.println("Insira seu login");
               userLogin = scan.nextLine();
               System.out.println("Insira sua senha");
               userPassword = scan.nextLine();

               users.add(new User(userName, userRole, userLogin, userPassword));
            } else if (command == 3) {
               System.out.println("Insira o login da conta que voc?? deseja recuperar");
               userLogin = scan.nextLine();
               accountIndex = getUserAccountIndex(users, userLogin);

               if (accountIndex == -1) {
                  System.out.println("Usu??rio n??o encontrado");
                  continue;
               }

               System.out.println("Insira o nome de usu??rio da conta que voc?? deseja recuperar");
               userName = scan.nextLine();
               if (!users.get(accountIndex).name.equals(userName)) {
                  System.out.println("O nome informado n??o corresponde ao do usu??rio cadastrado");
                  continue;
               }
               System.out.println("Insira a nova senha");
               userPassword = scan.nextLine();
               users.get(accountIndex).password = userPassword;
               System.out.println("Senha alterada com sucesso");
            }
         } else {
            if (getUserAccountIndex(users, loggedUser.login) == -1) {
               isUserLogged = false;
               loggedUser = null;
               continue;
            }
            System.out.println(
                  "1. Criar ou remover\n" +
                        "2. Editar\n" +
                        "3. Consultas\n" +
                        "4. Relat??rios\n" +
                        "5. Gerar pagamento\n" +
                        "6. Atualizar status de projeto\n" +
                        "0. Sair");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0) {
               break;
            } else if (command == 1) {
               if (!loggedUser.coordinator) {
                  System.out.println("Usu??rio n??o autorizado");
                  continue;
               }
               System.out.println("1. Adicionar um usu??rio, projeto ou atividade\n" +
                     "2. Remover um usu??rio, projeto ou atividade");
               command = scan.nextInt();
               scan.nextLine();
               if (command == 1) {
                  System.out.println("1. Adicionar um usu??rio\n" +
                        "2. Adicionar um projeto\n" +
                        "3. Adicionar uma atividade");
                  command = scan.nextInt();
                  scan.nextLine();
                  if (command == 1) {
                     System.out.println("Insira o nome do usu??rio");
                     userName = scan.nextLine();
                     System.out.println("Insira a profiss??o do usu??rio");
                     userRole = scan.nextLine();
                     System.out.println("Insira o login do usu??rio");
                     userLogin = scan.nextLine();
                     System.out.println("Insira a senha do usu??rio");
                     userPassword = scan.nextLine();
                     users.add(new User(userName, userRole, userLogin, userPassword));
                  } else if (command == 2 && loggedUser.coordinator) {
                     System.out.println(
                           "Insira, em sequ??ncia as seguintes informa????es do projeto: Identifica????o, descri????o, data e hora do in??cio, data e hora do t??rmino, coordenador do projeto, valor da bolsa e per??odo de vig??ncia da bolsa:");
                     id = scan.nextLine();
                     description = scan.nextLine();
                     startDate = scan.nextLine();
                     finishDate = scan.nextLine();
                     coordName = scan.nextLine();
                     pay = scan.nextInt();
                     scan.nextLine();
                     projectPaySpan = scan.nextLine();
                     projects.add(new Project(id, description, startDate, finishDate, projectPaySpan,
                           users.get(getUserIndex(users, coordName)),
                           pay, users));
                  } else if (command == 3 && loggedUser.coordinator) {
                     System.out.println(
                           "Insira, em sequ??ncia as seguintes informa????es da atividade: Identifica????o, descri????o, data e hora do in??cio, data e hora do t??rmino e supervisor da atividade: ");
                     id = scan.nextLine();
                     description = scan.nextLine();
                     startDate = scan.nextLine();
                     finishDate = scan.nextLine();
                     coordName = scan.nextLine();
                     activities.add(new Activity(id, description, startDate, finishDate, coordName));
                  }
               }

               else if (command == 2) {

                  System.out.println(
                        "Insira '1' para remover um usu??rio, '2' para remover um projeto, '3' para remover uma atividade ou qualquer outra tecla para sair.");
                  command = scan.nextInt();
                  scan.nextLine();
                  if (command == 1) {
                     System.out.println("Insira o nome do usu??rio a ser removido: ");
                     id = scan.nextLine();
                     users.remove(getUserIndex(users, id));
                     System.out.println("Usu??rio removido com sucesso.");
                  } else if (command == 2) {
                     System.out.println("Insira o id do projeto a ser removido: ");
                     id = scan.nextLine();
                     projects.remove(getProjectIndex(id, projects));
                     System.out.println("Projeto removido com sucesso.");
                  } else if (command == 3) {
                     System.out.println("Insira o id do projeto que cont??m a atividade: ");
                     id = scan.nextLine();
                     Project addingProject = projects.get(getProjectIndex(id, projects));
                     System.out.println("Insira o id da atividade a ser removida: ");
                     id = scan.nextLine();
                     addingProject.projectActivities
                           .remove(getActivityIndex(id, addingProject.projectActivities));
                     System.out.println("Atividade removida com sucesso.");
                  } else
                     continue;
               }
            } else if (command == 2) {
               if (!loggedUser.coordinator) {
                  System.out.println("Usu??rio n??o autorizado");
                  continue;
               }
               System.out.println("1. Editar usu??rio\n" +
                     "2. Editar projeto\n" +
                     "3. Editar atividade\n" +
                     "0. Sair do menu");
               command = scan.nextInt();
               scan.nextLine();

               if (command == 0)
                  continue;

               else if (command == 1) {
                  System.out.println("Insira o nome do usu??rio: ");
                  userName = scan.nextLine();
                  User editedUser = users.get(getUserIndex(users, userName));

                  System.out.println("1. Editar nome");
                  System.out.println("2. Editar profiss??o");
                  if (editedUser.equals(loggedUser))
                     System.out.println("3.Alterar senha");
                  command = scan.nextInt();
                  scan.nextLine();

                  if (command == 1) {
                     System.out.println("Insira o novo nome do usu??rio: ");
                     id = scan.nextLine();
                     editedUser.name = id;
                     System.out.println("Nome do usu??rio alterado com sucesso.");
                  } else if (command == 2) {
                     System.out.println("Insira a nova profiss??o do usu??rio: ");
                     id = scan.nextLine();
                     editedUser.role = id;
                     System.out.println("Profiss??o do usu??rio alterada com sucesso.");
                  } else if (command == 3 && editedUser.equals(loggedUser)) {
                     System.out.println("Insira a nova senha: ");
                     userPassword = scan.nextLine();
                     loggedUser.password = userPassword;
                     System.out.println("Senha alterada com sucesso.");
                  }
               } else if (command == 2) {
                  System.out.println("Insira o id do projeto: ");
                  id = scan.nextLine();
                  Project editedProject = projects.get(getProjectIndex(id, projects));

                  System.out.println("1. Editar id.");
                  System.out.println("2. Editar descri????o.");
                  System.out.println("3. Editar data e hora de in??cio.");
                  System.out.println("4. Editar data e hora de t??rmino.");
                  System.out.println("5. Editar coordenador do projeto.");
                  System.out.println("6. Adicionar profissional ao projeto");
                  System.out.println("7. Editar valor da bolsa");
                  System.out.println("8. Editar per??odo de vig??ncia da bolsa");
                  System.out.println("9. Adicionar atividade ao projeto");

                  command = scan.nextInt();
                  scan.nextLine();

                  switch (command) {
                     case 1:
                        System.out.println("Insira o novo id do projeto: ");
                        id = scan.nextLine();
                        editedProject.projectId = id;
                        break;

                     case 2:
                        System.out.println("Insira a nova descri????o do projeto: ");
                        description = scan.nextLine();
                        editedProject.description = description;
                        break;

                     case 3:
                        System.out.println("Insira a nova data e hora de in??cio: ");
                        startDate = scan.nextLine();
                        editedProject.startDate = startDate;
                        break;

                     case 4:
                        System.out.println("Insira a nova data e hora de t??rmino: ");
                        finishDate = scan.nextLine();
                        editedProject.finishDate = finishDate;
                        break;

                     case 5:
                        System.out.println("Insira o nome do novo coordenador: ");
                        coordName = scan.nextLine();
                        editedProject.projectCoordinator = users.get(getUserIndex(users, coordName));
                        break;

                     case 6:
                        System.out.println("Insira o nome do profissional: ");
                        userName = scan.nextLine();
                        editedProject.projectWorkers.add(users.get(getUserIndex(users, userName)));
                        users.get(getUserIndex(users, userName)).linkedProjects.add(editedProject);
                        break;

                     case 7:
                        System.out.println("Insira o novo valor da bolsa: ");
                        pay = scan.nextInt();
                        scan.nextLine();
                        editedProject.projectPay = pay;
                        break;

                     case 8:
                        System.out.println("Insira o novo per??odo de vig??ncia da bolsa: ");
                        projectPaySpan = scan.nextLine();
                        editedProject.projectPayTimeSpan = projectPaySpan;
                        break;
                     
                     case 9:
                        System.out.println("Insira o id da atividade: ");
                        id = scan.nextLine();
                        editedProject.projectActivities.add(activities.get(getActivityIndex(id, activities)));

                     default:
                        continue;

                  }
                  System.out.println("Edi????o de projeto conclu??da com sucesso.");
               } else if (command == 3) {
                  System.out.println("Insira o id da atividade: ");
                  id = scan.nextLine();
                  Activity editedActivity = activities.get(getActivityIndex(id, activities));
                  System.out.println("1. Editar id.");
                  System.out.println("2. Editar descri????o.");
                  System.out.println("3. Editar data e hora de in??cio.");
                  System.out.println("4. Editar data e hora de t??rmino.");
                  System.out.println("5. Editar respons??vel pela atividade.");
                  System.out.println("6. Adicionar profissional a atividade.");
                  System.out.println("7. Adicionar tarefa a ser realizada.");
                  System.out.println("8. Adicionar profissional de outro projeto.");
                  
                  command = scan.nextInt();
                  scan.nextLine();

                  switch (command) {
                     case 1:
                        System.out.println("Insira o novo id: ");
                        id = scan.nextLine();
                        editedActivity.activityId = id;
                        break;

                     case 2:
                        System.out.println("Insira a nova descri????o: ");
                        description = scan.nextLine();
                        editedActivity.activityDescription = description;
                        break;

                     case 3:
                        System.out.println("Insira a nova data e hora de in??cio: ");
                        startDate = scan.nextLine();
                        editedActivity.startDate = startDate;
                        break;

                     case 4:
                        System.out.println("Insira a nova data e hora de t??rmino: ");
                        finishDate = scan.nextLine();
                        editedActivity.finishDate = finishDate;
                        break;

                     case 5:
                        System.out.println("Insira o novo supervisor: ");
                        coordName = scan.nextLine();
                        editedActivity.activitySupervisor = coordName;
                        break;

                     case 6:
                        System.out.println("Insira o nome do usu??rio: ");
                        id = scan.nextLine();
                        editedActivity.activityWorkers.add(users.get(getUserIndex(users, id)));
                        users.get(getUserIndex(users, id)).linkedActivies.add(editedActivity);
                        break;

                     case 7:
                        System.out.println("Insira a nova task: ");
                        id = scan.nextLine();
                        editedActivity.tasks.add(id);
                        break;

                     case 8:
                        System.out.println("Insira o nome do usu??rio: ");
                        id = scan.nextLine();
                        editedActivity.tempWorkers.add(users.get(getUserIndex(users, id)));
                  }
               }
            } else if (command == 3) {
               System.out.println(
                     "1. Consultar usu??rios\n" +
                           "2. Consultar projetos\n" +
                           "3. Consultar atividades\n" +
                           "0. Voltar.");
               command = scan.nextInt();
               scan.nextLine();

               if (command == 0)
                  continue;

               else if (command == 1) {
                  System.out.println("Insira o nome do usu??rio");
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
            } else if (command == 4) {
               System.out.println(
                     "1. Usu??rios\n" +
                           "2. Projetos\n" +
                           "3. Atividades\n" +
                           "0. Voltar");
               command = scan.nextInt();
               scan.nextLine();
               if (command == 0)
                  continue;
               System.out.println("====================");
               if (command == 1) {
                  for (User user : users) {
                     user.displayUserInfo();
                  }
               } else if (command == 2) {
                  if (projects.isEmpty()) {
                     System.out.println("Nenhum projeto foi adicionado ao sistema.");
                     continue;
                  }
                  for (Project project : projects) {
                     project.displayProjectInfo();
                  }
               } else if (command == 3) {
                  if (activities.isEmpty()) {
                     System.out.println("Nenhuma atividade foi adicionada ao sistema.");
                     continue;
                  }
                  for (Activity activity : activities) {
                     activity.displayActivityInfo();
                  }
               }
               System.out.println("====================");
            } else if (command == 5) {
               System.out.println("--------------------");
               System.out.println("Pagamentos no dia " + LocalDate.now() + ":");
               for (Project project : projects) {
                  if (project.projectWorkers.isEmpty())
                     continue;
                  for (User projectWorker : users) {
                     System.out.println("- " + projectWorker.name + ": R$" + project.projectPay);
                  }
               }
               System.out.println("--------------------");
            } else if (command == 6) {
               if (!loggedUser.coordinator) {
                  System.out.println("Usu??rio n??o autorizado");
                  continue;
               }
               System.out.println("Escolha o projeto:");
               for (int i = 0; i < projects.size(); i++) {
                  System.out.println(i + 1 + ". " + projects.get(i).projectId);
               }
               command = scan.nextInt();
               scan.nextLine();

               projects.get(command - 1).updateStatus();
            }
         }
      }
      scan.close();
   }
}
