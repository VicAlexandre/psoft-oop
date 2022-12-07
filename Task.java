public class Task {
    private String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public void displayTaskInfo() {
        System.out.println("\tNome da tarefa: " + this.name + " | " + (this.done ? "Concluída" : "Não concluída"));
        return;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
