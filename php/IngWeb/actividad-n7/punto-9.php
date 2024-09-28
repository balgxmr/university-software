<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #9</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>
<body>

  <h2>Tabla de multiplicar</h2>

  <form action="" method="post">
    <input type="number" id="numeroInput" name="numeroInput" required>
    <input type="submit" value="Mostrar tabla">
  </form>

  <?php 
  /* 
    9.	Ingresar un numero y mostrar su tabla de multiplicar.
  */

  if($_SERVER['REQUEST_METHOD'] == "POST") {
    $numeroInput = $_POST["numeroInput"];

    for( $i = 0; $i <= 12; $i++ ) {
      $resultado = $numeroInput*$i;
      echo "$numeroInput * $i = $resultado <br>";
    }
  }

  ?>
</body>
</html>