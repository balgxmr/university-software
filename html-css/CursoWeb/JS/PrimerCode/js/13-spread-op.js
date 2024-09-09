// Unir dos objetos con el Spread Operator

const producto = {
  nombre: "Monitor 20 Pulgadas",
  precio: 300,
  disponible: true
};

const medidas = {
  peso: '1kg',
  medida: '1m'
};

// Unimos los dos objetos mediante:
const nuevoProducto = { ...producto, medidas };
// const <nombreObj> = { ...objeto1, obj2 .. objN };

console.log(producto);
console.log(nuevoProducto);
