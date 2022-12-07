import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      ArrayList<User> users = new ArrayList<User>();
      ArrayList<Project> projects = new ArrayList<Project>();
      ArrayList<Activity> activities = new ArrayList<Activity>();
      Utils searches = new Utils();
      boolean isUserLogged = false;
      int command, accountIndex;
      User loggedUser = null;
      String userLogin, userPassword, userName, id;

      while (!isUserLogged) {
         try {
            System.out.println("1. Fazer login\n" +
                  "2. Fazer cadastro\n" +
                  "3. Recuperar senha");
            command = scan.nextInt();
            scan.nextLine();
         } catch (InputMismatchException e) {
            System.out.println("\nErro: durante a navegação no menu, insira apenas números\n");
            scan.nextLine();
            continue;
         }

         if (command == 1) {
            System.out.println("Insira seu login");
            userLogin = scan.nextLine();

            accountIndex = searches.getUserAccountIndex(users, userLogin);

            if (accountIndex == -1) {
               System.out.println("Usuário não encontrado");
               continue;
            }

            loggedUser = users.get(accountIndex);
            System.out.println("Insira sua senha");
            userPassword = scan.nextLine();

            if (loggedUser.password.equals(userPassword)) {
               isUserLogged = true;
               System.out.println("Logado com sucesso. Bem vindo, " + loggedUser.name + ".");
            } else
               System.out.println("A senha inserida não corresponde ao login informado");
         } else if (command == 2) {
            AddAction addUser = new AddAction();
            addUser.addUser(users, scan);
         } else if (command == 3) {
            System.out.println("Insira o login da conta que você deseja recuperar");
            userLogin = scan.nextLine();
            accountIndex = searches.getUserAccountIndex(users, userLogin);

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
         try {
            loggedUser.menu();
            command = scan.nextInt();
            scan.nextLine();
         } catch (InputMismatchException e) {
            System.out.println("\nErro: durante a navegação no menu, insira apenas números\n");
            scan.nextLine();
            continue;
         }

         if (command == 0) {
            break;
         } else if (command == 1) {
            System.out.println("1. Consultar usuários\n" + "2. Consultar projetos\n"
                  + "3. Consultar atividades\n" + "0. Voltar.");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0)
               continue;

            if (command == 1) {
               try {
                  System.out.println("Insira o nome do usuário");
                  userName = scan.nextLine();
                  users.get(searches.getUserIndex(users, userName)).displayUserInfo();
               } catch (IndexOutOfBoundsException e) {
                  System.out.println("Usuário não encontrado");
               }

            } else if (command == 2) {
               try {
                  System.out.println("Insira o id do projeto");
                  id = scan.nextLine();
                  projects.get(searches.getProjectIndex(id, projects)).displayProjectInfo();
               } catch (IndexOutOfBoundsException e) {
                  System.out.println("Projeto não encontrado");
               }
            } else if (command == 3) {
               try {
                  System.out.println("Insira o id da atividade");
                  id = scan.nextLine();
                  activities.get(searches.getActivityIndex(id, activities)).displayActivityInfo();
               } catch (IndexOutOfBoundsException e) {
                  System.out.println("Atividade não encontrada");
               }
            }

         } else if (command == 2) {
            System.out.println("1. Projetos\n" + "2. Atividades\n" + "0. Voltar");
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
            EditAction editSelf = new EditAction();
            editSelf.selfEdit(loggedUser, scan);
         } else if (command == 4) {
            System.out.println("1. Criar projeto\n" + "2. Excluir projeto\n" + "3. Editar projeto\n"
                  + "4. Alterar status do projeto\n" + "0. Voltar");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0) {
               continue;
            } else if (command == 1) {
               AddAction addProject = new AddAction();
               addProject.addProject(projects, users, scan, searches);
            } else if (command == 2) {
               RemoveAction removeProject = new RemoveAction();
               removeProject.removeProject(projects, scan, searches);
            } else if (command == 3) {
               System.out.println("Insira o id do projeto: ");
               id = scan.nextLine();
               Project editedProject = projects.get(searches.getProjectIndex(id, projects));

               EditAction editProject = new EditAction();
               editProject.editProject(editedProject, users, scan, searches, activities);
            } else if (command == 4) {
               System.out.println("Insira o id do projeto");
               id = scan.nextLine();
               Project editedProject = projects.get(searches.getProjectIndex(id, projects));

               System.out.println("Tem certeza que deseja prosseguir com a operação?(Y/N)");
               id = scan.nextLine();

               if (id.equals("N")) {
                  continue;
               } else if (id.equals("Y")) {
                  editedProject.updateStatus();
               }
            }
         } else if (command == 5) {
            System.out.println(
                  "1. Criar usuário\n" + "2. Excluir usuário\n" + "3. Editar usuário\n" + "0. Voltar");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 0) {
               continue;
            } else if (command == 1) {
               AddAction addUser = new AddAction();
               addUser.addUser(users, scan);
            } else if (command == 2) {
               RemoveAction rmvUser = new RemoveAction();
               rmvUser.removeUser(users, scan, searches);
            } else if (command == 3) {
               System.out.println("Insira o nome do usuário: ");
               userName = scan.nextLine();
               User editedUser = users.get(searches.getUserIndex(users, userName));

               EditAction editUser = new EditAction();
               editUser.editUser(editedUser, scan);
            }
         } else if (command == 6) {
            System.out.println(
                  "1. Criar Atividade\n" + "2. Excluir Atividade\n" + "3. Editar Atividade\n" + "0. Voltar");
            command = scan.nextInt();
            scan.nextLine();
            if (command == 0) {
               continue;
            } else if (command == 1) {
               AddAction addActivity = new AddAction();
               addActivity.addActivity(activities, users, scan, searches);
            } else if (command == 2) {
               RemoveAction rmvActivity = new RemoveAction();
               rmvActivity.removeActivity(activities, scan, searches);
            } else if (command == 3) {
               System.out.println("Insira o id da atividade: ");
               id = scan.nextLine();
               Activity editedActivity = activities.get(searches.getActivityIndex(id, activities));

               EditAction editActivity = new EditAction();
               editActivity.editActivity(editedActivity, users, scan, searches);
            }
         } else if (command == 7) {
            System.out.println("--------------------");
            System.out.println("Pagamentos no dia " + LocalDate.now().toString() + ":");
            for (Project project : projects) {
               if (project.getWorkers().isEmpty())
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
