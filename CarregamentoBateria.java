import java.util.Date;

public class CarregamentoBateria {
    private Date data;
    private Eletroposto eletroposto;
    private double energiaRecarregada;
    private CarroEletrico carro;

    public CarregamentoBateria(Date data, Eletroposto eletroposto, double energiaRecarregada, CarroEletrico carro) {
        this.data = data;
        this.eletroposto = eletroposto;
        this.energiaRecarregada = energiaRecarregada;
        this.carro = carro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Eletroposto getEletroposto() {
        return eletroposto;
    }

    public void setEletroposto(Eletroposto eletroposto) {
        this.eletroposto = eletroposto;
    }

    public double getEnergiaRecarregada() {
        return energiaRecarregada;
    }

    public void setEnergiaRecarregada(double energiaRecarregada) {
        this.energiaRecarregada = energiaRecarregada;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "CarregamentoBateria{" +
                "data=" + data +
                ", eletroposto=" + eletroposto.getLocalizacao() +
                ", energiaRecuperada=" + energiaRecarregada + " kWh" +
                ", carro=" + carro.getModelo() + 
                '}';
    }
}
