/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrandodatosporcombo.dao;

import filtrandodatosporcombo.conexion.Conexion;
import filtrandodatosporcombo.modelo.ComboArea;
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
public class ComboAreaDAO {
    private Connection connection;
    
    public ComboAreaDAO() {
        connection = Conexion.getConnection();
    }
    
    public  Vector<ComboArea>  ListaDeObjetosParaComboBoxArea() {
                try 
                    {     
                          ResultSet resultado;
                          Statement sentencia;                          
                          sentencia=connection.createStatement();
                          resultado=sentencia.executeQuery("SELECT * FROM area");
                                            
                         Vector<ComboArea> data=new Vector<ComboArea>();                         
                         
    
                           if(resultado.next())
                             {   
                             do 
                               { 
                                   
                                 ComboArea oListaTemporal = new ComboArea(resultado.getInt(1), resultado.getString(2));
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
    
    /* public List<ComboArea> listarAreas(){
        List<ComboArea> areas = new ArrayList<ComboArea>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from areas");
            while (rs.next()) {
                ComboArea area = new ComboArea();
                area.setId_area(rs.getInt("id_area"));
                area.setDescripcion(rs.getString("descripcion"));
                
                
                areas.add(area);
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return areas; 
    } */
}
