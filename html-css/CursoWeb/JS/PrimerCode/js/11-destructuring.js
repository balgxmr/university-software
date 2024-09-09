// Objetos
const producto = {
  nombre: "Monitor 20 Pulgadas",
  precio: 300,
  disponible: true
}

// Forma anterior
const precioProducto = producto.precio;
const nombreProducto = producto.nombre;
console.log(precioProducto);
console.log(nombreProducto);

// Destructuring (sacar de una estructura, pues)
// Esto de abajo, crea la variable precio y le asigna producto.precio
// Lo mismo que se ve en la linea #7. 
// 
// Eso sí, tiene que tener el MISMO nombre, es  decir si 
// tenemos precio como propiedad, la variable será precio.
// EJ: const {precioProducto} = producto; **INCORRECTO!!
const {precio} = producto;
const {nombre} = producto;
//
// **Aunque también lo de arriba es equivalente a:
// const {precio, nombre} = producto; es decir todo en una sola linea.
console.log(precio);
console.log(nombre);
