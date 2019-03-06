/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelo.DAOs.DAOFactory;
import modelo.DAOs.PersonaDAO;
import modelo.DTOs.PersonaDTO;
import modelo.DTOs.VehiculoDTO;
import modelo.DAOs.VehiculoDAO;
import util.MyDataSourceFactory;

/**
 *
 * @author sala8
 */
public class ControladorBienvenida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Llegue al controlador....");
        
        String id = request.getParameter("identificacion");
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String fechana = request.getParameter("fechana");
        String tipop = request.getParameter("tipop");
        
        String placaV = request.getParameter("Placa");
        String tipoV = request.getParameter("Tipo");
        String colorV = request.getParameter("Color");
        String precioV = request.getParameter("Precio");
        String marcaV = request.getParameter("Marca");
        
        PersonaDTO persona = new PersonaDTO();
        persona.setIdentificacion(id);
        persona.setNombre_1(nombre1);
        persona.setNombre_2(nombre2);
        persona.setApellido_1(apellido1);
        persona.setApellido_2(apellido2);
        persona.setGenero(genero);
        persona.setTelefono(telefono);
        persona.setEmail(email);
        persona.setFecha_nacimiento(fechana);
        persona.setTipo_persona(tipop);
        
        VehiculoDTO vehiculo = new VehiculoDTO();
        vehiculo.setPlaca(placaV);
        vehiculo.setTipo(tipoV);
        vehiculo.setColor(colorV);
        vehiculo.setPrecio(precioV);
        vehiculo.setMarca(marcaV);
        
        DataSource ds = null;
        
        ds = MyDataSourceFactory.getMySQLDataSource();
        
        PersonaDAO pbd = (PersonaDAO) DAOFactory.getDAOFactory(1);
        pbd.insert(ds, persona);
        
        VehiculoDAO vbd = (VehiculoDAO) DAOFactory.getDAOFactory(1);
        vbd.insert(ds,vehiculo);
        
        System.out.println("nombre: " +  nombre1);
        System.out.println("DataSource: " +  ds);
        
        System.out.println("placa: " +  placaV);
        System.out.println("DataSource: " +  ds);
        
        request.setAttribute("parametroservlet", nombre1);
        RequestDispatcher rd = request.getRequestDispatcher("./paginas/respuesta.jsp");
        rd.forward(request, response);
        
        request.setAttribute("parametroservlet", placaV);
        RequestDispatcher vh = request.getRequestDispatcher("./paginas/respuesta.jsp");
        vh.forward(request, response);
        
        //response.sendRedirect("./paginas/respuesta.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
