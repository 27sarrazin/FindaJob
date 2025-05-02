//Tela login
document.addEventListener("DOMContentLoaded", function () {
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
        } else {
          alert("Tipo de conta não identificado.");
        }
      } else {
        alert("Email ou senha incorretos.");
      }
    });
  }
});

//Tela Criar conta
document.addEventListener("DOMContentLoaded", function () {
  const cadastroForm = document.getElementById("cadastroForm");

  if (cadastroForm) {
    cadastroForm.addEventListener("submit", function (e) {
      e.preventDefault();

      const email = document.getElementById("email").value;
      const senha = document.getElementById("senha").value;
      const confirmarSenha = document.getElementById("confirmarSenha").value;
      const tipoConta = document.querySelector('input[name="tipoConta"]:checked');

      if (!email || !senha || !confirmarSenha || !tipoConta) {
        alert("Por favor, preencha todos os campos.");
        return;
      }

      if (senha !== confirmarSenha) {
        alert("As senhas não coincidem.");
        return;
      }

      localStorage.setItem("email", email);
      localStorage.setItem("senha", senha);

      if (tipoConta.value === "emprego") {
        localStorage.setItem("tipoConta", "candidato");
        window.location.href = `cadastroCandidato.html?email=${encodeURIComponent(email)}`;
      } else if (tipoConta.value === "funcionario") {
        localStorage.setItem("tipoConta", "empresa");
        window.location.href = `cadastroEmpresa.html?email=${encodeURIComponent(email)}`;
      }
    });
  }
});

//tela Cadastro candidato
document.addEventListener("DOMContentLoaded", function () {
  const params = new URLSearchParams(window.location.search);
  const email = params.get("email");
  const formCandidato = document.getElementById("formCandidato");

  if (email) {
    const emailInput = document.getElementById("email");
    if (emailInput) emailInput.value = email;
  }

  if (formCandidato) {
    formCandidato.addEventListener("submit", function (e) {
      e.preventDefault();

      const nome = document.getElementById("nome").value.trim();
      const cpf = document.getElementById("cpf").value.trim();

      if (!nome || !cpf) {
        alert("Por favor, preencha todos os campos obrigatórios.");
        return;
      }

      alert("Cadastro de candidato finalizado com sucesso!");
      window.location.href = "index.html";
    });
  }
});

//Tela cadastro empresa
document.addEventListener("DOMContentLoaded", function () {
  const formEmpresa = document.getElementById("formEmpresa");

  if (formEmpresa) {
    formEmpresa.addEventListener("submit", function (e) {
      e.preventDefault();

      const nome = document.getElementById("nomeEmpresa").value.trim();
      const cnpj = document.getElementById("cnpjEmpresa").value.trim();
      const contato = document.getElementById("contatoEmpresa").value.trim();
      const email = document.getElementById("emailEmpresa").value.trim();
      const senha = document.getElementById("senhaEmpresa").value.trim();

      if (!nome || !cnpj || !contato || !email || !senha) {
        alert("Por favor, preencha todos os campos corretamente.");
        return;
      }

      localStorage.setItem("email", email);
      localStorage.setItem("senha", senha);
      localStorage.setItem("tipoConta", "empresa");

      alert("Empresa cadastrada com sucesso!");
      window.location.href = "index.html";
    });
  }
});


function irParaCriarConta() {
  window.location.href = "criarConta.html";
}

function voltarLogin() {
  window.location.href = "index.html";
}

  




  
  