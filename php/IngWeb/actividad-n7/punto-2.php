<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">;
  <title>Punto #2</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>

<body>
    <h2>Calcular Salario Semanal del Trabajador</h2>
    
    <form action="" method="post">
        <label for="horas_trabajadas">Horas trabajadas:</label>
        <input type="number" name="horas_trabajadas" id="horas_trabajadas" required>
        <input type="submit" value="Calcular Salario">
    </form>

    <?php
    /* 
      2.	Cree un programa que permita calcular el salario semanal de unos empleados a los que se les paga $15 por hora si éstas no superan las 35 horas. Cada hora por encima de 35 se considerará extra y se paga a $22. El programa debe pedir las horas trabajadas por el trabajador y devolver el salario que se le debe pagar  
    */

    // Verificar si se ha enviado el formulario y si el campo "horas_trabajadas" está definido
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $horas_trabajadas = $_POST["horas_trabajadas"];
        $pago_regular = 15;
        $pago_extra = 22;
        $limite_horas = 35;

        // Función para calcular el salario semanal
        function calcularSalario($horas_trabajadas, $pago_regular, $pago_extra, $limite_horas) {
            if ($horas_trabajadas <= $limite_horas) {
                // Si las horas no superan las 35, solo se paga a tarifa regular
                return $horas_trabajadas * $pago_regular;
            } else {
                // Calcular salario para horas extras
                $horas_extras = $horas_trabajadas - $limite_horas;
                $salario_regular = $limite_horas * $pago_regular;
                $salario_extra = $horas_extras * $pago_extra;
                return $salario_regular + $salario_extra;
            }
        }

        // Llamar a la función y mostrar el resultado
        $salario_semanal = calcularSalario($horas_trabajadas, $pago_regular, $pago_extra, $limite_horas);
        echo "<h3>El salario semanal es: $" . number_format($salario_semanal, 2) . "</h3>";
    }
    ?>
</body>
</html>