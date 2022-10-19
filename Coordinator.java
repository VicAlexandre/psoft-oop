public class Coordinator extends User {
    public Coordinator(String name, String role, String login, String password) {
        super(name, role, login, password);
    }

    @Override
    public void menu() {
        super.menu();
        System.out.println("4. Projetos\n" +
                "5. Usuários\n" +
                "6. Atividades\n" +
                "7. Gerar pagamento");
    }
}
