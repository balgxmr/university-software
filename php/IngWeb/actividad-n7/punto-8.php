<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #8</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>
<body>
  
  <h2>Suma de números posteriores</h2>
  <p>Se mostrará la suma de los 10 siguientes números al que ingrese</p>

  <form action="" method="post">
    <input type="number" id="numeroInput" name="numeroInput" required>
    <input type="submit" value="Mostrar suma">
  </form>

  <?php 
  /* 
    8.	Realice una sentencia repetitiva que pida al usuario en un formulario un número y muestre la suma de los siguientes 10 números posteriores.
  */
  
  if($_SERVER["REQUEST_METHOD"] == "POST") {
    $numeroInput = $_POST["numeroInput"];

    $suma = 0;
    for($i = $numeroInput + 1; $i <= $numeroInput + 10; $i++) {
      $suma = $suma + $i;
    }

    echo "<h3>Suma: $suma</h3>";
  }
  
  ?>
</body>
</html>