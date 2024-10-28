import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFrota {
    private List<CarroEletrico> veiculos;

    public GerenciamentoFrota(){
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculos(CarroEletrico carro){
        for (CarroEletrico veiculo : veiculos) {
            if (veiculo.getId() == carro.getId()) {
                System.out.println("Erro: Já existe um veículo com o ID " + carro.getId());
                return;
            }
        }
        if (carro == null){
            System.out.println("Veículo inexistente!");
        } else{
            veiculos.add(carro);
            System.out.println("Veículo " + carro.getModelo() + " adicionado á frota!");
        }
    }

    public void removerVeiculos(CarroEletrico carro){
        if (carro == null){
            System.out.println("Veículo inexistente!");
        } else{
            veiculos.remove(carro);
            System.out.println("Veículo " + carro.getModelo() + " retirado da frota!");
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
    
}
