document.getElementById("cadastroForm").addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const confirmarSenha = document.getElementById("confirmarSenha").value;
  const tipoUsuarioSelecionado = document.querySelector("input[name='tipoConta']:checked").value;
    
  let tipo_usuario = tipoUsuarioSelecionado === "emprego" ? 2 : 1;
  if (senha !== confirmarSenha) {
    alert("As senhas não coincidem.");
    return;
  }

  const usuario = {
    email: email,
    senha: senha,
    tipo_usuario: tipo_usuario
  };

  console.log("Dados enviados:", JSON.stringify(usuario));

  fetch("http://localhost:8080/usuarios", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(usuario)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error("Erro ao criar usuário");
    }
    return response.json();
  })
  .then(data => {
    alert("Usuário criado com sucesso!");
    console.log("Resposta do servidor:", data);
    window.location.href = "/findJobFrontEnd/index.html";
  })
  .catch(error => {
    console.error("Erro:", error);
    alert("Erro ao criar conta. Tente novamente.");
  });
});
