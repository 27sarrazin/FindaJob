package br.com.senac.pifindajob.classes;

public class Endereco implements mostrarInformacoes{
    private int id_endereco;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Candidato id_candidato;
    private Empresa id_empresa;

    public Endereco(int id_endereco, String cep, String rua, String numero, String bairro, String cidade, String estado, Candidato id_candidato, Empresa id_empresa) {
        this.id_endereco = id_endereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.id_candidato = id_candidato;
        this.id_empresa = id_empresa;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Candidato getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Candidato id_candidato) {
        this.id_candidato = id_candidato;
    }

    public Empresa getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Empresa id_empresa) {
        this.id_empresa = id_empresa;
    }
    
     @Override
     public void exibirInformacoes(){
        System.out.println("CEP: " + this.getCep());
        System.out.println("Rua: " + this.getRua());
        System.out.println("Numero: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        
    }
}
