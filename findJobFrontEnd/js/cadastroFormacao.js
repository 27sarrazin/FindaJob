document.querySelector("form").addEventListener("submit", function (event) {
  event.preventDefault(); // impede recarregamento da página

  // Coleta os dados dos campos
  const curso = document.getElementById("curso").value.trim();
  const instituicao = document.getElementById("instituicao").value.trim();
  const cidade = document.getElementById("cidade").value.trim();

  // Aqui você deve pegar o ID do candidato (ex: sessionStorage ou variável global)
  const idCandidato = sessionStorage.getItem("idCandidato"); // <-- ajustar conforme sua lógica

  if (!idCandidato) {
    alert("ID do candidato não encontrado.");
    return;
  }

  const formacao = {
    curso: curso,
    instituicao: instituicao,
    cidade: cidade
  };

  fetch(`http://localhost:8080/formacao/${idCandidato}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formacao)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error("Erro ao salvar formação.");
    }
    return response.json();
  })
  .then(data => {
    alert("Formação cadastrada com sucesso!");
    console.log("Resposta:", data);
    // você pode limpar o formulário ou redirecionar
  })
  .catch(error => {
    console.error("Erro:", error);
    alert("Não foi possível cadastrar a formação.");
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const idUsuario = sessionStorage.getItem("idUsuario");

  if (!idUsuario) {
    alert("ID do usuário não encontrado.");
    return;
  }

  fetch(`http://localhost:8080/usuarios/${idUsuario}`)
    .then(response => {
      if (!response.ok) {
        throw new Error("Usuário não encontrado.");
      }
      return response.json();
    })
    .then(usuario => {
      // Preenche os campos no HTML
      console.log(usuario.id_usuario)
      document.getElementById("id_usuario").value = usuario.id_usuario;
      document.getElementById("usuario").value = usuario.email; // ou outro campo como nome, se existir
    })
    .catch(error => {
      console.error("Erro ao buscar usuário:", error);
      alert("Erro ao carregar os dados do usuário.");
    });
});
