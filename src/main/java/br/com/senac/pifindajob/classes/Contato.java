package br.com.senac.pifindajob.classes;

public class Contato implements mostrarInformacoes {
    private int id_contato;
    private String celular;
    private String telefone;
    private Candidato id_candidato;
    private Empresa id_empresa;

    public Contato(int id_contato, String celular, String telefone, Candidato id_candidato, Empresa id_empresa) {
        this.id_contato = id_contato;
        this.celular = celular;
        this.telefone = telefone;
        this.id_candidato = id_candidato;
        this.id_empresa = id_empresa;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        System.out.println("Celular: " + this.getCelular());
        System.out.println("Telefone: " + this.getTelefone());
    }
}
