document.addEventListener("DOMContentLoaded", function () {
  const idUsuario = sessionStorage.getItem("idUsuario");

  // Pré-preenche o campo de e-mail
  fetch(`http://localhost:8080/usuarios/${idUsuario}`)
    .then(response => response.json())
    .then(usuario => {
      document.getElementById("email").value = usuario.email;
    })
    .catch(error => {
      console.error("Erro ao buscar e-mail do usuário:", error);
      alert("Não foi possível carregar os dados do usuário.");
    });

  // Envia os dados do formulário
  document.getElementById("formCandidato").addEventListener("submit", function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const cpf = document.getElementById("cpf").value.trim();
    const descricaoCarreira = document.getElementById("experiencia").value.trim();
    

    const candidato = {
      nome: nome,
      cpf: cpf,
      descricaoCarreira: descricaoCarreira
      
      // ❌ NÃO envie id_usuario aqui
    };

    console.log("Candidato enviado:", candidato);

    fetch(`http://localhost:8080/candidato/${idUsuario}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(candidato)
    })
      .then(response => {
        if (!response.ok) {
          throw new Error("Erro ao cadastrar candidato");
        }
        return response.json();
      })
      .then(data => {
        alert("Candidato cadastrado com sucesso!");
        console.log("Resposta:", data);
        // Redirecionar ou limpar formulário, se desejar
        window.location.href =`/findJobFrontEnd/telaPrincipalCandidato.html`
      })
      .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao cadastrar candidato.");
      });
  });
});
