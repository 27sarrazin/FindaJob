package br.com.senac.pifindajob.classes;

import java.time.LocalDate;

public class Curriculo implements mostrarInformacoes{
    private int id_curriculo;
    private String nome_arquivo;
    private String tipo_arquivo;
    private LocalDate data_envio;
    private Candidato id_candidato;

    public Curriculo(int id_curriculo, String nome_arquivo, String tipo_arquivo, LocalDate data_envio, Candidato id_candidato) {
        this.id_curriculo = id_curriculo;
        this.nome_arquivo = nome_arquivo;
        this.tipo_arquivo = tipo_arquivo;
        this.data_envio = data_envio;
        this.id_candidato = id_candidato;
    }

    public int getId_curriculo() {
        return id_curriculo;
    }

    public void setId_curriculo(int id_curriculo) {
        this.id_curriculo = id_curriculo;
    }

    public String getNome_arquivo() {
        return nome_arquivo;
    }

    public void setNome_arquivo(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }

    public String getTipo_arquivo() {
        return tipo_arquivo;
    }

    public void setTipo_arquivo(String tipo_arquivo) {
        this.tipo_arquivo = tipo_arquivo;
    }

    public LocalDate getData_envio() {
        return data_envio;
    }

    public void setData_envio(LocalDate data_envio) {
        this.data_envio = data_envio;
    }

    public Candidato getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Candidato id_candidato) {
        this.id_candidato = id_candidato;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.println("Nome Arquivo: " + this.getNome_arquivo());
        System.out.println("Tipo Arquivo: " + this.getTipo_arquivo());
        System.out.println("Data Envio: " + this.getData_envio());
    }
}
