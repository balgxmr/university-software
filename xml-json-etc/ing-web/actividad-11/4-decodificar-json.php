<?php
  $json = '
  {
    "coord": {
      "lon": -0.9,
      "lat": 38.06
    },
    "sys": {
      "message": 0.0991,
      "country": "Spain",
      "sunrise": 1392619830,
      "sunset": 1392659075
    },
    "weather": [
      {
        "id": 801,
        "main": "Clouds",
        "description": "few clouds",
        "icon": "02n"
      }
    ],
    "base": "cmc stations",
    "main": {
      "temp": 288.15,
      "pressure": 1012,
      "humidity": 72,
      "temp_min": 288.15,
      "temp_max": 288.15
    },
    "wind": {
      "speed": 5.1,
      "deg": 60
    },
    "rain": {
      "3h": 0
    },
    "clouds": {
      "all": 20
    },
    "dt": 1392661800,
    "id": 2513076,
    "name": "Bigastro",
    "cod": 200
  }
  ';

// El parámetro 'true' es para que los datos se decodifiquen como un array asociativo.
// Si no se usa 'true' obtengo el siguiente Error:
//        Fatal error: Uncaught Error: Cannot use object of type stdClass as array
$ciudad = json_decode($json, true);

echo "<h1>Datos de la Ciudad</h1>";
echo "<p><b>Ciudad:</b> " . $ciudad['name'] . "</p>";
echo "<p><b>Estado del cielo:</b> " . $ciudad['weather'][0]['main'] . "</p>";
echo "<p><b>Descripción:</b> " . $ciudad['weather'][0]['description'] . "</p>";
echo "<p><b>Temperatura:</b> " . $ciudad['main']['temp'] . " K</p>"; // K de temperatura kelvin
echo "<p><b>Presión:</b> " . $ciudad['main']['pressure'] . " hPa</p>";  // hPa medida de presión (hectopascal)
echo "<p><b>Humedad:</b> " . $ciudad['main']['humidity'] . " %</p>"; // pporcentaje de humedad