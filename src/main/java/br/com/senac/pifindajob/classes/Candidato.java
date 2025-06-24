package br.com.senac.pifindajob.classes;

import jakarta.persistence.*;



@Entity
@Table(name="tb_candidato")
public class Candidato implements mostrarInformacoes{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private int idCandidato;
    @Column(nullable = false)
    private String nome;
    
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(nullable = false)
    private String descricaoCarreira;
    
    @OneToOne(mappedBy = "id_Candidato", cascade = CascadeType.ALL)
    private FormacaoAcademica formacaoAcademica;

    public Candidato() {
        
    }

    public Candidato(int idCandidato, String nome, Usuario id_usuario, String cpf, String descricaoCarreira, FormacaoAcademica formacaoAcademica) {
        this.idCandidato = idCandidato;
        this.nome = nome;
        this.id_usuario = id_usuario;
        this.cpf = cpf;
        this.descricaoCarreira = descricaoCarreira;
        this.formacaoAcademica = formacaoAcademica;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricaoCarreira() {
        return descricaoCarreira;
    }

    public void setDescricaoCarreira(String descricaoCarreira) {
        this.descricaoCarreira = descricaoCarreira;
    }
    
    public FormacaoAcademica getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }
    

   
    

    @Override
    public void exibirInformacoes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
