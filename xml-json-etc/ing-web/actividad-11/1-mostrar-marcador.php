<?php

if(!$xml = simplexml_load_file('1-marcadores.xml')){
  echo "No se ha podido cargar el archivo";
} else {
  echo "<h1>Lista de Marcadores</h1>";
  echo "<table border='1' style='width:100%; text-align:left;'>";

  echo "<tr>";
  echo "<th>Nombre</th>";
  echo "<th>Descripción</th>";
  echo "<th>URL</th>";
  echo "</tr>";

  // Recorrer cada marcador en el XML y mostrarlo en la tabla
  foreach ($xml->marcador as $bookmark) {
      echo "<tr>";
      echo "<td>" . $bookmark->name . "</td>";
      echo "<td>" . $bookmark->description . "</td>";
      echo "<td><a href='" . $bookmark->url . "'>" . $bookmark->url . "</a></td>";
      echo "</tr>";
  }

  echo "</table>";
}
?>
