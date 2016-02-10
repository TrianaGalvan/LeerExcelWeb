/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Pregunta {
    private String pregunta; 
    private List<FrecuenciaPalabra> palabras; 

    public Pregunta() {
        palabras = new ArrayList();
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<FrecuenciaPalabra> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<FrecuenciaPalabra> palabras) {
        this.palabras = palabras;
    }
    
    public JRBeanCollectionDataSource getPalabrasCollection(){
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(palabras);
        return itemsJRBean;
    }
    
}
