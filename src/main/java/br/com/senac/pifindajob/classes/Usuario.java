package br.com.senac.pifindajob.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;
    private int tipo_usuario;
    private String email;
    private String senha;

    
    public Usuario() {
    }

    public Usuario(int id_usuario, int tipo_usuario, String email, String senha) {
        this.id_usuario = id_usuario;
        this.tipo_usuario = tipo_usuario;
        this.email = email;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
    
        this.tipo_usuario = tipo_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", tipo_usuario=" + tipo_usuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

   
   
}
