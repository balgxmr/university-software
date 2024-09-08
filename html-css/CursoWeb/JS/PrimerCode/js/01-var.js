// Variables
var producto = "Audifonos Gamers";
var disponible;

// En JS puede o no tener punto y coma, ambas maneras están OK.
//
// También, en JS no es necesario declarar el tipo de dato. Esto es debido
// a que JavaScript es un lenguaje de tipo dinámico. Además se va compilando
// en la ejecución.

producto = true;
disponible = true;

var producto1 = "Computadora",
  disponible1 = "true",
  categoria = "Computadoras";

// Las variables pueden tener numeros y ciertos caracteres, sin embargo estas
// variables NO pueden empezar con ellos.
// Ej INCORRECTO: var 1disponible
// Ej INCORRECTO: var -disponible *Aunque aquí el guión bajo SI es aceptado _disponible

// Estilos para variables
var nombre_producto = "Monitor HD"; // Underscore
var nombreProducto = "Monitor HD"; // Camelcase
var NombreProducto = "Monitor HD"; // Pascal Case
var nombreproducto = "Monitor HD"; // Pues lo normal/lower case

// Las variables SON case sensitive
// producto != PRODUCTO
console.log(producto);
