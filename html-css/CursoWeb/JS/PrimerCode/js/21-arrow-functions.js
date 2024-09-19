// Este es el function original:
/*
  const sumar = function (n1, n2) {
    console.log(n1 + n2);
  };
*/

// Arrow functions o funciones de flecha
const sumar = (n1, n2) => console.log(n1 + n2); // Cuando es una linea las {}, son opcionales
sumar(3, 3);

const aprendiendo = (tecnologia) => {
  console.log(`Aprendiendo ${tecnologia}`);
};

aprendiendo("JavaScript");

// El return NO es necesario

/*
 *
 *
 *  AGREGADO DEL 15
 *
 */

const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo"];
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
let resultado;

// forEach
meses.forEach((mes) => {
  if (mes === "Marzo") {
    console.log("Marzo si existe en meses");
  }
});

// El return NO es necesario

// Some
resultado = carrito.some((producto) => producto.nombre === "Celular");

// Reduce
resultado = carrito.reduce((total, producto) => total + producto.precio, 0);

// Filter
resultado = carrito.filter((producto) => producto.precio > 400);

console.log(resultado);
