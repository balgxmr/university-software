const btnValidar = document.querySelector("#btnValidar");

btnValidar.addEventListener("click", function () {
  const cajita = document.querySelector("#clave");
  // como es por getElementByID ya JS sabe que es ID, no necesita "#"
  const resultadoParrafo = document.getElementById("secret-result");
  const claveValida = "g81";

  if (cajita.value === claveValida) {
    // alert("La clave es correcta");
    resultadoParrafo.innerHTML = "La clave es correcta";
  }
});
