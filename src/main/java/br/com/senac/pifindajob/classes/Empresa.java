package br.com.senac.pifindajob.classes;

import jakarta.persistence.*;


@Entity
@Table(name = "Empresa")
public class Empresa implements mostrarInformacoes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
   private int idEmpresa;
     
     @Column(nullable = false)
   private String nome;
     @Column(nullable = false, unique = true)
    private String cnpj;
     @Column(nullable = false)
    private String contato;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String nome, String cnpj, String contato, Usuario id_usuario) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.id_usuario = id_usuario;
    }
    
    

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
   
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    

    @Override
    public void exibirInformacoes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
}
