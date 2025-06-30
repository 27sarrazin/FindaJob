document.getElementById("loginForm").addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;

  const loginData = {
    email: email,
    senha: senha
  };

  console.log("Enviando login:", JSON.stringify(loginData));
  fetch("http://localhost:8080/usuarios/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(loginData)
  })
    .then(response => {
      if (!response.ok) {
        throw new Error("Email ou senha inválidos");
      }
      return response.json();
    })
    .then(usuario => {
      alert("Login realizado com sucesso!");

      // Redirecionamento baseado no tipo do usuário
      if (usuario.tipo_usuario === 1) {
        // Tipo 1: Empresa
        window.location.href = "/findJobFrontEnd/cadastroEmpresa.html";
      } else if (usuario.tipo_usuario === 2) {
        // Tipo 2: Candidato
        window.location.href = "/findJobFrontEnd/cadastroCandidato.html";
      } else {
        alert("Tipo de usuário não reconhecido.");
      }
    })
    .catch(error => {
      console.error("Erro no login:", error);
      alert("Email ou senha inválidos.");
    });
});

// Botão "Criar Conta"
function irParaCriarConta() {
  window.location.href = "/findJobFrontEnd/criar-conta.html";
}
