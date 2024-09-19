// Funciones que retornan valores

function sumar(n1, n2) {
  return n1 + n2;
}

const resultado = sumar(10, 20);
console.log(resultado);

// Ejemplo más detallado, carrito de compras
console.log("---EJEMPLO CARRITO---");
let total = 0;

function agregarCarrito(precio) {
  return (total += precio);
}

function calcularImpuesto(total) {
  return total * 0.07 + total;
}

total = agregarCarrito(200);
console.log(total);
total = agregarCarrito(600);
console.log(total);

const pagoTotal = calcularImpuesto(total);
console.log(`El total a pagar con impuestos es de: $${pagoTotal}`);
