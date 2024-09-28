<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #4</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>

<body>
    <h2>Determina tu Signo Zodiacal :o</h2>

    <form action="" method="post">
        <label for="mes">Mes de Nacimiento (1-12):</label>
        <input type="number" name="mes" id="mes" min="1" max="12" required><br><br>

        <label for="dia">Día de Nacimiento (1-31):</label>
        <input type="number" name="dia" id="dia" min="1" max="31" required><br><br>

        <input type="submit" value="Determinar Signo">
    </form>

    <?php

    /* 
      4.	Elabore un programa en el que se le solicite a un usuario el mes y el día de su cumpleaños, el programa debe determine su signo zodiacal e imprimirlo en pantalla.
    */

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $mes = $_POST["mes"];
        $dia = $_POST["dia"];

        // Función para determinar el signo zodiacal...
        function obtenerSignoZodiacal($mes, $dia) {
            if (($mes == 1 && $dia >= 20) || ($mes == 2 && $dia <= 18)) {
                return "Acuario";
            } elseif (($mes == 2 && $dia >= 19) || ($mes == 3 && $dia <= 20)) {
                return "Piscis";
            } elseif (($mes == 3 && $dia >= 21) || ($mes == 4 && $dia <= 19)) {
                return "Aries";
            } elseif (($mes == 4 && $dia >= 20) || ($mes == 5 && $dia <= 20)) {
                return "Tauro";
            } elseif (($mes == 5 && $dia >= 21) || ($mes == 6 && $dia <= 20)) {
                return "Géminis";
            } elseif (($mes == 6 && $dia >= 21) || ($mes == 7 && $dia <= 22)) {
                return "Cáncer";
            } elseif (($mes == 7 && $dia >= 23) || ($mes == 8 && $dia <= 22)) {
                return "Leo";
            } elseif (($mes == 8 && $dia >= 23) || ($mes == 9 && $dia <= 22)) {
                return "Virgo";
            } elseif (($mes == 9 && $dia >= 23) || ($mes == 10 && $dia <= 22)) {
                return "Libra";
            } elseif (($mes == 10 && $dia >= 23) || ($mes == 11 && $dia <= 21)) {
                return "Escorpio";
            } elseif (($mes == 11 && $dia >= 22) || ($mes == 12 && $dia <= 21)) {
                return "Sagitario";
            } elseif (($mes == 12 && $dia >= 22) || ($mes == 1 && $dia <= 19)) {
                return "Capricornio";
            } else {
                return "Fecha no válida";
            }
        }

        // Valor de prueba mio: mes 7, dia 14, resultado = Cáncer. Correcto.
        // Valor de prueba padre: mes: 3, dia 22, resultado = Aries. COrrecto

        // Llamar a la función para determinar el signo
        $signo = obtenerSignoZodiacal($mes, $dia);

        // Mostrar el resultado
        echo "<h3>Tu signo zodiacal es: $signo</h3>";
    }
    ?>
</body>

</html>