// Tela login
document.getElementById("loginForm").addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;

  if (email && senha) {
    alert("Login realizado com sucesso!");

    const tipoConta = localStorage.getItem("tipoConta");

    if (tipoConta === "candidato") {
      window.location.href = "telaPrincipalCandidato.html";
    } else if (tipoConta === "empresa") {
      window.location.href = "telaPrincipalEmpresa.html";
    } else {
      alert("Tipo de conta não identificado.");
    }
  } else {
    alert("Por favor, preencha todos os campos.");
  }
});


  function irParaCriarConta() {
    window.location.href = "criarConta.html";
  }

  function voltarLogin() {
    window.location.href = "index.html";
  }

//Tela Criar Conta
  document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("cadastroForm");

  if (form) {
    form.addEventListener("submit", function (e) {
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

//tela Empresa
document.getElementById("formEmpresa").addEventListener("submit", function (e) {
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

    alert("Empresa cadastrada com sucesso!");
    window.location.href = "index.html";
  });


//telaCandidato
document.addEventListener("DOMContentLoaded", function () {
    const params = new URLSearchParams(window.location.search);
    const email = params.get("email");
  
    if (email) {
      document.getElementById("email").value = email;
    }
  
    const form = document.getElementById("formCandidato");
    form.addEventListener("submit", function (e) {
      e.preventDefault();
  
      const nome = document.getElementById("nome").value.trim();
      const cpf = document.getElementById("cpf").value.trim();
      const experiencia = document.getElementById("experiencia").value.trim();
      const curriculo = document.getElementById("curriculo").files[0];
  
      if (!nome || !cpf) {
        alert("Por favor, preencha todos os campos obrigatórios.");
        return;
      }

      alert("Candidato cadastrado com sucesso!");
      window.location.href = "index.html";
    });
  });
  




  
  