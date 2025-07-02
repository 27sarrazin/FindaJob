document.querySelector("form").addEventListener("submit", function (event) {
  event.preventDefault();


  const curso = document.getElementById("curso").value.trim();
  const instituicao = document.getElementById("instituicao").value.trim();
  const cidade = document.getElementById("cidade").value.trim();

  const idCandidato = sessionStorage.getItem("idUsuario");
  
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
      console.log(usuario.id_usuario)
      document.getElementById("id_usuario").value = usuario.id_usuario;
      document.getElementById("usuario").value = usuario.email; 
    })
    .catch(error => {
      console.error("Erro ao buscar usuário:", error);
      alert("Erro ao carregar os dados do usuário.");
    });
});
