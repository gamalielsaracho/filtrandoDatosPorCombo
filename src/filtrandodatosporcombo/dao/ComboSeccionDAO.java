/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrandodatosporcombo.dao;

import filtrandodatosporcombo.conexion.Conexion;
import filtrandodatosporcombo.modelo.ComboSeccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class ComboSeccionDAO {
    private Connection connection;
    
    public ComboSeccionDAO() {
        connection = Conexion.getConnection();
    } 
    
    public  Vector<ComboSeccion>  ListaDeObjetosParaComboBoxSeccionByIdArea(int idArea) {
                try 
                    {     
                          ResultSet resultado;
                          Statement sentencia;                          
                          sentencia=connection.createStatement();
                          resultado=sentencia.executeQuery("select * from seccion WHERE id_area = "+idArea);
                                            
                         Vector<ComboSeccion> data=new Vector<ComboSeccion>();                         
                         
    
                           if(resultado.next())
                             {   
                             do 
                               { 
                                   
                                 ComboSeccion oListaTemporal = new ComboSeccion(resultado.getInt(1), resultado.getString(2));
                        	//System.out.println("oListaTemporal "+resultado.getInt(1));     
                                
                                 data.addElement(oListaTemporal);
                                 
                               }
                            while(resultado.next()); 
                            return data;
                           
                            }
                          else
                        	{ 
                            return null;
                          }            
                    }  
               catch(Exception ex)
                {
                   System.out.print(ex);
                    return null;
                }   
    }
    
    
    /* public List<ComboSeccion> listarSeccionesByIdArea(int idArea){
        List<ComboSeccion> secciones = new ArrayList<ComboSeccion>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from seccion WHERE id_area = "+idArea);
            while (rs.next()) {
                
                ComboSeccion seccion = new ComboSeccion();
                seccion.setId_area(rs.getInt("id_area"));
                seccion.setDescripcion(rs.getString("descripcion"));
                
                
                secciones.add(seccion);
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return secciones;
    } */
}
