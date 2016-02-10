/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.servlets;

import com.ipn.mx.controlador.ControladorPrincipal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class LogicaArchivos extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
        *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtener el archivo 
        Part excel =  (Part) request.getPart("excel");
        //nombre del archivo 
        String nombre = request.getParameter("nombre");
        
        InputStream is = null; 
        
        //obtener la ruta dinamica del  reporte(.jasper)
        ServletContext servletContext = getServletContext();
        //URL url = servletContext.getResource("WEB-INF/ReportesPalabras.jasper");
        String fullpath = servletContext.getRealPath("WEB-INF/ReportesPalabras.jasper");        
        
        //obtener el excel de la petición
        is = excel.getInputStream();
        
        //generar pdf con el excel del cliente
        ControladorPrincipal cp = new ControladorPrincipal(); 
        
        //inicializando respuesta
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition","attachment; filename='reporte.pdf'");
        
        //escribir archivo en la respuesta
        ServletOutputStream outStream = response.getOutputStream();
        cp.cargarExcel(is, fullpath,outStream);
        /*int sizePDF  = outStream.toString().getBytes("UTF-8").length;
        byte[] byteOutput = new byte[sizePDF];
        byteOutput = outStream.toString().getBytes("UTF-8");*/        
        outStream.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
