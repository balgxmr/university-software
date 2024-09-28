<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Punto #1</title>
    <link rel="stylesheet" href="./assets/style.css">
</head>
<body>
    <h2>Calcular Sueldo del Trabajador</h2>
    
    <form action="" method="post">
        <label for="anos_trabajados">Años trabajados:</label>
        <input type="number" name="anos_trabajados" id="anos_trabajados" required>
        <input type="submit" value="Calcular Sueldo">
    </form>

    <?php

    /* 
      1.	Realice un programa que calcule el sueldo que le corresponde al trabajador de una empresa que cobra $40.000 anuales, el programa debe realizar los cálculos en función de los siguientes criterios:  
        a.	Si lleva más de 10 años en la empresa se le aplica un aumento del 10%. 
        b.	Si lleva menos de 10 años pero más que 5 se le aplica un aumento del 7%. 
        c.	Si lleva menos de 5 años pero más que 3 se le aplica un aumento del 5%. 
        d.	Si lleva menos de 3 años se le aplica un aumento del 3%. 
    */

    // Verificar si se ha enviado el formulario
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $anos_trabajados = $_POST["anos_trabajados"];

        // Función para calcular el sueldo
        function calcularSueldo($anos_trabajados) {
            $sueldo_base = 40000; // Sueldo anual base

            if ($anos_trabajados > 10) {
                $aumento = 0.10; // 10%
            } elseif ($anos_trabajados > 5) {
                $aumento = 0.07; // 7%
            } elseif ($anos_trabajados > 3) {
                $aumento = 0.05; // 5%
            } else {
                $aumento = 0.03; // 3%
            }
            $sueldo_final = $sueldo_base + ($sueldo_base * $aumento);
            return $sueldo_final;
        }

        // Se llama la función y imprime el resultado
        $sueldo_final = calcularSueldo($anos_trabajados);
        echo "<h3>El sueldo final es: $" . number_format($sueldo_final, 2) . "</h3>";
    }
    ?>
</body>
</html>
