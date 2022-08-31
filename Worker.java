public class Worker {
    public String name, role;

    public Worker(String name, String role) {
        this.name = name;
        this.role = role;
        System.out.printf("--------------------%nUsuário adicionado com sucesso. %nNome: %s%nProfissão: %s%n--------------------%n", name, role);
    }
}