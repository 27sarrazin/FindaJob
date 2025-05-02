// Simples validação do formulário
document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault();
  
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
  
    if (email && senha) {
      alert("Login realizado com sucesso!");
      // redirecionar para tela principal (exemplo)
      // window.location.href = "principal-candidato.html";
    } else {
      alert("Por favor, preencha todos os campos.");
    }
  });
  
  function irParaCriarConta() {
    // redireciona para a tela de criação de conta
    window.location.href = "criar-conta.html";
  }



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
        window.location.href = "cadastro-candidato.html";
      } else if (tipoConta.value === "funcionario") {
        window.location.href = "cadastro-empresa.html";
      }
    });
  }
});

  
  