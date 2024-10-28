import java.util.ArrayList;
import java.util.List;

public class CarroEletrico{
    protected int id;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected double capacidadeBateria;
    protected double autonomiaMax;
    private List<CarregamentoBateria> historicoCarregamentos;

    public CarroEletrico(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomiaMax) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeBateria = capacidadeBateria;
        this.autonomiaMax = autonomiaMax;
        this.historicoCarregamentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(double capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public double getAutonomia() {
        return autonomiaMax;
    }

    public void setAutonomia(double autonomiaMax) {
        this.autonomiaMax = autonomiaMax;
    }


    public List<CarregamentoBateria> getHistoricoCarregamentos() {
        return historicoCarregamentos;
    }

    public void setHistoricoCarregamentos(List<CarregamentoBateria> historicoCarregamentos) {
        this.historicoCarregamentos = historicoCarregamentos;
    }

    @Override
    public String toString() {
        return " ID: " + id + "\n Marca: " + marca + "\n Modelo: " + modelo + "\n Ano: " + anoFabricacao
                + "\n Capacidade: " + capacidadeBateria + " kWh\n Autonomia: " + autonomiaMax + " km";
    }

}