const files = [
  { name: "Nota do Sequestrador.txt", content: "Se você quer ver seu sobrinho vivo, siga as pistas..." },
  { name: "Foto suspeita.jpg", content: "[Imagem não disponível no protótipo]" },
  { name: "Registro de Acesso.log", content: "Usuário acessou a pasta secreta às 23:45." }
];

const fileListEl = document.getElementById("files");
const contentEl = document.getElementById("content");

let activeIndex = null;

function renderFileList() {
  fileListEl.innerHTML = "";
  files.forEach((file, index) => {
    const li = document.createElement("li");
    li.textContent = file.name;
    li.classList.toggle("active", index === activeIndex);
    li.addEventListener("click", () => {
      activeIndex = index;
      updateContent();
      renderFileList();
    });
    fileListEl.appendChild(li);
  });
}

function updateContent() {
  if (activeIndex !== null) {
    contentEl.textContent = files[activeIndex].content;
  } else {
    contentEl.textContent = "Clique em um arquivo para ver o conteúdo.";
  }
}

renderFileList();
updateContent();
