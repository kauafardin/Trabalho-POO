public class Motorista {
    private String nome;
    private int id;
    private int cnh;
    private String nivelExperiencia;
    
    public Motorista(String nome, int id, int cnh, String nivelExperiencia) {
        this.nome = nome;
        this.id = id;
        this.cnh = cnh;
        this.nivelExperiencia = nivelExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    @Override
    public String toString(){
        return " Nome: " + nome + "\n ID: " + id + "\n CNH: " + cnh + "\n Nível de Experiência: " + nivelExperiencia;
    }
    
}