// Funciones con parámetros y argumentos

// Número1, numero2 son parámetros
// function sumar(numero1, numero2) {
function sumar(numero1 = 0, numero2 = 0) {
  console.log(numero1 + numero2);
}
// Argumentos
sumar(10, 100);
sumar(110, 20);
sumar(102, 490);
sumar(100);

// Número1, numero2 son parámetros
const sumar2 = function (n1, n2) {
  console.log(n1 + n2);
};
// Argumentos
sumar2(14, 2);
sumar2(18, 0);
sumar2(-10, 11);
