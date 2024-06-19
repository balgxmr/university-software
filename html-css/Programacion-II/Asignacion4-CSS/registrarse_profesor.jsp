<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style2.css">
	<meta charset="ISO-8859-1">
	<title>Registro Profesor</title>
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
    String materia = request.getParameter("materia");
    String centro_regional = request.getParameter("centro_regional");
    String experiencia = request.getParameter("experiencia");

    // Inicializando variables
    Connection conexion = null;
    PreparedStatement orden = null;
    
    try {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establecer la conexion con la base de datos MySQL
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdasign4", "root", "");

        // SQL para insertar los datos
        String orden_sql = "INSERT INTO profesor (nombre, cedula, materia, centro_regional, experiencia) VALUES (?, ?, ?, ?, ?)";
        
        // Preparar la declaracion
        orden = conexion.prepareStatement(orden_sql);
        
        // Crear los valores
        orden.setString(1, nombre);
        orden.setString(2, cedula);
        orden.setString(3, materia);
        orden.setString(4, centro_regional);
        orden.setString(5, experiencia);
        
        // Ejecutar la insercion
        int filasInsertadas = orden.executeUpdate();
        
        // Mostrar mensaje de exito o error
        if (filasInsertadas > 0) {
            out.println("<h2>REGISTRO EXITOSO</h2>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Cedula: " + cedula + "</p>");
            out.println("<p>materia " + materia + "</p>");
            out.println("<p>Centro Regional: " + centro_regional + "</p>");
            out.println("<p>Experiencia en clases virtuales: " + experiencia + "</p>");
        } else {
            response.sendRedirect("registro.jsp?error=Hubo un error en el registro. Por favor, intente nuevamente.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("registro.jsp?error=Hubo un error en el registro. Por favor, intente nuevamente.");
    } finally {
        // Cerrar la conexión
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
