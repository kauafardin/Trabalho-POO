import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoViagens {
    private List<Viagem> viagens;
    private GerenciamentoEletropostos gerenciamentoEletropostos; // Atributo para gerenciar os eletropostos

    // Construtor que aceita uma instância de GerenciamentoEletropostos
    public GerenciamentoViagens(GerenciamentoEletropostos gerenciamentoEletropostos) {
        this.viagens = new ArrayList<>();
        this.gerenciamentoEletropostos = gerenciamentoEletropostos; // Associar o gerenciamento de eletropostos
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public void iniciarViagem(Motorista motorista, CarroEletrico carro, String destino, double kilometragem) {
        double autonomiaRestante = carro.getAutonomia();
        double distanciaPercorrida = 0;

        // Verificar se a autonomia é suficiente para a viagem
        if (autonomiaRestante >= kilometragem) {
            System.out.println("Viagem iniciada sem paradas para recarregar!");
            distanciaPercorrida = kilometragem; // Completar a viagem sem parar
        } else {
            // Planejar paradas em eletropostos ao longo da viagem
            System.out.println("Planejando paradas para recarga...");
            
            while (distanciaPercorrida < kilometragem) {
                // Verificar se a autonomia é suficiente para continuar
                if (autonomiaRestante < (kilometragem - distanciaPercorrida)) {
                    // Encontrar um eletroposto disponível
                    Eletroposto postoDisponivel = encontrarEletropostoDisponivel();
                    if (postoDisponivel != null) {
                        System.out.println("Parada no eletroposto " + postoDisponivel.getLocalizacao() + " para recarga.");
                        
                        // Realizar a recarga apenas se a bateria não estiver cheia
                        if (carro.getAutonomia() < carro.getCapacidadeBateria()) {
                            double energiaRecuperada = realizarRecarga(carro, postoDisponivel);
                            autonomiaRestante += energiaRecuperada; // Atualizar a autonomia após a recarga
                        } else {
                            System.out.println("A bateria do carro já está cheia. Nenhuma recarga necessária.");
                        }

                        // Aumentar a distância percorrida pela autonomia disponível após a recarga
                        distanciaPercorrida += autonomiaRestante; 
                        
                        // Ocupar vaga no posto
                        postoDisponivel.ocuparVaga();
                    } else {
                        System.out.println("Nenhum eletroposto disponível. Recalculando a rota...");
                        // Aqui você pode implementar a lógica para recalcular a rota.
                        return;
                    }
                } else {
                    // Se a autonomia for suficiente, completar a viagem
                    distanciaPercorrida = kilometragem;
                }
            }
            System.out.println("Viagem completada com paradas.");
        }

        // Atualizar a autonomia do carro após a viagem
        carro.setAutonomia(autonomiaRestante - distanciaPercorrida);
        // Registrar a viagem
        Viagem novaViagem = new Viagem(motorista, carro, destino, distanciaPercorrida);
        viagens.add(novaViagem);
        System.out.println("Viagem registrada!");
    }

    // Método para encontrar um eletroposto com vagas disponíveis
    private Eletroposto encontrarEletropostoDisponivel() {
        for (Eletroposto posto : gerenciamentoEletropostos.getEletropostos()) {
            if (posto.getvagasCarregamento() > 0) {
                return posto;
            }
        }
        return null; // Nenhum eletroposto disponível
    }

    // Método para realizar a recarga
    public double realizarRecarga(CarroEletrico carro, Eletroposto eletroposto) {
        // Calcular a quantidade de energia que pode ser recuperada
        double energiaRecuperada = carro.getCapacidadeBateria() - carro.getAutonomia(); // Valor de exemplo em kWh

        if (energiaRecuperada > 0) {
            // Criar um registro de carregamento
            CarregamentoBateria carregamento = new CarregamentoBateria(LocalDateTime.now(), eletroposto, energiaRecuperada);
            carro.getHistoricoCarregamentos().add(carregamento); // Registrar no histórico do carro

            // Atualiza a autonomia do carro
            carro.setAutonomia(Math.min(carro.getCapacidadeBateria(), carro.getAutonomia() + energiaRecuperada)); // Atualiza a autonomia após a recarga

            System.out.println("Recarga de " + energiaRecuperada + " kWh registrada no eletroposto " + eletroposto.getLocalizacao());
        } else {
            System.out.println("A bateria do carro já está cheia. Nenhuma recarga necessária.");
        }

        return energiaRecuperada; // Retornar a energia recuperada
    }
}
