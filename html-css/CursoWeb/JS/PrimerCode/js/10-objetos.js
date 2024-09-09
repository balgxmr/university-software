// Objetos en JS

// const nombreProducto = "Monitor 20 Pulgadas";
// const precio = 300;
// const disponible = true;

const producto = {
  // Esto de abajo son las propiedades
  nombreProducto: "Monitor 20 Pulgadas",
  precio: 300,
  disponible: true
}

console.log(producto);
// console.log(producto.precio);
// console.log(producto.nombreProducto);
// console.log(producto.disponible);

// Tambien se puede usar: (aunque no es tan usado)
// console.log(producto["precio"]);

// AGREGAR PROPIEDADES
// También podemos declarar una propiedad a <producto> de esta forma:
producto.imagen = "imagen.jpg";
console.log(producto.imagen);

// ELIMINAR PROPIEDADES
// Podemos agregar directamente una propiedad con delete <objeto>.<propiedad>
delete producto.disponible;
console.log(producto);

