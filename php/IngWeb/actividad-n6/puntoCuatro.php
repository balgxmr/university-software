<?php
// Definimos las cuatro variables
$var1 = 10;
$var2 = 20;
$var3 = 30;
$var4 = 10;

/* 
 * Compararé las variables 1 y 2
*/

// Igual
if ($var1 == $var2) {
    echo "$var1 es igual a $var2 <br>";
} else {
    echo "$var1 no es igual a $var2 <br>";
}

// Menor que
if ($var1 < $var2) {
    echo "$var1 es menor que $var2 <br>";
} else {
    echo "$var1 no es menor que $var2 <br>";
}

// Mayor que
if ($var1 > $var2) {
    echo "$var1 es mayor que $var2 <br>";
} else {
    echo "$var1 no es mayor que $var2 <br>";
}

// Diferente de
if ($var1 != $var2) {
    echo "$var1 es diferente de $var2 <br>";
} else {
    echo "$var1 no es diferente de $var2 <br>";
}

// Menor o igual que
if ($var1 <= $var2) {
    echo "$var1 es menor o igual que $var2 <br>";
} else {
    echo "$var1 no es menor o igual que $var2 <br>";
}

// Mayor o igual que
if ($var1 >= $var2) {
    echo "$var1 es mayor o igual que $var2 <br>";
} else {
    echo "$var1 no es mayor o igual que $var2 <br>";
}

// Igual (true)
if ($var1 == $var4) {
  echo "$var1 es igual a $var4 <br>";
} else {
  echo "$var1 no es igual a $var4 <br>";
}
?>
