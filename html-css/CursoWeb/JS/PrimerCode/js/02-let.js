// Variables CON let
let producto = "Audifonos Gamers";
let disponible;

// Siguen las mismas reglas/declaraciones que con "var"
// No hay diferencia en la estructura/creación
// En donde hay diferencia es con const

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
