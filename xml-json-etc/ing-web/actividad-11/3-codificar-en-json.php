<?php
  $ciudades = array(
    "Osaka" => array(
      "pais" => "Japón",
      "continente" => "Asia",
    ),
    "Melbourne" => array(
      "pais" => "Australia",
      "continente" => "Oceanía",
    ),
    "Amsterdam" => array(
      "pais" => "Holanda",
      "continente" => "Europa",
    ),
    "Toronto" => array(
      "pais" => "Canadá",
      "continente" => "América",
    ),
    "Frankfurt" => array(
      "pais" => "Alemania",
      "continente" => "Europa",
    ),
    "Ginebra" => array(
      "pais" => "Suiza",
      "continente" => "Europa",
    ),
    "Vancouver" => array(
      "pais" => "Canadá",
      "continente" => "América",
    ),
    "Zurich" => array(
      "pais" => "Suiza",
      "continente" => "Europa",
    ),
    "Copennhague" => array(
      "pais" => "Dinamarca",
      "continente" => "Europa",
    ),
    "Viena" => array(
      "pais" => "Austria",
      "continente" => "Europa",
    ),
  );

  // Codificamos elarray ciudades en JSON con json_encode();
  // *JSON_PRETTY_PRINT sirve para formatear de forma más bonita el código Json, con saltos de linea y tal.
  $jsonCiudades = json_encode($ciudades, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE );

  echo '<h1 style="font-family: Arial;">Ciudades y a qué país/continente pertenecen</h1>';
  echo '<p style="font-family: Arial;">Se ha utilizado <b> JSON_PRETTY_PRINT </b> para mostrar la impresión de manera correcta en formato JSON y también <b> JSON_UNESCAPED_UNICODE </b> para mostrar algunos caracteres correctamente como las palabras con tílde.. ';
  echo "<pre>$jsonCiudades</pre>";