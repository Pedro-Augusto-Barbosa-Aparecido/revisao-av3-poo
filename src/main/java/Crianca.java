public class Crianca {
    private String nome;
    private String nacionalidade;
    private int idade;
    private String presenteDesejado;

    public Crianca(String nome, String nacionalidade, int idade, String presenteDesejado) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.presenteDesejado = presenteDesejado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPresenteDesejado() {
        return presenteDesejado;
    }

    public void setPresenteDesejado(String presenteDesejado) {
        this.presenteDesejado = presenteDesejado;
    }
}
