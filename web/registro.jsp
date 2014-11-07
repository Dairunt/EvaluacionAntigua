<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de Alumnos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Ingrese datos del Alumno</h1>
        <form action="ingresaralumno.do" method="post">
            RUT <input type="text" name="txtRut"> <input type="text" name="txtDv" size="1"><br>
            Nombres <input type="text" name="txtNombres"><br>
            Apellidos <input type="text" name="txtApellidos"><br>
            Sexo    <input type="radio" name="sexo" value="masculino"> Masculino
                    <input type="radio" name="sexo" value="femenino"> Femenino
            Carrera <input type="combobox" name="txtCarrera"><br>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
