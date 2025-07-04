document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.getElementById("loginForm");

  if (loginForm) {
    loginForm.addEventListener("submit", function (event) {
      event.preventDefault();

      const email = document.getElementById("email").value;
      const senha = document.getElementById("senha").value;

      const loginData = {
        email: email,
        senha: senha
      };

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
          const idUsuario = usuario.id_usuario;
          sessionStorage.setItem("idUsuario", idUsuario);

          if (usuario.tipo_usuario === 1) {
            // Tipo empresa
            window.location.href = "/findJobFrontEnd/telaPrincipalEmpresa.html";
          } else if (usuario.tipo_usuario === 2) {
            // Tipo candidato
            fetch(`http://localhost:8080/candidato/existePorUsuario/${idUsuario}`)
              .then(res => res.json())
              .then(existe => {
                if (existe === true) {
                  // Candidato já cadastrado
                  window.location.href = "/findJobFrontEnd/telaPrincipalCandidato.html";
                } else {
                  // Candidato ainda não cadastrado
                  window.location.href = "/findJobFrontEnd/cadastroCandidato.html";
                }
              })
              .catch(err => {
                console.error("Erro ao verificar cadastro do candidato:", err);
                alert("Erro ao verificar cadastro do candidato.");
              });
          } else {
            alert("Tipo de usuário não reconhecido.");
          }
        })
        .catch(error => {
          console.error("Erro no login:", error);
          alert("Email ou senha inválidos.");
        });
    });
  }

  document.getElementById("btn-criarConta").addEventListener("click",function(){
    window.location.href="/findJobFrontEnd/criarConta.html"
  })

});
