public class Viagem {
    private Motorista motorista;
    private CarroEletrico carro;
    private String destino;
    private double kilometragem;

    public Viagem(Motorista motorista, CarroEletrico carro, String destino, double kilometragem){
        this.motorista = motorista;
        this.carro = carro;
        this.destino = destino;
        this.kilometragem = kilometragem;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String toString(){
        return "Motorista: " + motorista.getNome() + " Kilometragem: " + kilometragem + " Veículo utilizado: " + carro.getModelo() + " Destino: " + destino + "\n";
    }
}
