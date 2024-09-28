<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #6</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>
<body>
    <h2>Contar Múltiplos de 3 o 5 en un Rango de Valores</h2>

    <form action="" method="post">
        <label for="tope_inferior">Tope Inferior:</label>
        <input type="number" name="tope_inferior" id="tope_inferior" required><br><br>

        <label for="tope_superior">Tope Superior:</label>
        <input type="number" name="tope_superior" id="tope_superior" required><br><br>

        <input type="submit" value="Contar Múltiplos">
    </form>

    <?php

    /* 
      6.	Elabore un programa que permita determinar la cantidad de números múltiplos de 3 o de 5 comprendidos entre un rango de valores indicado por el usuario, para ello el usuario debe ingresar los topes inferior y superior del rango de valores.
    */

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $tope_inferior = $_POST["tope_inferior"];
        $tope_superior = $_POST["tope_superior"];

        // Función para contar los múltiplos de 3 o 5 en el rango
        function contarMultiplos($tope_inferior, $tope_superior) {
            $contador = 0;
            for ($i = $tope_inferior; $i <= $tope_superior; $i++) {
                if ($i % 3 == 0 || $i % 5 == 0) {
                    $contador++;
                }
            }
            return $contador;
        }

        // Entrada: 1 - 10, respuesta: 5.. correcto

        // Llamar a la función y mostrar el resultado
        $cantidad_multiplos = contarMultiplos($tope_inferior, $tope_superior);
        echo "<h3>La cantidad de múltiplos de 3 o 5 entre $tope_inferior y $tope_superior es: $cantidad_multiplos</h3>";
    }
    ?>
</body>
</html>