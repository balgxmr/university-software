<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #7</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>

<body>
  <h2>
    Tabla con números del 1-100
  </h2>

  <table>
        <tr>
            <?php
            /* 
              7.	Mostrar una tabla rellenado con los números del 1 al 100.
            */

            // Inicializar un contador para los números
            $contador = 1;

            // Bucle para mostrar los números del 1 al 100 en filas de 10 columnas
            for ($i = 1; $i <= 100; $i++) {
                echo "<td>$i</td>";  // Mostrar el número en una celda de la tabla
                // Cuando se impriman 10 números, finaliza la fila y empieza  otra, de esta forma está ordenada
                if ($i % 10 == 0) {
                    echo "</tr><tr>"; //Cierra con </tr> y abre otra <tr>
                }
            }
            ?>
        </tr>
    </table>
</body>
</html>