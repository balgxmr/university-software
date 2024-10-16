// const a = [{ id: 1 }, { id: 2 }, { id: 3 }];
// console.log(a[0].id);

/*
 *
 *
 * Agregar elementos al final/inicio de un array con push
 *
 */

// Final - Push
const a = [1, 2, 3, 4, 5];
a.push("Hola");

// Inicio - Unshift
a.unshift("Adios");
console.log(a);

// ***EJERCICIO
const superHeroes = ["Superman", "Ironman", "Hawkeye"];
superHeroes.unshift("Hulk");
superHeroes.push("Capitan América");
console.log(superHeroes);

/*
 *
 *
 * Agregar elementos a través de un INPUT
 *
 */
const listaDeInvitados = document.querySelector("#invitados");
const invitadoInput = document.querySelector("#nuevoInvitado");
const btnAgregar = document.querySelector("#agregarInvitado");
const invitados = [];

btnAgregar.addEventListener("click", () => {
  /* Agregamos el invitado al arreglo */
  const nuevoInvitado = invitadoInput.value;
  invitados.push(nuevoInvitado);
  invitadoInput.value = "";

  /* Actualizamos la información en el HTML */
  let html = "";
  for (let invitado of invitados) {
    html += `<li>${invitado}</li>`;
  }
  listaDeInvitados.innerHTML = html;
});
