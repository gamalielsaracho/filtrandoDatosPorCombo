/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrandodatosporcombo.modelo;

/**
 *
 * @author Usuario
 */
public class ComboArea {
    private String descripcion;
    private int id_seccion;
    private int id_area; 
    
     public ComboArea(int id_area, String descripcion) {
        this.id_area = id_area;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

   
    public String toString() {
     return descripcion;
    }
    
    
}
