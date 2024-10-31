import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoViagens {
    private List<Viagem> viagens; // Lista para armazenar as viagens
    private GerenciamentoEletropostos gerenciamentoEletropostos; 
    private List<CarregamentoBateria> historicoCarregamentos;

    public GerenciamentoViagens(GerenciamentoEletropostos gerenciamentoEletropostos) {
        this.viagens = new ArrayList<>();
        this.historicoCarregamentos = new ArrayList<>();
        this.gerenciamentoEletropostos = gerenciamentoEletropostos; 
    }

    public void iniciarViagem(Motorista motorista, CarroEletrico carro, String destino, double kilometragem) {
        double autonomiaRestante = carro.getAutonomia();
        double distanciaPercorrida = 0;

        // Verificar se a autonomia é suficiente para a viagem
        if (autonomiaRestante >= kilometragem) {
            distanciaPercorrida = kilometragem; // Completar a viagem
            carro.setAutonomia(autonomiaRestante - distanciaPercorrida); // Atualiza a autonomia do carro
        } else {
            System.out.println("Autonomia insuficiente para a viagem. Será necessária uma recarga.");
            double energiaNecessaria = kilometragem - autonomiaRestante;

            // Encontrar um eletroposto disponível
            Eletroposto postoDisponivel = consultarEletropostosDisponiveis();
            if (postoDisponivel != null) {
                System.out.println("Parada no eletroposto " + postoDisponivel.getLocalizacao() + " para recarga.");

                // Calcular a energia que pode ser recuperada
                double energiaRecuperada = realizarRecarga(carro, postoDisponivel, energiaNecessaria);
                if (energiaRecuperada > 0) {
                    // Atualizar a autonomia do carro após a recarga
                    carro.setAutonomia(carro.getAutonomia() + energiaRecuperada);
                    distanciaPercorrida += autonomiaRestante; // Completa o que falta
                }
            } else {
                System.out.println("Nenhum eletroposto disponível. Não é possível completar a viagem.");
                return; // Não pode completar a viagem
            }
        }

        // Registrar a viagem
        Viagem novaViagem = new Viagem(motorista, carro, destino, distanciaPercorrida);
        viagens.add(novaViagem);
        System.out.println("Viagem registrada: " + novaViagem.toString());
    }

   // Método para realizar a recarga
    private double realizarRecarga(CarroEletrico carro, Eletroposto eletroposto, double energiaNecessaria) {
        // Calcular energia que pode ser recuperada
        double energiaRecuperada = Math.min(energiaNecessaria, carro.getCapacidadeBateria() - carro.getAutonomia());
        
        // Atualiza a autonomia do carro
        carro.setAutonomia(carro.getAutonomia() + energiaRecuperada); 
        eletroposto.ocuparVaga(); // Marca o eletroposto como ocupado

        // Criar e adicionar o registro de carregamento ao histórico
        CarregamentoBateria carregamentoBateria = new CarregamentoBateria(new Date(), eletroposto, energiaRecuperada, carro);
        historicoCarregamentos.add(carregamentoBateria);
        
        System.out.println("Recarga de " + energiaRecuperada + " kWh realizada.");
        return energiaRecuperada; // Retorna a energia recuperada
    }


}

