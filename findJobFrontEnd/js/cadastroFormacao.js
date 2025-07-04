document.addEventListener("DOMContentLoaded", function () {
  // Parte 1: preencher dados do candidato
  console.log("Raw idCandidato do sessionStorage:", sessionStorage.getItem("idCandidato"));
const idCandidato = parseInt(sessionStorage.getItem("idCandidato"));
console.log("Parsed idCandidato:", idCandidato);


  if (!idCandidato) {
    alert("ID do candidato não encontrado.");
    return;
  }

  fetch(`http://localhost:8080/candidato/${idCandidato}`)
    .then(response => {
      if (!response.ok) {
        throw new Error("Candidato não encontrado.");
      }
      return response.json();
    })
    .then(candidato => {
      console.log("Candidato retornado:", candidato);
      document.getElementById("idCandidato").value = idCandidato;
      document.getElementById("candidato").value = candidato.nome;
    })
    .catch(error => {
      console.error("Erro ao buscar candidato:", error);
      alert("Erro ao carregar os dados do candidato.");
    });

  // Parte 2: submissão do formulário
  document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault();

    const curso = document.getElementById("curso").value.trim();
    const instituicao = document.getElementById("instituicao").value.trim();
    const cidade = document.getElementById("cidade").value.trim();

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
        console.error("Erro ao cadastrar formação:", error);
        alert("Não foi possível cadastrar a formação.");
      });
  });
});
