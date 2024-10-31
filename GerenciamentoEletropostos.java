import java.util.ArrayList;
import java.util.List;

public class GerenciamentoEletropostos {
    private List<Eletroposto> eletropostos;

    public GerenciamentoEletropostos(){
        this.eletropostos = new ArrayList<>();
    }

    public List<Eletroposto> getEletropostos() {
        return eletropostos;
    }

    public void setEletropostos(List<Eletroposto> eletropostos) {
        this.eletropostos = eletropostos;
    }

    public void registrarEletroposto(Eletroposto eletroposto){
        for (Eletroposto e : eletropostos) {
            if (e.getId() == eletroposto.getId()) {
                System.out.println("Erro: Já existe um veículo com o ID " + eletroposto.getId());
                return;
            }
        }
        if (eletroposto == null){
            System.out.println("Eletroposto inexistente!");
        } else{
            eletropostos.add(eletroposto);
            System.out.println("Eletroposto " + eletroposto.getId() + " registrado!");
        }
    }

    public void consultarEletropostosDisponiveis(String localizacao){
        boolean encontrado = false;
        if (eletropostos.isEmpty()){
            System.out.println("Não há eletropostos registrados!");
        } else {
            for (Eletroposto eletroposto : eletropostos){
                if (eletroposto.getLocalizacao().equals(localizacao)){
                    System.out.println("Eletropostos Disponível: \n" + eletroposto.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum eletroposto encontrado no local " + localizacao + ".");
            }
        }
    }

}
