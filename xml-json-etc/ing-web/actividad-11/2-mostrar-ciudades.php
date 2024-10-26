<?php
  if(!$xml = simplexml_load_file('2-ciudades.xml')){
    echo "No se ha podido cargar el archivo XML...";
  } else {
    echo "<h1>Lista de Ciudades</h1>";
    echo "<table border='1' style='width:100%; text-align: center ;'>";
    echo "<tr><th colspan='3'>Ciudades</th></tr>";
    echo "<tr>";
    echo "<th>Nombre</th>";
    echo "<th>País</th>";
    echo "<th>Continente</th>";
    echo "</tr>";

    foreach($xml->ciudad as $ciudad){
      echo "<tr>";
      echo "<td>" . $ciudad -> nombre . "</td>";
      echo "<td>" . $ciudad -> pais . "</td>";
      echo "<td>" . $ciudad['continente'] . "</td>";
      echo "</tr>";
    }
  }