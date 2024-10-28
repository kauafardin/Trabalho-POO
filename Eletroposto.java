public class Eletroposto {
    private int id;
    private String localizacao;
    private int vagasCarregamento;
    private double TMCarregamento;

    public Eletroposto(int id, String localizacao, int vagasCarregamento, double TMCarregamento){
        this.id = id;
        this.localizacao = localizacao;
        this.vagasCarregamento = vagasCarregamento;
        this.TMCarregamento = TMCarregamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getvagasCarregamento() {
        return vagasCarregamento;
    }

    public void setvagasCarregamento(int vagasCarregamento) {
        this.vagasCarregamento = vagasCarregamento;
    }

    public double getTMCarregamento() {
        return TMCarregamento;
    }

    public void setTMCarregamento(double tMCarregamento) {
        TMCarregamento = tMCarregamento;
    }

    @Override
    public String toString() {
        return " ID: " + id + "\n Local: " + localizacao + "\n Vagas disponíveis: " + vagasCarregamento +
               "\n Tempo médio de carregamento: " + TMCarregamento + " horas";
    }

    public void ocuparVaga() {
        if (vagasCarregamento > 0) {
            vagasCarregamento--;
        }
    }

    public void liberarVaga() {
        vagasCarregamento++;
    }

}
