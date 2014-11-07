package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Categoria 
{
    int idCategoria;
    String nombreCategoria;
    
    Statement sentencia;
    Connection conn;
    ResultSet resultado;
    String url="jdbc:mysql://localhost:3306/duoc";

    public Categoria() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Categoria(int idCategoria, String nombreCategoria) 
    {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
    
    public ArrayList<Categoria> obtieneCategorias()
    {
        String consulta = "select * from categorias";
        ArrayList<Categoria> arrCategorias = new ArrayList<Categoria>();
        
        if (conn != null)
        {
            try {
                sentencia = conn.createStatement();
                resultado = sentencia.executeQuery(consulta);
                
                while (resultado.next())
                {
                    arrCategorias.add(new Categoria(Integer.parseInt(resultado.getString("idCategoria")),
                                                    resultado.getString("nombreCategoria")));
                    
                }
                return arrCategorias;
                
            } catch (SQLException ex) {
                Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        else
            return null;
        
        
        
        
    }
    
    
    
    
    
}
