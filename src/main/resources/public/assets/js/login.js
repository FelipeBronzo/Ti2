function toggleForm() {
    const box = document.getElementById('box');
    const formEstudante = document.getElementById('form-box');
    const formInstituicao = document.getElementById('form-instituicao');

    // Alternar a visibilidade dos formulários
    if (formEstudante.style.display !== "none") {
        formEstudante.style.display = "none";
        formInstituicao.style.display = "block";
    } else {
        formEstudante.style.display = "block";
        formInstituicao.style.display = "none";
    }

    // Alternar a direção do flexbox para mover logo e formulário
    box.classList.toggle('reverse');
}
