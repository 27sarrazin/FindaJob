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
import br.com.senac.pifindajob.service.FormacaoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rosilane
 */

@SpringBootTest(classes = PIFindAJob.class)
@Transactional
public class FormacaoServiceTestJUnit {
    
    @Autowired
    private FormacaoService formacaoService;

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
    void deveBuscarCandidatosPorCurso() {
     
        Usuario usuario = new Usuario();
        usuario.setEmail("teste_formacao@exemplo.com");
        usuario.setSenha("123456");
        usuario.setTipo_usuario(2);
        usuarioRepository.save(usuario);

        Usuario usuarioSalvo = usuarioRepository.findById(usuario.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não salvo"));

        Candidato candidato = new Candidato();
        candidato.setNome("Candidato Formacao Teste");
        candidato.setCpf("123.456.789-00");
        candidato.setDescricaoCarreira("Desenvolvedor Teste");
        candidato.setUsuario(usuarioSalvo);

        FormacaoAcademica formacao = new FormacaoAcademica();
        formacao.setCurso("Engenharia");
        formacao.setCidade("Rio de Janeiro");
        formacao.setInstituicao("Universidade ABC");
        formacao.setId_Candidato(candidato);

        candidato.setFormacaoAcademica(formacao);

        candidatoRepository.save(candidato);

        List<Candidato> candidatos = formacaoService.buscarCandidatosPorCurso("Engenharia");

        assertFalse(candidatos.isEmpty());
        boolean achou = candidatos.stream()
                .anyMatch(c -> c.getCpf().equals("123.456.789-00") && c.getNome().equals("Candidato Formacao Teste"));
        assertTrue(achou);
    }
    @Autowired
    private EntityManager entityManager;
    @Test
    void naoDevePermitirCadastroComCpfDuplicado() {
        Usuario usuario1 = new Usuario(0, 2, "joao@email.com", "123");
        usuario1 = usuarioRepository.save(usuario1);

        Candidato candidato1 = new Candidato();
        candidato1.setNome("João Silva");
        candidato1.setCpf("111.222.333-44");
        candidato1.setDescricaoCarreira("Dev Java");
        candidato1.setUsuario(usuario1);

        FormacaoAcademica form1 = new FormacaoAcademica(0, "ADS", "FATEC", "São Paulo", candidato1);
        candidato1.setFormacaoAcademica(form1);

        candidato1 = candidatoRepository.save(candidato1);
        candidatoRepository.flush();

        Usuario usuario2 = new Usuario(0, 2, "maria@email.com", "456");
        usuario2 = usuarioRepository.save(usuario2);

        Candidato candidato2 = new Candidato();
        candidato2.setNome("Maria Souza");
        candidato2.setCpf("111.222.333-44");
        candidato2.setDescricaoCarreira("Dev Frontend");
        candidato2.setUsuario(usuario2);

        FormacaoAcademica form2 = new FormacaoAcademica(0, "SI", "UNIRIO", "Rio", candidato2);
        candidato2.setFormacaoAcademica(form2);

        try {
            candidatoRepository.save(candidato2);
            candidatoRepository.flush();
            fail("Esperava exceção por CPF duplicado");
        } catch (Exception e) {
            entityManager.clear();
        }
    }
}


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

