const nombrePersonas = ["Juandry", "Robert", "Nestor", "Leonardo", "Pepe", "Juan"];

// Eliminar a Pepe
// nombrePersonas.splice(4, 1);

// Ahora... para eliminar a Pepe sin saber inicialmente la posición de Pepe
// Con findIndex buscamos la posición del elemento que quiero borrar
// findIndex((persona) => persona === "Pepe")) esto busca dentro de nombrePersonas, a la persona que tenga el nombre === "Pepe" y returna el index una vez encontrado.
const posicion = nombrePersonas.findIndex((persona) => persona === "Pepe");
nombrePersonas.splice(posicion, 1);

function actualizarListaAsistentes() {
  let html = "";
  for (const persona of nombrePersonas) {
    html += `<li>${persona}</li>`;
  }

  document.querySelector("#super_heroes").innerHTML = html;
}

const agregarPersona = function (event) {
  event.preventDefault();
  const nuevaPersona = document.querySelector("#nuevo_sh");

  // Agrega valor del input correctamente
  nombrePersonas.push(nuevaPersona.value);
  actualizarListaAsistentes();
  // Limpia el input después de agregar name
  nuevaPersona.value = "";
};

// Ejercicio borrar el num 43
const tallasDisponibles = [41, 42, 43, 44, 45];
tallasDisponibles.splice(
  tallasDisponibles.findIndex((talla) => talla === 43),
  1
);
console.log(tallasDisponibles);
