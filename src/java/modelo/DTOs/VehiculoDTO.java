/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DTOs;

/**
 *
 * @author sala1
 */
public class VehiculoDTO {
    
    String placaV = "";
    String marcaV ="";
    String precioV = "";
    String colorV = "";
    String tipoV = "";
    
      public String getPlaca() {
        return placaV;
    }

    public void setPlaca(String Placa) {
        this.placaV = Placa;
    }
    
    public String getMarca(String Marca) {
        return marcaV;
    }

    public void setMarca(String Marca) {
        this.marcaV = Marca;
    }


    public String getTipo() {
        return tipoV;
    }

    public void setTipo(String Tipo) {
        this.tipoV = Tipo;
    }

    public String getColor() {
        return colorV;
    }

    public void setColor(String Color) {
        this.colorV= Color;
    }

    public String getPrecio() {
        return precioV;
    }

    public void setPrecio(String Precio) {
        this.precioV = Precio;
    }

  
}
