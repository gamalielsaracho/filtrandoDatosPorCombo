/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrandodatosporcombo.dao;

import filtrandodatosporcombo.conexion.Conexion;
import filtrandodatosporcombo.modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmpleadoDAO {
    private Connection connection;
    
    public EmpleadoDAO() {
        connection = Conexion.getConnection();
    }
    
    public List<Empleado> listarEmpleadosByIdSeccion(int idSeccion){
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from empleados WHERE id_seccion = "+idSeccion);
            while (rs.next()) {
                
                Empleado empleado = new Empleado();
                empleado.setCi(rs.getInt("ci"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                
                
                
                empleados.add(empleado);
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return empleados;
    }
}
