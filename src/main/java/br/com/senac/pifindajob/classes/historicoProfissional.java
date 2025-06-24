package br.com.senac.pifindajob.classes;

public class historicoProfissional implements mostrarInformacoes {
    private int id_historico;
    private String cargo_funcao;
    private String responsabilidade;
    private Candidato id_candidato;

    public historicoProfissional(int id_historico, String cargo_funcao, String responsabilidade, Candidato id_candidato) {
        this.id_historico = id_historico;
        this.cargo_funcao = cargo_funcao;
        this.responsabilidade = responsabilidade;
        this.id_candidato = id_candidato;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public String getCargo_funcao() {
        return cargo_funcao;
    }

    public void setCargo_funcao(String cargo_funcao) {
        this.cargo_funcao = cargo_funcao;
    }

    public String getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public Candidato getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Candidato id_candidato) {
        this.id_candidato = id_candidato;
    }
    
     @Override
     public void exibirInformacoes(){
        System.out.println("Cargo/Funcao: " + this.getCargo_funcao());
        System.out.println("Responsabilidade: " + this.getResponsabilidade());
    }
}
