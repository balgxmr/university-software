<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #10</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>
<body>

  <h2>Factorial de un número</h2>

  <form action="" method="post">
    <input type="number" id="numeroInput" name="numeroInput" required>
    <input type="submit" value="Mostrar factorial">
  </form>

  <?php 
  /* 
    10.	Elabore un programa que permita calcular el factorial de un número ingresado por el usuario. 
    En términos matemáticos, un factorial es el producto de todos los números enteros positivos desde 1 hasta n
  */

  if($_SERVER['REQUEST_METHOD'] == "POST") {
    $numeroInput = $_POST["numeroInput"];

    $resultado = $numeroInput;
    for( $i = 1; $i < $numeroInput; $i++ ) {
      $resultado = $resultado*$i;
    }

    echo "<br>";

    echo "El factorial de $numeroInput es: $resultado";
  }

  ?>
</body>
</html>