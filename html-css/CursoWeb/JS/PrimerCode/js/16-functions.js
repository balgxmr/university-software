// Funciones en JS

// Declaración
function sumar() {
  console.log(10 + 10);
}

// Expresión de la función
const sumar2 = function () {
  console.log(1 + 3);
};

// Llamada
sumar();
sumar2();

// IIFE
(function () {
  console.log("Esto es una función");
})(); /* <- Se llama al final, con () */

/*
 *
 * IIFE:  (No necesitan llamada, previenen que las variables NO se puedan llamar de otros archivos, es para protegerlos, EJ: Si tuviera <cliente = 'Juan'> dentro del IIFE, otro archivo NO podría acceder a esta variable)
 *
 */
