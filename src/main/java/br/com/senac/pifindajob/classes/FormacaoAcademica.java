/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Rosilane
 */
@Entity
@Table(name = "formacao_academica")
public class FormacaoAcademica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formacao")
    private int idFormacao;
    @Column(nullable = false)
    private String curso;
    @Column(nullable = false)
    private String instituicao;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    @JsonBackReference
    private Candidato id_Candidato;

  
    public FormacaoAcademica() {
    }
    
   
    public FormacaoAcademica(int idFormacao, String curso, String instituicao, String cidade, Candidato id_Candidato) {
        this.idFormacao = idFormacao;
        this.curso = curso;
        this.instituicao = instituicao;
        this.cidade = cidade;
        this.id_Candidato = id_Candidato;
    }
    
    public int getIdFormacao() {
        return idFormacao;
    }

    public void setIdFormacao(int idFormacao) {
        this.idFormacao = idFormacao;
    }
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public Candidato getId_Candidato() {
        return id_Candidato;
    }

    public void setId_Candidato(Candidato id_Candidato) {
        this.id_Candidato = id_Candidato;
    }


   
}
