import java.util.ArrayList;

public class Activity extends Workable {
    private ArrayList<User> tempWorkers;
    private ArrayList<Task> tasks;

    public Activity(String id, String description, String startDate, String finishDate,
            User supervisor) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.supervisor = supervisor;
        this.tasks = new ArrayList<Task>();
        this.workers = new ArrayList<User>();
        this.tempWorkers = new ArrayList<User>();
        System.out.printf(
                "--------------------%nAtividade criada com sucesso. %nId: %s%nDescricao: %s%nSupervisor: %s%n--------------------%n",
                id, description, supervisor.getName());
    }

    public void displayActivityInfo() {
        System.out.println("--------------------");
        System.out.println("Id da atividade: " + this.id);
        System.out.println("Descrição da atividade: " + this.description);
        System.out.println("Supervisor da atividade: " + this.supervisor.getName());
        System.out.println("Tarefas:");
        (this.tasks).forEach(task -> task.displayTaskInfo());
        System.out.println("Data de início da atividade: " + this.startDate);
        System.out.println("Data de término da atividade: " + this.finishDate);
        System.out.println("--------------------");
        return;
    }

    public ArrayList<User> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<User> workers) {
        this.workers = workers;
    }

    public ArrayList<User> getTempWorkers() {
        return tempWorkers;
    }

    public void setTempWorkers(ArrayList<User> tempWorkers) {
        this.tempWorkers = tempWorkers;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
