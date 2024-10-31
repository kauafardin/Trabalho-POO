import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoMotoristas {
    private List<Motorista> motoristas;
    private Scanner scanner;

    public GerenciamentoMotoristas() {
        this.motoristas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public void cadastrarMotorista() {
        try {
            System.out.println("Digite o nome do motorista:");
            String nome = scanner.nextLine();
            System.out.println("Digite o ID do motorista:");
            int id = scanner.nextInt();
            System.out.println("Digite a CNH do motorista:");
            int cnh = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite o nível de experiência [iniciante, intermediário, avançado]:");
            String nivelExperiencia = scanner.nextLine();

            Motorista motorista = new Motorista(nome, id, cnh, nivelExperiencia);

            for (Motorista m : motoristas) {
                if (m.getId() == motorista.getId()) {
                    System.out.println("Erro: Já existe um motorista com o ID " + motorista.getId());
                    return;
                }
            }

            motoristas.add(motorista);
            System.out.println("Motorista " + motorista.getNome() + " cadastrado!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpar a entrada inválida
        }
    }

    public void listarMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados!");
        } else {
            System.out.println("Motoristas: ");
            for (Motorista motorista : motoristas) {
                System.out.println(motorista);
            }
        }
    }

    public void interagirComUsuario() {
        while (true) {
            try {
                System.out.println("\n### MENU GERENCIAMENTO DE MOTORISTAS ###");
                System.out.println("1. Cadastrar motorista");
                System.out.println("2. Listar motoristas");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        cadastrarMotorista();
                        break;
                    case 2:
                        listarMotoristas();
                        break;
                    case 0:
                        System.out.println("Encerrando o menu de motoristas.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, escolha uma opção numérica.");
                scanner.nextLine(); // Limpar a entrada inválida
            }
        }
    }
}
