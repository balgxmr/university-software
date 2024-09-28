<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #5</title>
</head>
<body>
    <h2>Calcular tu Índice de Masa Corporal (IMC)</h2>

    <form action="" method="post">
        <label for="peso">Peso (kg):</label>
        <input type="number" name="peso" id="peso" step="0.1" required><br><br>

        <label for="altura">Altura (m):</label>
        <input type="number" name="altura" id="altura" step="0.01" required><br><br>

        <input type="submit" value="Calcular IMC">
    </form>

    <?php

    /* 
      5.	Elabore un programa que determine el índice de masa corporal (IMC) de una persona de acuerdo a los rangos:
      Por debajo <18.5
      Saludable 18.5 - 24.9
      Sobrepeso 25-29.9
      Obesidad >30
      ****IMC
    */

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $peso = $_POST["peso"];
        $altura = $_POST["altura"];

        // Función para calcular el IMC
        function calcularIMC($peso, $altura) {
            return $peso / ($altura * $altura);
        }

        // Función para determinar la categoría del IMC
        function determinarCategoriaIMC($imc) {
            if ($imc < 18.5) {
                return "Por debajo del peso";
            } elseif ($imc >= 18.5 && $imc <= 24.9) {
                return "Saludable";
            } elseif ($imc >= 25 && $imc <= 29.9) {
                return "Sobrepeso";
            } else {
                return "Obesidad";
            }
        }

        $imc = calcularIMC($peso, $altura);
        $categoria_imc = determinarCategoriaIMC($imc);

        // Impresion a pantalla
        echo "<h3>Tu IMC es: " . number_format($imc, 2) . "</h3>";
        echo "<h3>Estás en la categoría: $categoria_imc</h3>";
    }
    ?>
</body>
</html>