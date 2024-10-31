import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoFrota {

    // Atributos da classe GerenciamentoFrota
    private List<CarroEletrico> veiculos;
    private List<Motorista> motoristas;
    private List<Eletroposto> eletropostos;
    private List<Viagem> viagens;
    private List<CarregamentoBateria> historicoCarregamentos;
    private Scanner scanner;

    // Construtor da classe
    public GerenciamentoFrota() {
        this.veiculos = new ArrayList<>();
        this.motoristas = new ArrayList<>();
        this.eletropostos = new ArrayList<>();
        this.historicoCarregamentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Métodos para gerenciar veículos
    public void adicionarVeiculos(CarroEletrico carro) {
        for (CarroEletrico veiculo : veiculos) {
            if (veiculo.getId() == carro.getId()) {
                System.out.println("Erro: Já existe um veículo com o ID " + carro.getId());
                return;
            }
        }
        veiculos.add(carro);
        System.out.println("Veículo " + carro.getModelo() + " adicionado à frota!");
    }

    public void removerVeiculos(int id) {
        CarroEletrico carroRemover = null;
        for (CarroEletrico carro : veiculos) {
            if (carro.getId() == id) {
                carroRemover = carro;
                break;
            }
        }
        if (carroRemover != null) {
            veiculos.remove(carroRemover);
            System.out.println("Veículo " + carroRemover.getModelo() + " retirado da frota!");
        } else {
            System.out.println("Erro: Carro não encontrado na frota.");
        }
    }

    public void listarFrota() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos na frota!");
        } else {
            System.out.println("Veículos: ");
            for (CarroEletrico carro : veiculos) {
                System.out.println(carro.toString());
            }
        }
    }

    // Métodos para gerenciar motoristas
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

    // Métodos para gerenciar eletropostos
    public void registrarEletroposto() {
        try {
            System.out.println("Digite o ID do eletroposto:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite a localização do eletroposto:");
            String localizacao = scanner.nextLine();
            System.out.println("Quantas vagas:");
            int vagasCarregamento = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("Digite o tempo de carregamento:");
            double TMCarregamento = scanner.nextDouble();

            Eletroposto eletroposto = new Eletroposto(id, localizacao, vagasCarregamento, TMCarregamento);
            for (Eletroposto e : eletropostos) {
                if (e.getId() == eletroposto.getId()) {
                    System.out.println("Erro: Já existe um eletroposto com o ID " + eletroposto.getId());
                    return;
                }
            }

            eletropostos.add(eletroposto);
            System.out.println("Eletroposto " + eletroposto.getId() + " registrado!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpar a entrada inválida
        }
    }

    public void consultarEletropostosDisponiveis() {
        System.out.println("Digite a localização para consultar eletropostos:");
        String localizacao = scanner.nextLine();
        boolean encontrado = false;
        if (eletropostos.isEmpty()) {
            System.out.println("Não há eletropostos registrados!");
        } else {
            for (Eletroposto eletroposto : eletropostos) {
                if (eletroposto.getLocalizacao().equals(localizacao)) {
                    System.out.println("Eletropostos Disponíveis: \n" + eletroposto.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum eletroposto encontrado no local " + localizacao + ".");
            }
        }
    }

    // Método para interação do usuário
    public void interagirComUsuario() {
        while (true) {
            try {
                System.out.println("\n### MENU DO SISTEMA DE GESTÃO ###");
                System.out.println("1 - Gerenciar Frota");
                System.out.println("2 - Gerenciar Motoristas");
                System.out.println("3 - Gerenciar Eletropostos");
                System.out.println("4 - Iniciar Viagem");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        gerenciarFrota();
                        break;
                    case 2:
                        gerenciarMotoristas();
                        break;
                    case 3:
                        gerenciarEletropostos();
                        break;
                    case 4:
                        iniciarViagem();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
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

    // Métodos para gerenciar a frota
    private void gerenciarFrota() {
        while (true) {
            try {
                System.out.println("\n### MENU GERENCIAMENTO DE FROTA ###");
                System.out.println("1 - Adicionar Veículo");
                System.out.println("2 - Remover Veículo");
                System.out.println("3 - Listar Veículos");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
    
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
    
                switch (opcao) {
                    case 1:
                        System.out.println("Digite os detalhes do veículo: ");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Ano de Fabricação: ");
                        int anoFabricacao = scanner.nextInt();
                        System.out.print("Capacidade da Bateria (kWh): ");
                        double capacidadeBateria = scanner.nextDouble();
    
                        // Escolha do tipo de carro e definição da autonomia
                        System.out.println("Escolha o tipo de carro: ");
                        System.out.println("1 - Compacto (Autonomia: 200 km)");
                        System.out.println("2 - Sedan (Autonomia: 400 km)");
                        System.out.println("3 - SUV (Autonomia: 500 km)");
    
                        int tipoCarro = scanner.nextInt();
                        double autonomiaMax;
    
                        switch (tipoCarro) {
                            case 1:
                                autonomiaMax = 200;
                                break;
                            case 2:
                                autonomiaMax = 400;
                                break;
                            case 3:
                                autonomiaMax = 500;
                                break;
                            default:
                                System.out.println("Tipo de carro inválido. Usando autonomia padrão de 200 km.");
                                autonomiaMax = 200;
                                break;
                        }
    
                        CarroEletrico novoCarro = new CarroEletrico(id, marca, modelo, anoFabricacao, capacidadeBateria, autonomiaMax);
                        adicionarVeiculos(novoCarro); // Correção: adicionando o carro com ponto e vírgula
                        break;
                    case 2:
                        System.out.print("Digite o ID do veículo a ser removido: ");
                        int idRemover = scanner.nextInt();
                        removerVeiculos(idRemover);
                        break;
                    case 3:
                        listarFrota();
                        break;
                    case 0:
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

    // Métodos para gerenciar motoristas
    private void gerenciarMotoristas() {
        while (true) {
            System.out.println("\n### MENU GERENCIAMENTO DE MOTORISTAS ###");
            System.out.println("1 - Cadastrar Motorista");
            System.out.println("2 - Listar Motoristas");
            System.out.println("0 - Voltar");
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
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos para gerenciar eletropostos
    private void gerenciarEletropostos() {
        while (true) {
            System.out.println("\n### MENU GERENCIAMENTO DE ELETROPOSTOS ###");
            System.out.println("1 - Registrar Eletroposto");
            System.out.println("2 - Consultar Eletropostos Disponíveis");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    registrarEletroposto();
                    break;
                case 2:
                    consultarEletropostosDisponiveis();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void iniciarViagem() {
        try {
            System.out.print("Digite o ID do motorista: ");
            int idMotorista = scanner.nextInt();
            Motorista motorista = null;
            for (Motorista m : motoristas) {
                if (m.getId() == idMotorista) {
                    motorista = m;
                    break;
                }
            }
    
            if (motorista == null) {
                System.out.println("Erro: Motorista não encontrado.");
                return;
            }
    
            System.out.print("Digite o ID do veículo: ");
            int idVeiculo = scanner.nextInt();
            CarroEletrico carro = null;
            for (CarroEletrico c : veiculos) {
                if (c.getId() == idVeiculo) {
                    carro = c;
                    break;
                }
            }
    
            if (carro == null) {
                System.out.println("Erro: Veículo não encontrado.");
                return;
            }
            System.out.print("Digite o destino: ");
            String destino = scanner.nextLine();
            System.out.print("Digite a distância da viagem (em km): ");
            double distancia = scanner.nextDouble();
    
            // Verificar se a distância excede a autonomia do veículo
            if (distancia > carro.getAutonomia()) {
                System.out.println("A distância excede a autonomia do veículo!");
                // Calcular a quantidade de recargas necessárias
                double distanciaRestante = distancia;
                int recargasNecessarias = 0;
    
                while (distanciaRestante > carro.getAutonomia()) {
                    distanciaRestante -= carro.getAutonomia();
                    recargasNecessarias++;
                }
    
                // Mostrar a quantidade de recargas necessárias
                System.out.println("Você precisará de " + recargasNecessarias + " recarga(s) para completar a viagem.");
    
                // Escolher os eletropostos disponíveis
                System.out.println("Eletropostos disponíveis:");
                for (Eletroposto e : eletropostos) {
                    System.out.println("ID: " + e.getId() + ", Localização: " + e.getLocalizacao());
                }
    
                // Recarregar no eletroposto
                for (int i = 0; i < recargasNecessarias; i++) {
                    System.out.print("Escolha o ID do eletroposto para recarga " + (i + 1) + ": ");
                    int idEletroposto = scanner.nextInt();
                    Eletroposto eletropostoEscolhido = null;
                    for (Eletroposto e : eletropostos) {
                        if (e.getId() == idEletroposto) {
                            eletropostoEscolhido = e;
                            break;
                        }
                    }
    
                    if (eletropostoEscolhido != null) {
                        eletropostoEscolhido.recarregar(carro);
                    } else {
                        System.out.println("Eletroposto não encontrado. Viagem cancelada.");
                        return;
                    }
                }
            }
    
            // Se a distância for menor ou igual à autonomia do veículo
            carro.setAutonomia(carro.getAutonomia() - distancia);
            System.out.println("Viagem iniciada com sucesso pelo motorista " + motorista.getNome() + " no veículo " + carro.getModelo() + ". Distância: " + distancia + " km.");
            Viagem novaViagem = new Viagem(motorista, carro, destino, distancia);
            viagens.add(novaViagem);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite valores corretos.");
            scanner.nextLine(); // Limpar a entrada inválida
        }
    }
    

}
