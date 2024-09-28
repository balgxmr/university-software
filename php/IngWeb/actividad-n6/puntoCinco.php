<?php
// Definir constantes
define("SALUDO", "Hola, mi nombre es: ");
define("EDAD", "tengo años");

// Variables e impresión
$nombre = "José E.";
$edad = 21;

echo "<b>Constantes impresas individualmente: </b> <br>";

echo SALUDO . "<br>";
echo EDAD . "<br>";

echo "<br> <b>En una sola linea: </b> <br>";

// Concatenar todo el mensaje en una variable
$mensajeCompleto = SALUDO . $nombre . ". " . "Tengo " . $edad . " años.";
echo $mensajeCompleto;
?>