package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno 
{
    String rutAlumno;
    char dv;
    String nombres;
    String apellidos;
    char sexo;
    String idCarrera;
    
    Connection conn;
    Statement sentencia;
    ResultSet resultado;
    String url="jdbc:mysql://localhost:3306/duoc";
    
    public Alumno()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String agregarAlumno(String rutAlumno, char dv, String nombres, String apellidos, char sexo, String idCarrera)
    {
        String consulta = "insert into alumnos values ("+rutAlumno+
                                                      ",'"+dv+"',"+
                                                      ",'"+nombres+"',"+
                                                      ",'"+apellidos+"',"+
                                                      ",'"+sexo+"',"+
                                                           idCarrera+")";
        
        if (conn!=null)
        {
            try {
                sentencia = conn.createStatement();
                int exito = sentencia.executeUpdate(consulta);
                if (exito>0)
                    return "Se agregó alumno.";
                else
                    return "No se pudo agregar alumno";
                
            } catch (SQLException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
        else
            return "NO FUE POSIBLE LA CONEXION";
    }

    public Alumno(String rutAlumno, char dv, String nombres, String apellidos, char sexo, String idCarrera) {
        this.rutAlumno = rutAlumno;
        this.dv = dv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.idCarrera = idCarrera;
    }

    public String getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public ArrayList<Alumno> obtieneAlumnos()
    {
        String consulta = "select * from alumnos where idCarrera = " + idCarrera;
        ArrayList<Alumno> arrAlumnos = new ArrayList<Alumno>();
        
        try {
            sentencia = conn.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                arrAlumnos.add(new Alumno(resultado.getString("rutAlumno"),
                                          resultado.getString("dv").charAt(0),
                                          resultado.getString("nombres"),
                                          resultado.getString("apellidos"),
                                          resultado.getString("sexo").charAt(0),
                                          resultado.getString("idCarrera")));
            }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrAlumnos;
    }
    
    
    
}
