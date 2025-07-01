package br.com.senac.pifindajob.controller;

import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rosilane
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }
    
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario dadosLogin) {
         System.out.println("Tentando login com: " + dadosLogin.getEmail() + " | " + dadosLogin.getSenha());
    return service.autenticar(dadosLogin.getEmail(), dadosLogin.getSenha())
        .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
}

    
}
