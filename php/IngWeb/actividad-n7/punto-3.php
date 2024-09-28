<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Punto #3</title>
  <link rel="stylesheet" href="./assets/style.css">
</head>
<body>
    <h2>Calcular Pago Final en la Librería</h2>
    
    <form action="" method="post">
        <label for="nombre">Nombre del Cliente:</label>
        <input type="text" name="nombre" id="nombre" required><br><br>

        <label for="tipo_cliente">Tipo de Cliente (1, 2 o 3):</label>
        <input type="number" name="tipo_cliente" id="tipo_cliente" min="1" max="3" required><br><br>

        <label for="precio">Precio del Artículo ($):</label>
        <input type="number" name="precio" id="precio" step="0.01" required><br><br>

        <input type="submit" value="Calcular Pago Final">
    </form>

    <?php
    
    /* 
      3.	En una librería se venden artículos con las siguientes condiciones:
        a.	Sí el cliente es de tipo 1 se le descuenta 30% 
        b.	Sí el cliente es de tipo 2 se le descuenta 20% 
        c.	Sí el cliente es de tipo 3 se le descuenta 10% 
        
        Escribir un algoritmo que almacene en variables el nombre del cliente, tipo de cliente y precio del artículo. Además permitir que realice el cálculo del pago final que el cliente debe realizar y lo muestre en pantalla. 
        
        NOTA: los porcentajes de descuento deben ser declarados como constantes.
    */


    // Verificar si se ha enviado el formulario
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nombre = $_POST["nombre"];
        $tipo_cliente = $_POST["tipo_cliente"];
        $precio_articulo = $_POST["precio"];

        // Se definen las constantes para los descuentos
        define("DESCUENTO_TIPO1", 0.30);
        define("DESCUENTO_TIPO2", 0.20);
        define("DESCUENTO_TIPO3", 0.10);

        // Función para calcular el pago final
        function calcularPagoFinal($tipo_cliente, $precio_articulo) {
            switch ($tipo_cliente) {
                case 1:
                    $descuento = DESCUENTO_TIPO1;
                    break;
                case 2:
                    $descuento = DESCUENTO_TIPO2;
                    break;
                case 3:
                    $descuento = DESCUENTO_TIPO3;
                    break;
                default:
                    $descuento = 0;
                    break;
            }
            $precio_final = $precio_articulo - ($precio_articulo * $descuento);
            return $precio_final;
        }

        // Llamada a la función para el pago final
        $pago_final = calcularPagoFinal($tipo_cliente, $precio_articulo);

        // Impresión apantala
        echo "<h3>Cliente: $nombre</h3>";
        echo "<h3>Tipo de Cliente: $tipo_cliente</h3>";
        echo "<h3>Precio del Artículo: $" . number_format($precio_articulo, 2) . "</h3>";
        echo "<h3>Pago Final con Descuento: $" . number_format($pago_final, 2) . "</h3>";
    }
    ?>
</body>
</html>