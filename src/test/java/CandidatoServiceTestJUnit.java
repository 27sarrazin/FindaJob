/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import br.com.senac.pifindajob.PIFindAJob;
import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.repository.CandidatoRepository;
import br.com.senac.pifindajob.repository.UsuarioRepository;
import br.com.senac.pifindajob.service.CandidatoService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rosilane
 */

@SpringBootTest(classes = PIFindAJob.class)
@Transactional
public class CandidatoServiceTestJUnit {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @AfterEach
    void limparDados() {
        candidatoRepository.deleteAll();
        usuarioRepository.deleteAll();
    }

    @Test
    void deveSalvarCandidatoComSucesso() {
 
        Usuario usuario = new Usuario();
        usuario.setEmail("teste_integ@exemplo.com");
        usuario.setSenha("123456");
        usuario.setTipo_usuario(2);
        usuarioRepository.save(usuario);

        Usuario usuarioSalvo = usuarioRepository.findById(usuario.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não salvo corretamente"));

        Candidato candidato = new Candidato();
        candidato.setNome("Candidato Teste");
        candidato.setCpf("321.654.987-00");
        candidato.setDescricaoCarreira("Analista de Sistemas");
        candidato.setUsuario(usuarioSalvo);

        FormacaoAcademica formacao = new FormacaoAcademica();
        formacao.setCurso("Sistemas de Informação");
        formacao.setCidade("Rio de Janeiro");
        formacao.setInstituicao("Universidade ABC");

        formacao.setId_Candidato(candidato);

        candidato.setFormacaoAcademica(formacao);

        Candidato salvo = candidatoService.salvar(candidato);

        assertNotNull(salvo.getIdCandidato());
        assertEquals("Candidato Teste", salvo.getNome());
        assertEquals("321.654.987-00", salvo.getCpf());
        assertEquals("Analista de Sistemas", salvo.getDescricaoCarreira());
        assertNotNull(salvo.getFormacaoAcademica());
        assertEquals("Sistemas de Informação", salvo.getFormacaoAcademica().getCurso());
    }
}
