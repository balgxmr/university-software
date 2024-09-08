// Variables con const
const producto = "Audifonos Gamers";
const disponible; // ERROR! Uncaught SyntaxError: Missing initializer in const declaration

// Con const NO se pueden inicializar variables sin ningun valor. Siempre tienen que tener valor.
// Además el valor NO se puede reasignar. Vamos, lo mismo que en otros lenguajes.
// Se puede inicializar con let, y más adelante cambiarlo a const, no hay problema.

producto = true;
disponible = true;

let producto1 = "Computadora",
  disponible1 = "true",
  categoria = "Computadoras";

// Las variables pueden tener numeros y ciertos caracteres, sin embargo estas
// variables NO pueden empezar con ellos.
// Ej INCORRECTO: var 1disponible
// Ej INCORRECTO: var -disponible *Aunque aquí el guión bajo SI es aceptado _disponible

// Estilos para variables
let nombre_producto = "Monitor HD"; // Underscore
let nombreProducto = "Monitor HD"; // Camelcase
let NombreProducto = "Monitor HD"; // Pascal Case
let nombreproducto = "Monitor HD"; // Pues lo normal/lower case

// Las variables SON case sensitive
// producto != PRODUCTO
console.log(producto);
