// Arrays en JS

const numeros = [10, 20, 30, 40, 50];
// console.log(numeros);
console.table(numeros);

// Tambien se pueden crear con constructor
// Aunque es menos utilizada
const meses = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');
console.table(meses);

// Se pueden mezclar todo tipo de datos
// String, bool, null, objetos, objetos e incluso arreglos
const arreglo = ["Hola", 10, true, null, {nombre: "Jose", trabajo: "programador"}, [1,2,3]]
console.table(arreglo);

// Para acceder al indice (index) de un arreglo:
console.log(arreglo[2]);

// Conocer la extensión/longitud de un arreglo
console.log(meses.length);

// Recorre cada index del arreglo y lo manda a numero
// forEach es como el for de JavaScript
numeros.forEach ( function(numero) {
  console.log(numero)
})

//
// ** Para agregar un elemento a un arreglo, en una posición no-existente se puede usar:
// ** AUNQUE no es un método que se utilice mucho.
//
numeros[5] = 60;
// Sin embargo, si asignamos un valor a una posición que ya contenga un valor
// este valor de dicha posición será reemplazada.
numeros[1] = 100;
console.table(numeros);


/* 
 *
 *
 * MÉTODOS PARA LOS ARRAYS
 *
 */

//
// ** Para agregar
// ** Lo que se utiliza más es el método <push> o <unshift> pero, aún así poco a poco
//    se va dejando de usar.
// 
numeros.push(69, 14, 111); // Al final del arreglo
console.table(numeros);
numeros.unshift(-10, 2734, -2); // Al inicio del arreglo
console.table(numeros);

//
// Eliminar del arreglo
//
meses.pop(); // Elimina el último elemento
meses.shift(); // Elimina el primer elemento 

//
// Eliminar en específico del arreglo
//
meses.splice(2, 1); // En donde (2) el segundo valor representa el
                    // indice, y el (1) segundo valor que tanto queremos borrar
                    // a partir del indice. En este caso solo borramos 1 espacio.


// PERO! No es tan recomendado modificar directamente el arreglo
// original. En cambio, podemos hacer lo siguiente
const nuevoArreglo = [...meses, 'Junio']; // (...meses) copia el arreglo meses; y se está agregando 'Junio'
// const nuevoArreglo = ['Junio', ...meses]; // Al tener 'Junio' al inicio, se agrega al inicio.
console.log(nuevoArreglo);
