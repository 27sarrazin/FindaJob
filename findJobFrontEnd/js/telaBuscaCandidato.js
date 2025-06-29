document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("formBusca");
  if (!form) {
    console.error("Elemento com id 'formBusca' não encontrado.");
    return;
  }

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const curso = document.getElementById("campoBusca").value;

    fetch(`http://localhost:8080/empresa/buscar-candidatos/${curso}`)
      .then(response => {
        if (!response.ok) throw new Error("Erro ao buscar candidatos");
        return response.json();
      })
      .then(candidatos => {
        const tabela = document.getElementById("tabelaResultados");
        tabela.innerHTML = "";
        candidatos.forEach(c => {
          tabela.innerHTML += `
            <tr>
              <td>${c.nome}</td>
              <td>${c.formacaoAcademica?.curso ?? ''}</td>
              <td>${c.formacaoAcademica?.instituicao ?? ''}</td>
              <td>${c.formacaoAcademica?.cidade ?? ''}</td>
            </tr>`;
        });
      })
      .catch(error => {
        console.error("Erro:", error);
      });
  });
});
