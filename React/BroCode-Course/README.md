# React - by BroCode

React es una librería de Javascript, NO un framework, que se usa para construir facilmente y ordenar interfaces web para aplicaciones web.

Se usan componentes, que son como bloques que son reutilizables. Podemos pensar de estos como LEGOs, utilizando mucho de estos LEGOs podemos hacer diferentes estructuras. Pues lo mismo con React.

React usa un DOM virtual, una versión ligera del DOM real.

## Assets folder vs Public folder

Assets folder es similar al folder public, con la diferencia de que Assets serán desplegados en el output final. En el Public folder lo que esté dentro NO está desplegado durante el output final y generalmente está disponible mediante URLs (algo asi... xd)

# Instalación

Instalar node.js desde https://nodejs.org/

## Comandos

Una vez instalado procedemos a introducir los siguientes comandos en la terminal (en este caso de VSCode)

\*\* En caso de que bash no detecte npm: CTRL + P, y escribir `ext install npm script runner`, instalar la extensión y reiniciar VSCode.

`npm create vite@latest`

Introducimos el nombre del proyecto. Por ejemplo: my-react-app

Luego seleccionamos el framework, pues acá, Javascript.

Luego seleccionamos Javascript a secas.

`cd my-react-app`

`npm install`

`npm run dev`

Luego copiamos la IP y la pegamos en el navegador! :)

## Para reiniciar el server, si lo cerramos

Nos aseguramos que estemos adentro de la carpeta (my-react-app o el nombre que hayas puesto)

`npm run dev`

Listo.
