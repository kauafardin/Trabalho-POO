import java.util.List;
 
public class Relatorio {
    private List<CarroEletrico> veiculos;
    private List<Viagem> viagens;

    public void autonomiaInferior(){
        if (veiculos.isEmpty()){
            System.out.println("Não há veículos na frota!");
        } else {
            for (CarroEletrico carro : veiculos){
                if ((carro.getAutonomia()/carro.getCapacidadeBateria())*100 < 20 ){
                    System.out.println(carro.toString());
                }
            }
        }
    }

    public void viagensMotoristas(String nomeMotorista){
        if (viagens.isEmpty()){
            System.out.println("Não há motoristas cadastrados!");
        } else {
            for (Viagem viagem : viagens){
                if (viagem.getMotorista().getNome().equals(nomeMotorista)){
                    System.out.println(viagem.toString());
                    System.out.println();
                }
            }
        }
    }
}
