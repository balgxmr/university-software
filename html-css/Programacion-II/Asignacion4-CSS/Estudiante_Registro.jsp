<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style2.css">
	<meta charset="ISO-8859-1">
	<title>Registro Estudiante</title>
	</head>
<body>
    <header class="container1_home">
            <img src="img/Logo_UNIV.png" width="240px" height="150px">
        
            <div class="container2_home">
                <h1>Universidad Pueblo</h1>
            <H2>Universidad tecnica en electrica, mecanica, construccion</H2>
        </div>
       </header>
       
        <main style="
	display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    width: 100%;">
  
        <div class="container1_prof">
       

<%
    // Obtener los parametros del formulario
    String nombre = request.getParameter("nombre");
    String cedula = request.getParameter("cedula");
    String ano_electivo = request.getParameter("ano_electivo");
    String centro_regional = request.getParameter("centro_regional");
    String[] cursosArray = request.getParameterValues("cursos");

    // Convertir el array de herramientas a una cadena separada por comas
    String cursos = "";
    if (cursosArray != null) {
        cursos = String.join(", ", cursosArray);
    }

    // Inicializando variables
    Connection conexion = null;
    PreparedStatement orden = null;
    
    try {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
     	// Establecer la conexion con la base de datos MySQL
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdasign4", "root", "");

        // SQL para insertar los datos
        String orden_sql = "INSERT INTO estudiante (nombre, cedula, ano_electivo , centro_regional, cursos) VALUES (?, ?, ?, ?, ?)";
        
        // Preparar la declaracion
        orden = conexion.prepareStatement(orden_sql);
        
        // Crear los valores
        orden.setString(1, nombre);
        orden.setString(2, cedula);
        orden.setString(3, ano_electivo);
        orden.setString(4, centro_regional);
        orden.setString(5, cursos);
        
        // Ejecutar la insercion
        int filasInsertadas = orden.executeUpdate();
        
        // Mostrar mensaje de exito o error
        if (filasInsertadas > 0) {
            out.println("<h2>REGISTRO EXITOSO</h2>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Cedula: " + cedula + "</p>");
            out.println("<p>ano_electivo: " + ano_electivo + "</p>");
            out.println("<p>Centro Regional: " + centro_regional + "</p>");
            out.println("<p>cursos: " + cursos + "</p>");
        } else {
            out.println("<h2>Hubo un error en el registro. Por favor, intente nuevamente.</h2>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h2>Hubo un error en el registro. Por favor, intente nuevamente.</h2>");
    } finally {
        // Cerrar la conexi�n
        if (orden != null) 
        	try { 
        		orden.close(); 
        		} catch (SQLException ignore) {}
        if (conexion != null) 
        	try { 
        		conexion.close(); 
        		} catch (SQLException ignore) {}
    }
%>
	</div>

    <a href="home.html"><button class="button1">Regresar a HOME</button> </a>
	</main>

     
	
</body>
</html>
