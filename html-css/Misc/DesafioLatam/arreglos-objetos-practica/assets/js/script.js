/*
 *
 *
 * Arreglos e impresión
 *
 */
const nombres = ["Jose", "Juan", "Jonathan", "Jahir", "Jeniffer", "Jimena"];
// console.log(nombres[2]);

/*
 *
 *
 * Ciclos y arreglos
 *
 * */
const categorias = ["Tecnologia", "Oficina", "Musica", "Otros"];
// donde categoria es la variable que conttendrá el elemento en cada iteración
// y categorias es el arreglo a ser iterado
for (let categoria of categorias) {
  console.log(categoria);
}

const lenguajes = ["Javascript", "Java", "PHP", "Ruby", "Python", "Go"];
for (lenguaje of lenguajes) {
  console.log(lenguaje);
}

/*
 *
 *
 * Interpolación vs Concatenación
 *
 */
const nombre = "Jose";
const fecha = "2024-10-15";

const interpolacion = `Hola, mi nombre es ${nombre}, hoy ${fecha} quiero emitir una solicitud`;
const concatenacion = "Hola mi nombre es " + nombre + " , hoy " + fecha + " quiero emitir una solicitud";

console.log(interpolacion);
console.log(concatenacion);

/*
 *
 *
 * Agregar contenido dinámicamente
 *
 */

const escalaMayorDeDo = ["Do", "Re", "Mi", "Fa", "Sol", "La", "Si"];
const d2 = document.querySelector("#notas-musicales");
for (let nota of escalaMayorDeDo) {
  d2.innerHTML += `<li> ${nota} </li>`;
}

// const data = ["Javier", "Camila", "Fransisco", "Nicole", "Daniela"];
// const d = document.querySelector("#dynamic-content");
// for (let item of data) {
//   d.innerHTML += `<li> ${item} </li>`;
// }

// !!!!!!!!!! Respecto a lo hecho arriba:
// ● Tenemos que tener cuidado con esta línea, cada vez que modificamos con .innerHTML
// se fuerza la modificación del DOM.
// ● Es mejor modificarlo una sola vez, en lugar de las múltiples iteraciones que tenga el
// ciclo.
// Por ello...
// Por cada uno de los datos del arreglo los agregamos a un string. Luego utilizamos ese string para actualizar el DOM una única vez. Para evitar renderizar el DOM ("d") múltiples veces.
let data = ["Javier", "Camila", "Fransisco", "Nicole", "Daniela"];
let html = "";
let d = document.querySelector("#dynamic-content");
for (let item of data) {
  html += `<li> ${item} </li>`;
}
d.innerHTML = html;

/*
 *
 *
 * Objetos
 *
 */
let auto = {
  marca: "Nissan",
  modelo: "z370",
  año: 2015,
  kilometraje: 160000,
};

// Existen dos maneras de acceder a los datos de un objeto
// > Usando punto
console.log(auto.marca);
// > Usando corchetes
console.log(auto["marca"]);

let neymar = {
  edad: 32,
  altura: 1.75, // m
  peso: 68, // kg
  salario: 100000000, // EUR
  club: "Al-Hilal FC",
};

html = "";
let d3 = document.querySelector("#neymar-status");
for (let status in neymar) {
  html += `<li> ${status}: ${neymar[status]} </li>`;
}
d3.innerHTML = html;

/*
 *
 *
 * Creación de templates con datos de un objeto
 *
 */
const articulo = {
  id: 31,
  titulo: "Autos nuevos en Chile",
  subtitulo: "El mercado de autos se normaliza",
  descripcion: "No es novedad que los precios de los autos usados se han disparado debido a la falta en stock de autos nuevos, sin embargo puede que esto esté llegando a su fin…",
};

const articulosSection = document.querySelector(".articulos");
// Este string suele llamarse template o plantilla, puesto que es una base para escribir
// un texto o un HTML de mayor complejidad
articulosSection.innerHTML = `
  <article class="articulo">
    <h4>${articulo.titulo}</h4>
    <h6>${articulo.subtitulo}</h6>
    <p>${articulo.descripcion}</p>
    <a href="/articulo/${articulo.id}"><button>Ver más</button></a>
  </article>
`;

// EJERCICIO - creacion de producto ecommerce
const producto = {
  id: 43,
  titulo: "Cafetera magnética",
  precio: 23990,
  color: "rojo",
  src: "...", // ingresa aquí la URL de la imagen,
  descripcion: `Calienta tu café matutino
con la nueva tecnología magnética`,
};

const ecommerce = document.querySelector(".ecommerce");
ecommerce.innerHTML = `
  <div class="card">
    <h3>${producto.titulo} de color ${producto.color}</h3>
    <p><i>AQUI VA LA IMAGEN JSDHASJ</i></p>
    <p><b>Descripción: </b> ${producto.descripcion}</p>
    <p>${producto.precio}$</p>
  </div>
`;

/*
 *
 *
 * Arreglo de Objetos
 *
 */
const items = [
  {
    id: 1,
    nombre: "Producto #1",
    precio: "100",
  },
  {
    id: 2,
    nombre: "Producto #2",
    precio: "500",
  },
  {
    id: 3,
    nombre: "Producto #3",
    precio: "125",
  },
  {
    id: 4,
    nombre: "Producto #4",
    precio: "1000",
  },
  {
    id: 5,
    nombre: "Producto #5",
    precio: "1500",
  },
];

html = "";
const ele = document.querySelector("#productos");
for (let item of items) {
  // console.log(item);
  html += `
  <div id="${item.id}" class="producto">
    <h2>${item.nombre}</h2>
    <p>${item.precio}</p>
  </div>
  `;
}
ele.innerHTML = html;
