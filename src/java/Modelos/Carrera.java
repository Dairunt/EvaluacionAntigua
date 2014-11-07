package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrera 
{
    String idCarrera;
    String nombreCarrera;
    
    Connection conn;
    Statement sentencia;
    ResultSet resultado;
    String url="jdbc:mysql://localhost:3306/duoc";
    
    public Carrera()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String agregarCarrera(String idCarrera, String nombreCarrera)
    {
        String consulta = "insert into carreras values ("+idCarrera+
                                                      ",'"+nombreCarrera+")";
        
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
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
        else
            return "NO FUE POSIBLE LA CONEXION";
    }

    public Carrera(String idCarrera, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }


    public ArrayList<Carrera> obtieneCarreras(int idCarrera)
    {
        String consulta = "select * from carreras where idCarrera = " + idCarrera;
        ArrayList<Carrera> arrAlumnos = new ArrayList<Carrera>();
        
        try {
            sentencia = conn.createStatement();
            resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                arrAlumnos.add(new Carrera(resultado.getString("idCarrera"), 
                                           resultado.getString("nombreCarrera")));
            }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrAlumnos;
    }
    
    
    
}
