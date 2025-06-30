document.addEventListener('DOMContentLoaded', function () {
  // Detecta a página atual pelo pathname
  const pagina = window.location.pathname;

  // Página de login
  if (pagina.includes("index.html")) {
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
      loginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const emailDigitado = document.getElementById("email").value;
        const senhaDigitada = document.getElementById("senha").value;
        const emailSalvo = localStorage.getItem("email");
        const senhaSalva = localStorage.getItem("senha");
        const tipoConta = localStorage.getItem("tipoConta");

        if (emailDigitado === emailSalvo && senhaDigitada === senhaSalva) {
          alert("Login realizado com sucesso!");
          if (tipoConta === "candidato") {
            window.location.href = "telaPrincipalCandidato.html";
          } else if (tipoConta === "empresa") {
            window.location.href = "telaPrincipalEmpresa.html";
          }
        } else {
          alert("Email ou senha incorretos.");
        }
      });
    }
  }

  document.getElementById("btn-criarConta").addEventListener("click",function(){
      window.location.href =`/findJobFrontEnd/criarConta.html` ;
  })

  /*
  // Página criarConta.html
  
  if (pagina.includes("criarConta.html")) {
    const cadastroForm = document.getElementById("cadastroForm");
    if (cadastroForm) {
      cadastroForm.addEventListener("submit", function (e) {
        e.preventDefault();

        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;
        const confirmarSenha = document.getElementById("confirmarSenha").value;
        const tipoConta = document.querySelector('input[name="tipoConta"]:checked');

        if (!email || !senha || !confirmarSenha || !tipoConta) {
          alert("Preencha todos os campos.");
          return;
        }

        if (senha !== confirmarSenha) {
          alert("Senhas não coincidem.");
          return;
        }

        localStorage.setItem("email", email);
        localStorage.setItem("senha", senha);

        if (tipoConta.value === "emprego") {
          localStorage.setItem("tipoConta", "candidato");
          window.location.href =`../cadastroCandidato.html` ;
          //`../cadastroCandidato.html/cadastroCandidato.html?email=${encodeURIComponent(email)}`
        } else {
          localStorage.setItem("tipoConta", "empresa");
          window.location.href = `cadastroEmpresa.html?email=${encodeURIComponent(email)}`;
        }
      });
    }
  }*/

  // Página cadastroCandidato.html
  if (pagina.includes("cadastroCandidato.html")) {
    const form = document.getElementById("formCandidato");
    const params = new URLSearchParams(window.location.search);
    const email = params.get("email");

    if (email) {
      const input = document.getElementById("email");
      if (input) input.value = email;
    }

    if (form) {
      form.addEventListener("submit", function (e) {
        e.preventDefault();

        const nome = document.getElementById("nome").value.trim();
        const cpf = document.getElementById("cpf").value.trim();
        const cpfPattern = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;

        if (!nome || !cpf) {
          alert("Preencha todos os campos.");
          return;
        }

        if (!cpfPattern.test(cpf)) {
          alert("CPF inválido.");
          return;
        }

        alert("Cadastro finalizado com sucesso!");
        window.location.href = "index.html";
      });
    }
  }

  // Página cadastroEmpresa.html
  if (pagina.includes("cadastroEmpresa.html")) {
    const form = document.getElementById("formEmpresa");
    if (form) {
      form.addEventListener("submit", function (e) {
        e.preventDefault();

        const nome = document.getElementById("nomeEmpresa").value.trim();
        const cnpj = document.getElementById("cnpjEmpresa").value.trim();
        const contato = document.getElementById("contatoEmpresa").value.trim();
        const email = document.getElementById("emailEmpresa").value.trim();
        const senha = document.getElementById("senhaEmpresa").value.trim();

        if (!nome || !cnpj || !contato || !email || !senha) {
          alert("Preencha todos os campos.");
          return;
        }

        localStorage.setItem("email", email);
        localStorage.setItem("senha", senha);
        localStorage.setItem("tipoConta", "empresa");

        alert("Cadastro da empresa realizado!");
        window.location.href = "index.html";
      });
    }
  }

  // Página TelaFormacaoAcademica.html
  if (pagina.includes("TelaFormacaoAcademica.html")) {
    const inputNome = document.getElementById("nome");
    const inputCurso = document.getElementById("curso");
    const inputInstituicao = document.getElementById("instituicao");
    const inputCidade = document.getElementById("cidade");

    const dadosSalvos = JSON.parse(localStorage.getItem("formacaoCandidato"));
    if (dadosSalvos) {
      inputNome.value = dadosSalvos.nome || "";
      inputCurso.value = dadosSalvos.curso || "";
      inputInstituicao.value = dadosSalvos.instituicao || "";
      inputCidade.value = dadosSalvos.cidade || "";
    }

    const btnSalvar = document.querySelector('button[type="submit"]');
    if (btnSalvar) {
      btnSalvar.addEventListener("click", function (e) {
        e.preventDefault();

        const nome = inputNome.value.trim();
        const curso = inputCurso.value.trim();
        const instituicao = inputInstituicao.value.trim();
        const cidade = inputCidade.value.trim();

        if (nome && curso && instituicao && cidade) {
          const formacao = { nome, curso, instituicao, cidade };
          localStorage.setItem("formacaoCandidato", JSON.stringify(formacao));
          alert("Formação salva!");
        } else {
          alert("Preencha todos os campos.");
        }
      });
    }

    const btnAtualizar = document.querySelector(".btn-warning");
    if (btnAtualizar) {
      btnAtualizar.addEventListener("click", function () {
        const nome = inputNome.value.trim();
        const curso = inputCurso.value.trim();
        const instituicao = inputInstituicao.value.trim();
        const cidade = inputCidade.value.trim();

        if (nome && curso && instituicao && cidade) {
          const formacao = { nome, curso, instituicao, cidade };
          localStorage.setItem("formacaoCandidato", JSON.stringify(formacao));
          alert("Formação atualizada!");
        } else {
          alert("Preencha tudo antes de atualizar.");
        }
      });
    }
  }
});
