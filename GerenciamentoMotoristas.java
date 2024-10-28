import java.util.ArrayList;
import java.util.List;

public class GerenciamentoMotoristas {
    private List<Motorista> motoristas;

    public GerenciamentoMotoristas(){
        this.motoristas = new ArrayList<>();
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public void cadastrarMotorista(Motorista motorista){
        for (Motorista m : motoristas) {
            if (m.getId() == motorista.getId()) {
                System.out.println("Erro: Já existe um motorista com o ID " + motorista.getId());
                return;
            }
        }
        if (motorista == null){
            System.out.print("Motorista inexistente!");
        } else {
            motoristas.add(motorista);
            System.out.println("Motorista " + motorista.getNome() + " cadastrado!");
        }
    }

    public void listarMotoristas(){
        if (motoristas.isEmpty()){
            System.out.println("Não há motoristas cadastrados!");
        } else {
            System.out.println("Motoristas: ");
            for (Motorista motorista : motoristas) {
                System.out.println(motorista.toString());
            }
        }
    }

}
