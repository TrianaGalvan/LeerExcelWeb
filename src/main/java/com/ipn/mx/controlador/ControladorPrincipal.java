/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import entidades.FrecuenciaPalabra;
import entidades.Pregunta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ControladorPrincipal{
    
    public OutputStream cargarExcel(InputStream is,String ruta,OutputStream out) {
        Workbook workbook; 
        Sheet sheet = null; 
        try {
            WorkbookSettings opciones= new WorkbookSettings();
            opciones.setEncoding("iso-8859-1");
            workbook = Workbook.getWorkbook(is, opciones);
            sheet = workbook.getSheet(0);  
        } catch (IOException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //almacena las preguntas
        List preguntas = new ArrayList<Pregunta>();
        
        for (int columna = 0; columna < sheet.getColumns(); columna++) {
            //palabras referentes a la preguunta
            List palabras = new ArrayList<FrecuenciaPalabra>();
            //se crea una nueva pregunta por cada columna 
            Pregunta preg = new Pregunta();
            //obtener la pregunta 
            Cell titulo =  sheet.getCell(columna, 0);
            String tituloP = titulo.getContents();
            preg.setPregunta(tituloP);
            for (int fila = 0; fila < sheet.getRows(); fila++) { 
                Cell contenido =  sheet.getCell(columna, fila);
                String texto = contenido.getContents();
                String textoWithCapital = texto.substring(0, 1).toUpperCase() + texto.substring(1);
                //saltarse la fila de  la pregunta
                if(fila != 0){
                    //verificar si ya existe la palabra 
                    if(!encontrarPalabra(textoWithCapital,palabras)){
                        //si no existe agregarla 
                        //generar una nueva palabra con su frecuencia INICIAL
                        FrecuenciaPalabra fp = new FrecuenciaPalabra();
                        fp.setFrecuencia(1);
                        fp.setPalabra(textoWithCapital);
                        //agregarla a la lista de palabras frecuencia
                        palabras.add(fp);
                    }
                } 
            }
            preg.setPalabras(palabras);
            preguntas.add(preg);
        }
        return generarReporte(preguntas,ruta,out);
    }

       public static  boolean encontrarPalabra(String palabra,List<FrecuenciaPalabra> palabras){
        boolean res = false; 
        if(palabras != null){
            for(FrecuenciaPalabra fp: palabras){
                if(palabra.equals(fp.getPalabra())){
                    fp.aumentarFrecuencia();
                    res = true; 
                    break;
                }   
            }
        }
        return res;
    }
       
    private static OutputStream generarReporte(List lista,String path,OutputStream out) {
         /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(lista);
        
         /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("lista", itemsJRBean);
        OutputStream outputStream = null;
        try {
            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, itemsJRBean);
            
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdf(jasperPrint);
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            System.out.println("File Generated");
        } catch (JRException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return outputStream;
    }

}
