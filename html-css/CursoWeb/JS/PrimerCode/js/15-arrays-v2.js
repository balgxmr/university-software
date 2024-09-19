// Más métodos de arrays en JS
const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo"];

// Array con objetos
const carrito = [
  { nombre: "Monitor 20 pulgadas", precio: 500 },
  { nombre: "Televisión 58 pulgadas", precio: 1500 },
  { nombre: "Tablet", precio: 300 },
  { nombre: "Audifonos", precio: 100 },
  { nombre: "Teclado", precio: 70 },
  { nombre: "Celular", precio: 900 },
  { nombre: "Bocinas", precio: 50 },
  { nombre: "Laptop", precio: 1700 },
];

// forEach
meses.forEach(function (mes) {
  if (mes == "Marzo") {
    console.log("Marzo si existe en meses");
  }
});

/*
 * Includes: Es util para un array plano
 *
 * Some: Es útil para array de objetos
 *
 * Reduce: Toma (en este caso) todos los números (precio) y te da el resultado (en este caso, la suma).
 *
 * Filter: Obtener un resultado específico
 *
 */

// Includes
let resultado = meses.includes("Marzo");

// Some
resultado = carrito.some(function (producto) {
  return producto.nombre == "Celular";
});

// Reduce
resultado = carrito.reduce(function (total, producto) {
  return total + producto.precio;
}, 0); // donde 0 es el valor inicial

// Filter
resultado = carrito.filter(function (producto) {
  return producto.precio > 400;
});

console.log(resultado);
